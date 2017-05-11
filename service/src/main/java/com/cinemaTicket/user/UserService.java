package com.cinemaTicket.user;

import com.cinemaTicket.cinema.CinemaComment;
import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.ticket.TicketInfo;
import org.springframework.http.ResponseEntity;

import javax.xml.stream.events.Comment;

public interface UserService {
    ResponseEntity<?> orderTicket(String userName, TicketInfo ticketInfo);
    ResponseEntity<?> orderTicket(String userName, CustomSoloRequest ticketId);
    ResponseEntity<?> createUser(User user);
    ResponseEntity<?> editUser(String userName, UserInfo user);
    ResponseEntity<?> createCinemaComment(String userName, CinemaComment cinemaComment);
    ResponseEntity<?> getUserTickets(String userName);

}
