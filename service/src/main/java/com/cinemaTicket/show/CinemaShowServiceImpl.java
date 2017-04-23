package com.cinemaTicket.show;

import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.film.Film;
import com.cinemaTicket.film.FilmRepository;
import com.cinemaTicket.room.CinemaRoom;
import com.cinemaTicket.room.CinemaRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaShowServiceImpl implements CinemaShowService {

    private final FilmRepository filmRepository;
    private final CinemaRoomRepository cinemaRoomRepository;
    private final CinemaShowRepository cinemaShowRepository;

    @Autowired
    public CinemaShowServiceImpl(FilmRepository filmRepository, CinemaRoomRepository cinemaRoomRepository, CinemaShowRepository cinemaShowRepository) {
        this.filmRepository = filmRepository;
        this.cinemaRoomRepository = cinemaRoomRepository;
        this.cinemaShowRepository = cinemaShowRepository;
    }

    @Override
    public ResponseStatus addFilm(Long id, CustomSoloRequest filmItem) {
        CinemaShow cinemaShow = cinemaShowRepository.findOne(id);
        Film film = filmRepository.findOne(filmItem.getId());
        if (cinemaShow == null || film == null) {
            return new ResponseStatus();
        }
        cinemaShow.setFilm(film);
        cinemaShowRepository.save(cinemaShow);
        return new ResponseStatus(true);
    }

    @Override
    public ResponseStatus addCinemaRoom(Long id, CustomSoloRequest cinemaRoomItem) {
        CinemaShow cinemaShow = cinemaShowRepository.findOne(id);
        CinemaRoom cinemaRoom = cinemaRoomRepository.findOne(cinemaRoomItem.getId());
        if (cinemaShow == null || cinemaRoom == null) {
            return new ResponseStatus();
        }
        cinemaShow.setCinemaRoom(cinemaRoom);
        cinemaShowRepository.save(cinemaShow);
        return new ResponseStatus(true);
    }
}
