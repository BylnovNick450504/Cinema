package com.cinemaTicket.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/films/evgen", method = RequestMethod.GET)
    public String fun1() {
        return "hello evgen";
    }

}
