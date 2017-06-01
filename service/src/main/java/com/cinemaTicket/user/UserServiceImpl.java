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
import com.cinemaTicket.ticket.dtoTicket.TicketDTO;
import com.cinemaTicket.user.role.Role;
import com.cinemaTicket.user.role.RoleRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            return new ResponseEntity<>(new ResponseStatus(false, "no user"),
                    HttpStatus.CREATED);
        }
        Long id = ticketInfo.getShowId();
        CinemaShow cinemaShow = cinemaShowRepository.findOne(ticketInfo.getShowId());
        if (cinemaShow == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no show"),
                    HttpStatus.CREATED);
        }
        Seat seat = seatRepository.findByCinemaRoomAndRowAndNumber(cinemaShow.getCinemaRoom(),
                ticketInfo.getRow(),
                ticketInfo.getNumber());
        if (seat == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no seat"),
                    HttpStatus.CREATED);
        }
        Ticket ticket = ticketRepository.findBySeat(seat);
        if (ticket == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no ticket"),
                    HttpStatus.CREATED);
        }
        if (ticket.getStatus().equals(BOOKED)) {
            return new ResponseEntity<>(new ResponseStatus(false, "booked"),
                    HttpStatus.CREATED);
        }

        if (ticket.getUser() != null) {
            return new ResponseEntity<>(new ResponseStatus(false, "booked"),
                    HttpStatus.CREATED);
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
                    HttpStatus.CREATED);
        }
        String ROLE = "ROLE_USER";
        Role role = roleRepository.findByRole(ROLE);
        if (role == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no role"),
                    HttpStatus.CREATED);

        }
        user.addRole(role);
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseStatus(true, "user created"),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> editUser(String username, UserDTO user) {
        User oldUser = userRepository.findByUsername(user.getUsername());
        logger.info(user.getUsername());
        if (oldUser != null && !oldUser.getId().equals(user.getId())) {
            return new ResponseEntity<>(new ResponseStatus(false, "name already exist"),
                    HttpStatus.CREATED);
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
                    HttpStatus.CREATED);
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
            return new ResponseEntity<>(new ResponseStatus(false, "no user"),
                    HttpStatus.CREATED);
        }

        user.addTicket(ticket);
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseStatus(true, "ticket ordered"),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getUserTickets(String userName) {
        User user = userRepository.findByUsername(userName);
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        if (user == null) {
            return new ResponseEntity<>(ticketDTOList,
                    HttpStatus.CREATED);
        }
        logger.info("userName = " + user.getUsername());
        List<Ticket> ticketList = ticketRepository.findByUser(user);
        for (Ticket ticket : ticketList) {
            TicketDTO ticketDTO = new TicketDTO(ticket);
            ticketDTOList.add(ticketDTO);
        }
        return new ResponseEntity<>(ticketDTOList, HttpStatus.CREATED);
    }
}
