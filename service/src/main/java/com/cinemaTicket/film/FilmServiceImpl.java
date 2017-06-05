package com.cinemaTicket.film;

import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.film.dtoFilm.FilmDTO;
import com.cinemaTicket.film.dtoFilm.FilmStatisticDTO;
import com.cinemaTicket.show.CinemaShow;
import com.cinemaTicket.ticket.Ticket;
import com.cinemaTicket.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository, TicketRepository ticketRepository) {
        this.filmRepository = filmRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public ResponseEntity<?> createFilm(Film film) {
        film = filmRepository.save(film);
        return new ResponseEntity<>(film, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateFilm(Long id, Film newFilm) {
        Film oldFilm = filmRepository.findOne(id);
        if (oldFilm == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        oldFilm.updateFilm(newFilm);
        filmRepository.save(oldFilm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deleteFilm(Long id) {
        filmRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getByName(String name) {
        List<Film> filmList = filmRepository.findByName(name);
        List<FilmDTO> filmDTOS = new ArrayList<>();
        for (Film film : filmList) {
            FilmDTO filmDTO = new FilmDTO(film);
            filmDTOS.add(filmDTO);
        }
        return new ResponseEntity<>(filmDTOS, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getAllFilms() {
        Iterable<Film> filmList = filmRepository.findAll();
        List<FilmDTO> filmDTOS = new ArrayList<>();
        for (Film film : filmList) {
            FilmDTO filmDTO = new FilmDTO(film);
            filmDTOS.add(filmDTO);
        }
        return new ResponseEntity<>(filmDTOS, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getByAgePlus(int age) {
        List<Film> filmList = filmRepository.findByAgeLessThanEqual(age);
        List<FilmDTO> filmDTOS = new ArrayList<>();
        for (Film film : filmList) {
            FilmDTO filmDTO = new FilmDTO(film);
            filmDTOS.add(filmDTO);
        }
        return new ResponseEntity<>(filmDTOS, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deleteSafeFilm(Long id) {
        Film film = filmRepository.findOne(id);
        if (film == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no film"),
                    HttpStatus.NOT_FOUND);
        }
        if(!film.getCinemaShows().isEmpty()) {
            return new ResponseEntity<>(new ResponseStatus(false, "film in use"),
                    HttpStatus.OK);
        }
        filmRepository.delete(film);
        return new ResponseEntity<>(new ResponseStatus(true, "film deleted"),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateFilm(FilmDTO filmDTO) {
        Film film = filmRepository.findOne(filmDTO.getId());
        if (film == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no film"),
                    HttpStatus.OK);
        }
        film.update(filmDTO.getFilm());
        film = filmRepository.save(film);
        FilmDTO refreshedFilmDTO = new FilmDTO(film);
        return new ResponseEntity<>(refreshedFilmDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> isUsed(CustomSoloRequest filmId) {
        Film film = filmRepository.findOne(filmId.getId());
        if (film == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no film"),
                    HttpStatus.OK);
        }
        if(!film.getCinemaShows().isEmpty()) {
            return new ResponseEntity<>(new ResponseStatus(false, "is used"),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseStatus(true, "is not used"),
                HttpStatus.OK);
    }

    private Long getAmountOfSoldTickets(Film film) {
        Long amount = 0L;
        for (CinemaShow cinemaShow : film.getCinemaShows()) {
            List<Ticket> ticketList = ticketRepository.findByUserIsNotNullAndCinemaShow(cinemaShow);
            amount += ticketList.size();
        }
        return amount;
    }

    @Override
    public ResponseEntity<?> getFilmAndSoldTicketStatistic() {
        Iterable<Film> filmList = filmRepository.findAll();
        List<FilmStatisticDTO> filmStatisticDTOList = new ArrayList<>();
        for (Film film : filmList) {
            filmStatisticDTOList.add(new FilmStatisticDTO(film.getName(), getAmountOfSoldTickets(film)));
        }
        return new ResponseEntity<>(filmStatisticDTOList, HttpStatus.CREATED);
    }
}
