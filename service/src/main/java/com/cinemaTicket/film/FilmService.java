package com.cinemaTicket.film;


import com.cinemaTicket.core.CustomMonoRequest;
import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.film.mock.MockFilm;
import org.springframework.http.ResponseEntity;

public interface FilmService {
    ResponseStatus addGenres(Long id, CustomMonoRequest genres);
    ResponseStatus addComment(Long id, CustomSoloRequest comment);
    ResponseEntity<?> createFilm(MockFilm mockFilm);
    ResponseEntity<?> updateFilm(Long id, MockFilm mockFilm);
    ResponseEntity<?> deleteFilm(Long id);
}
