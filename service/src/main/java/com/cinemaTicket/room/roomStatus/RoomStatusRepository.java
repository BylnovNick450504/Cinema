package com.cinemaTicket.room.roomStatus;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomStatusRepository extends CrudRepository<RoomStatus, Long> {
}
