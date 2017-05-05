package com.cinemaTicket.show;

import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.film.Film;
import com.cinemaTicket.film.FilmRepository;
import com.cinemaTicket.room.CinemaRoom;
import com.cinemaTicket.room.CinemaRoomRepository;
import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.ticket.Ticket;
import com.cinemaTicket.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CinemaShowServiceImpl implements CinemaShowService {

    private final FilmRepository filmRepository;
    private final CinemaRoomRepository cinemaRoomRepository;
    private final CinemaShowRepository cinemaShowRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public CinemaShowServiceImpl(FilmRepository filmRepository,
                                 CinemaRoomRepository cinemaRoomRepository,
                                 CinemaShowRepository cinemaShowRepository,
                                 TicketRepository ticketRepository
    ) {
        this.filmRepository = filmRepository;
        this.cinemaRoomRepository = cinemaRoomRepository;
        this.cinemaShowRepository = cinemaShowRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public ResponseEntity<?> addFilm(Long id, CustomSoloRequest filmItem) {
        CinemaShow cinemaShow = cinemaShowRepository.findOne(id);
        Film film = filmRepository.findOne(filmItem.getId());
        if (cinemaShow == null || film == null) {
            return new ResponseEntity<>(new ResponseStatus(), HttpStatus.NOT_FOUND);
        }
        cinemaShow.setFilm(film);
        cinemaShowRepository.save(cinemaShow);
        return new ResponseEntity<>(new ResponseStatus(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addCinemaRoom(Long id, CustomSoloRequest cinemaRoomItem) {
        CinemaShow cinemaShow = cinemaShowRepository.findOne(id);
        CinemaRoom cinemaRoom = cinemaRoomRepository.findOne(cinemaRoomItem.getId());
        if (cinemaShow == null || cinemaRoom == null) {
            return new ResponseEntity<>(new ResponseStatus(), HttpStatus.NOT_FOUND);
        }
        cinemaShow.setCinemaRoom(cinemaRoom);
        cinemaShowRepository.save(cinemaShow);
        return new ResponseEntity<>(new ResponseStatus(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createCinemaShow(CinemaShow cinemaShow) {
        cinemaShow = cinemaShowRepository.save(cinemaShow);
        return new ResponseEntity<>(cinemaShow, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateCinemaShow(Long id, CinemaShow cinemaShowNew) {
        CinemaShow cinemaShowOld = cinemaShowRepository.findOne(id);
        if (cinemaShowOld == null) {
            return new ResponseEntity<>(new ResponseStatus(), HttpStatus.NOT_FOUND);
        }
        cinemaShowOld.update(cinemaShowNew);
        //cinemaShowRepository.save(cinemaShowOld);
        return new ResponseEntity<>(cinemaShowOld, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<?> deleteCinemaShow(Long id) {
        CinemaShow cinemaShow = cinemaShowRepository.findOne(id);
        if (cinemaShow == null) {
            return new ResponseEntity<>(new ResponseStatus(), HttpStatus.NOT_FOUND);
        }
        cinemaShowRepository.delete(id);
        return new ResponseEntity<>(new ResponseStatus(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createAndInitCinemaShow(CinemaShowInfo cinemaShowInfo) {

        Film filmItem = filmRepository.findOne(cinemaShowInfo.getFilmId());
        CinemaRoom cinemaRoomItem = cinemaRoomRepository.findOne(cinemaShowInfo.getCinemaRoomId());
        if (filmItem == null || cinemaRoomItem == null) {
            return new ResponseEntity<>(new ResponseStatus(), HttpStatus.NOT_FOUND);
        }
        CinemaShow cinemaShow = new CinemaShow(cinemaShowInfo.getShowDate(),
                                               cinemaShowInfo.getStatus());
        for (Seat seat : cinemaRoomItem.getSeats()) {
            Ticket ticket = new Ticket();
            ticket.setSeat(seat);
            cinemaShow.addTicket(ticket);
        }

        cinemaShow.setFilm(filmItem);
        cinemaShow.setCinemaRoom(cinemaRoomItem);
        cinemaShow.setStatus(cinemaShowInfo.getStatus());
        cinemaShowRepository.save(cinemaShow);

        return new ResponseEntity<>(new ResponseStatus(true), HttpStatus.CREATED);
    }
}
