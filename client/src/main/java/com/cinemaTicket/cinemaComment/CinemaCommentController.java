package com.cinemaTicket.cinemaComment;

import com.cinemaTicket.cinema.CinemaCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaCommentController {

    private final CinemaCommentService cinemaCommentService;

    @Autowired
    public CinemaCommentController(CinemaCommentService cinemaCommentService) {
        this.cinemaCommentService = cinemaCommentService;
    }

    @RequestMapping(value = "/cinemaComments/getAll", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCinemaComments() {
        return cinemaCommentService.getCinemaComments();
    }

    @RequestMapping(value = "/cinemaComments/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCinemaComment(@PathVariable Long id) {
        return cinemaCommentService.deleteCinemaComment(id);
    }
}
