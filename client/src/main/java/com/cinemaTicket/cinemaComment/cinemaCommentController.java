package com.cinemaTicket.cinemaComment;

import com.cinemaTicket.cinema.CinemaCommentService;
import com.cinemaTicket.cinema.mock.CinemaCommentsMockList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cinemaCommentController {

    private final CinemaCommentService cinemaCommentService;

    @Autowired
    public cinemaCommentController(CinemaCommentService cinemaCommentService) {
        this.cinemaCommentService = cinemaCommentService;
    }

    @RequestMapping(value = "/cinemaComments/getAll", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCinemaComments() {
        return cinemaCommentService.getCinemaComments();
    }
}
