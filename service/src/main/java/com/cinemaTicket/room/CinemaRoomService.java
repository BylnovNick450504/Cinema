package com.cinemaTicket.room;

import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.room.dtoCinemaRoom.CinemaRoomInfo;
import com.cinemaTicket.room.dtoCinemaRoom.CinemaRoomDTO;
import org.springframework.http.ResponseEntity;

public interface CinemaRoomService {
    ResponseStatus initCinemaRoom(Long id, CinemaRoomInfo cinemaRoomInfo);
    ResponseEntity<?> createCinemaRoom(CinemaRoom cinemaRoomItem);
    ResponseEntity<?> detachCinemaRoom(Long id);
    ResponseEntity<?> getActiveCinemaRooms();
    ResponseEntity<?> deleteSafe(Long id);
    ResponseEntity<?> updateCinemaRoom(CinemaRoomDTO cinemaRoomDTO);
    ResponseEntity<?> isUsed(CustomSoloRequest roomId);
}
