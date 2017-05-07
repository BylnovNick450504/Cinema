package com.cinemaTicket.user;

import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.seat.SeatRepository;
import com.cinemaTicket.show.CinemaShow;
import com.cinemaTicket.show.CinemaShowRepository;
import com.cinemaTicket.ticket.Ticket;
import com.cinemaTicket.ticket.TicketInfo;
import com.cinemaTicket.ticket.TicketRepository;
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


    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           CinemaShowRepository cinemaShowRepository,
                           TicketRepository ticketRepository,
                           SeatRepository seatRepository
    ) {
        this.userRepository = userRepository;
        this.cinemaShowRepository = cinemaShowRepository;
        this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public ResponseEntity<?> orderTicket(String userName, TicketInfo ticketInfo) {
        final int BOOKED = 1;
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            return new ResponseEntity<>(new ResponseStatus(false,"no user"),
                                        HttpStatus.NOT_FOUND);
        }
        Long id = ticketInfo.getShowId();
        CinemaShow cinemaShow = cinemaShowRepository.findOne(ticketInfo.getShowId());
        if (cinemaShow == null) {
            return new ResponseEntity<>(new ResponseStatus(false,"no show"),
                                        HttpStatus.NOT_FOUND);
        }
        Seat seat = seatRepository.findByCinemaRoomAndRowAndNumber(cinemaShow.getCinemaRoom(),
                                                                   ticketInfo.getRow(),
                                                                   ticketInfo.getNumber());
        if (seat == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no seat"),
                                        HttpStatus.NOT_FOUND);
        }
        Ticket ticket = ticketRepository.findBySeat(seat);
        if (ticket == null) {
            return new ResponseEntity<>(new ResponseStatus(false,"no ticket"),
                    HttpStatus.NOT_FOUND);
        }
        if (ticket.getStatus().equals(BOOKED)) {
            return new ResponseEntity<>(new ResponseStatus(false,"booked"),
                    HttpStatus.NOT_FOUND);
        }

        if (ticket.getUser() != null) {
            return new ResponseEntity<>(new ResponseStatus(false,"booked"),
                    HttpStatus.NOT_FOUND);
        }

        user.addTicket(ticket);
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
