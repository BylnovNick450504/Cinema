package com.cinemaTicket.room;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CinemaRoomRepository extends CrudRepository<CinemaRoom, Long> {
    List<CinemaRoom> findByRoomStatusEquals(Integer status);
}
