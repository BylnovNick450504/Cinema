package com.cinemaTicket.seat;

import com.cinemaTicket.room.CinemaRoom;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface SeatRepository extends PagingAndSortingRepository<Seat, Long> {
    Seat findByCinemaRoomAndRowAndNumber(CinemaRoom cinemaRoom, int row, int number);
}
