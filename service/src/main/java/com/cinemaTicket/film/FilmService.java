package com.cinemaTicket.film;

import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.film.dtoFilm.FilmDTO;
import org.springframework.http.ResponseEntity;

public interface FilmService {
    ResponseEntity<?> createFilm(Film film);
    ResponseEntity<?> updateFilm(Long id, Film film);
    ResponseEntity<?> deleteFilm(Long id);
    ResponseEntity<?> getByName(String name);
    ResponseEntity<?> getAllFilms();
    ResponseEntity<?> getByAgePlus(int age);
    ResponseEntity<?> deleteSafeFilm(Long id);
    ResponseEntity<?> updateFilm(FilmDTO filmDTO);
    ResponseEntity<?> isUsed(CustomSoloRequest filmId);
    ResponseEntity<?> getFilmAndSoldTicketStatistic();
}
