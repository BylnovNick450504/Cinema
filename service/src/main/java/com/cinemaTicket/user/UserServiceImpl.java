package com.cinemaTicket.user;

import com.cinemaTicket.cinema.CinemaComment;
import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.seat.SeatRepository;
import com.cinemaTicket.show.CinemaShow;
import com.cinemaTicket.show.CinemaShowRepository;
import com.cinemaTicket.ticket.Ticket;
import com.cinemaTicket.ticket.TicketInfo;
import com.cinemaTicket.ticket.TicketRepository;
import com.cinemaTicket.user.role.Role;
import com.cinemaTicket.user.role.RoleRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CinemaShowRepository cinemaShowRepository;
    private final TicketRepository ticketRepository;
    private final SeatRepository seatRepository;
    private final RoleRepository roleRepository;
    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           CinemaShowRepository cinemaShowRepository,
                           TicketRepository ticketRepository,
                           SeatRepository seatRepository,
                           RoleRepository roleRepository
    ) {
        this.userRepository = userRepository;
        this.cinemaShowRepository = cinemaShowRepository;
        this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public ResponseEntity<?> orderTicket(String userName, TicketInfo ticketInfo) {
        final int BOOKED = 1;
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            return new ResponseEntity<>(new ResponseStatus(false,"no user"),
                                        HttpStatus.BAD_REQUEST);
        }
        Long id = ticketInfo.getShowId();
        CinemaShow cinemaShow = cinemaShowRepository.findOne(ticketInfo.getShowId());
        if (cinemaShow == null) {
            return new ResponseEntity<>(new ResponseStatus(false,"no show"),
                                        HttpStatus.BAD_REQUEST);
        }
        Seat seat = seatRepository.findByCinemaRoomAndRowAndNumber(cinemaShow.getCinemaRoom(),
                                                                   ticketInfo.getRow(),
                                                                   ticketInfo.getNumber());
        if (seat == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no seat"),
                                        HttpStatus.BAD_REQUEST);
        }
        Ticket ticket = ticketRepository.findBySeat(seat);
        if (ticket == null) {
            return new ResponseEntity<>(new ResponseStatus(false,"no ticket"),
                    HttpStatus.BAD_REQUEST);
        }
        if (ticket.getStatus().equals(BOOKED)) {
            return new ResponseEntity<>(new ResponseStatus(false,"booked"),
                    HttpStatus.BAD_REQUEST);
        }

        if (ticket.getUser() != null) {
            return new ResponseEntity<>(new ResponseStatus(false,"booked"),
                    HttpStatus.BAD_REQUEST);
        }

        user.addTicket(ticket);
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseStatus(true, "ordered"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> createUser(User user) {
        User oldUser = userRepository.findByUsername(user.getUsername());
        logger.info(user.getUsername());
        if (oldUser != null) {
            return new ResponseEntity<>(new ResponseStatus(false, "name already exist"),
                                        HttpStatus.BAD_REQUEST);
        }
        String ROLE = "ROLE_USER";
        Role role = roleRepository.findByRole(ROLE);
        if (role == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no role"),
                                        HttpStatus.BAD_REQUEST);

        }
        user.addRole(role);
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseStatus(true, "user created"),
                                    HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> editUser(String username, UserInfo user) {
        User oldUser = userRepository.findByUsername(user.getUsername());
        logger.info(user.getUsername());
        if (oldUser != null) {
            return new ResponseEntity<>(new ResponseStatus(false, "name already exist"),
                    HttpStatus.BAD_REQUEST);
        }
        User editUser = userRepository.findByUsername(username);

        editUser.setEmail(user.getEmail());
        editUser.setName(user.getName());
        editUser.setUsername(user.getUsername());
        logger.info("password" + user.getPassword());
        editUser.setPassword(user.getPassword());
        logger.info("user edited");
        userRepository.save(editUser);
        return new ResponseEntity<>(new ResponseStatus(true, "user edited"),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> createCinemaComment(String username, CinemaComment cinemaComment) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no user"),
                    HttpStatus.BAD_REQUEST);
        }
        user.addCinemaComment(cinemaComment);
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseStatus(true, "cinemaComment created"),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> orderTicket(String userName, CustomSoloRequest ticketId) {
        Ticket ticket = ticketRepository.findOne(ticketId.getId());
        if (ticket == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no ticket"), HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByUsername(userName);
        if (user == null) {
            return new ResponseEntity<>(new ResponseStatus(false,"no user"),
                    HttpStatus.BAD_REQUEST);
        }

        user.addTicket(ticket);
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseStatus(true, "ticket ordered"),
                HttpStatus.CREATED);
    }
}
