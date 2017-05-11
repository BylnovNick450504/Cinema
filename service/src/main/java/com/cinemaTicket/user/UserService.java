package com.cinemaTicket.user;

import com.cinemaTicket.cinema.CinemaComment;
import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.ticket.TicketInfo;
import org.springframework.http.ResponseEntity;

import javax.xml.stream.events.Comment;

public interface UserService {
    ResponseEntity<?> orderTicket(String user, TicketInfo ticketInfo);
    ResponseEntity<?> orderTicket(String user, CustomSoloRequest ticketId);
    ResponseEntity<?> createUser(User user);
    ResponseEntity<?> editUser(String username, UserInfo user);
    ResponseEntity<?> createCinemaComment(String username, CinemaComment cinemaComment);

}
