package com.cinemaTicket.cinema;

import org.springframework.http.ResponseEntity;

public interface CinemaCommentService {
    ResponseEntity<?> getCinemaComments();
}
