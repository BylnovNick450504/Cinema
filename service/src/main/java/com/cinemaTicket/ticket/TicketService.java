package com.cinemaTicket.ticket;

import org.springframework.http.ResponseEntity;

public interface TicketService {
    ResponseEntity<?> getTicketsByCinemaShow(Long showId);
}
