package com.cinemaTicket.film;

import com.cinemaTicket.film.mock.MockFilm;
import com.cinemaTicket.film.mock.MockFilmList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping(value = "/films/create", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createFilm(@RequestBody Film film) {
        return filmService.createFilm(film);
    }

    @RequestMapping(value = "/films/update/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateFilm(@PathVariable Long id, @RequestBody Film film) {
        return filmService.updateFilm(id, film);
    }

    @RequestMapping(value = "/films/delete/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteFilm(@PathVariable Long id) {
        return filmService.deleteFilm(id);
    }

    @RequestMapping(value = "/films/find", method = RequestMethod.GET)
    public MockFilmList getByName(@RequestParam("Name") String name) {
        return filmService.getByName(name);
    }

    @RequestMapping(value = "/films/findAll", method = RequestMethod.GET)
    public MockFilmList getAllFilms() {
        return filmService.getAllFilms();
    }

}
