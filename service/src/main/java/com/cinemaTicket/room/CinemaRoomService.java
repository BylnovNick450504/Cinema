package com.cinemaTicket.room;

import com.cinemaTicket.core.ResponseStatus;
import org.springframework.http.ResponseEntity;

public interface CinemaRoomService {
    ResponseStatus initCinemaRoom(Long id, CinemaRoomInfo cinemaRoomInfo);
    ResponseEntity<?> createCinemaRoom(CinemaRoom cinemaRoomItem);
    ResponseEntity<?> detachCinemaRoom(Long id);
}
