package com.cinemaTicket.ticket;

import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.show.CinemaShow;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    Ticket findBySeat(Seat seat);
    Ticket findBySeatAndCinemaShow(Seat seat, CinemaShow cinemaShow);
}
