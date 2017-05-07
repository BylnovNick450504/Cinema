package com.cinemaTicket.user;

import com.cinemaTicket.ticket.TicketInfo;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> orderTicket(String user, TicketInfo ticketInfo);
}
