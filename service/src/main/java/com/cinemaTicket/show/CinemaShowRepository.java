package com.cinemaTicket.show;

import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.ticket.Ticket;
import org.springframework.data.repository.CrudRepository;


public interface CinemaShowRepository extends CrudRepository<CinemaShow, Long> {
}
