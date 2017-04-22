package com.cinemaTicket.seat;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface SeatRepository extends PagingAndSortingRepository<Seat, Long> {
}
