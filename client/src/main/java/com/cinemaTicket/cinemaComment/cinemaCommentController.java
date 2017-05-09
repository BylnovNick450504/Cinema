package com.cinemaTicket.cinemaComment;

import com.cinemaTicket.cinema.CinemaCommentService;
import com.cinemaTicket.cinema.mock.CinemaCommentMock;
import com.cinemaTicket.cinema.mock.CinemaCommentsMockList;
import com.cinemaTicket.film.mock.MockFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class cinemaCommentController {

    private final CinemaCommentService cinemaCommentService;

    @Autowired
    public cinemaCommentController(CinemaCommentService cinemaCommentService) {
        this.cinemaCommentService = cinemaCommentService;
    }

    @RequestMapping(value = "/cinemaComments/getAll", method = RequestMethod.GET)
    public CinemaCommentsMockList getAllCinemaComments() {
        return cinemaCommentService.getCinemaComments();
    }
}
