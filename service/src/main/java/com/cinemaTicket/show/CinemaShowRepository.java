package com.cinemaTicket.show;

import com.cinemaTicket.film.Film;
import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.ticket.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CinemaShowRepository extends CrudRepository<CinemaShow, Long> {
    List<CinemaShow> findByFilm(Film film);
}
