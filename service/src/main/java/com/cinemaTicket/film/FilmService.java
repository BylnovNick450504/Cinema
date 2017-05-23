package com.cinemaTicket.film;


import com.cinemaTicket.core.CustomMonoRequest;
import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.film.genre.Genre;
import com.cinemaTicket.film.mock.MockFilm;
import com.cinemaTicket.film.mock.MockFilmList;
import org.springframework.http.ResponseEntity;

public interface FilmService {
    ResponseStatus addGenres(Long id, CustomMonoRequest genres);
    ResponseStatus addComment(Long id, CustomSoloRequest comment);
    ResponseEntity<?> createFilm(Film film);
    ResponseEntity<?> updateFilm(Long id, Film film);
    ResponseEntity<?> deleteFilm(Long id);
    MockFilmList getByName(String name);
    MockFilmList getAllFilms();
    ResponseEntity<?> getByGenre(String genre);
    ResponseEntity<?> getByAgePlus(int age);
    ResponseEntity<?> deleteSafeFilm(Long id);


}
