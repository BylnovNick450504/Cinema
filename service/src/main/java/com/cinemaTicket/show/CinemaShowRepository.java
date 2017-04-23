package com.cinemaTicket.show;

import com.cinemaTicket.room.CinemaRoom;
import org.springframework.data.repository.CrudRepository;


public interface CinemaShowRepository extends CrudRepository<CinemaShow, Long> {
}
