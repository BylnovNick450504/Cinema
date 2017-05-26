package com.cinemaTicket.film;


import com.cinemaTicket.core.CustomMonoRequest;
import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.film.filmDTO.FilmDTO;
import com.cinemaTicket.film.filmDTO.FilmDTOList;
import org.springframework.http.ResponseEntity;

public interface FilmService {
    ResponseEntity<?> createFilm(Film film);
    ResponseEntity<?> updateFilm(Long id, Film film);
    ResponseEntity<?> deleteFilm(Long id);
    FilmDTOList getByName(String name);
    FilmDTOList getAllFilms();
    ResponseEntity<?> getByAgePlus(int age);
    ResponseEntity<?> deleteSafeFilm(Long id);
    ResponseEntity<?> updateFilm(FilmDTO filmDTO);
}
