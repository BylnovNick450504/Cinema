package com.cinemaTicket.cinema;

import org.springframework.http.ResponseEntity;

public interface CinemaCommentService {
    ResponseEntity<?> getCinemaComments();
    ResponseEntity<?> deleteCinemaComment(Long cinemaCommentId);
}
