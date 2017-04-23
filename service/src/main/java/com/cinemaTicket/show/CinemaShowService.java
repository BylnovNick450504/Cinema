package com.cinemaTicket.show;


import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.film.Film;
import com.cinemaTicket.room.CinemaRoom;

public interface CinemaShowService {
    ResponseStatus addFilm(Long id, CustomSoloRequest filmItem);
    ResponseStatus addCinemaRoom(Long id, CustomSoloRequest cinemaRoomItem);
}
