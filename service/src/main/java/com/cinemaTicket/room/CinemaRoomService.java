package com.cinemaTicket.room;

import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.room.roomStatus.RoomStatus;

public interface CinemaRoomService {
    ResponseStatus initCinemaRoom(Long id, CinemaRoomInfo cinemaRoomInfo);
    ResponseStatus addRoomStatus(Long id, CustomSoloRequest roomStatusId);
}
