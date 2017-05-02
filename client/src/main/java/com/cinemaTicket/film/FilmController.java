package com.cinemaTicket.film;

import com.cinemaTicket.film.mock.MockFilm;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/films/hello", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String fun() {
        return "hello admin";
    }

    @RequestMapping(value = "/films/create", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createFilm(@RequestBody MockFilm mockFilm) {
        return filmService.createFilm(mockFilm);
    }

    @RequestMapping(value = "/films/update/{id}", method = RequestMethod.PUT)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateFilm(@PathVariable Long id, @RequestBody MockFilm mockFilm) {
        return filmService.updateFilm(id, mockFilm);
    }

    @RequestMapping(value = "/films/delete/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteFilm(@PathVariable Long id) {
        return filmService.deleteFilm(id);
    }
}
