package com.cinemaTicket.ticket;

import com.cinemaTicket.show.CinemaShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(value = "/ticket/getByShow", method = RequestMethod.GET)
    public ResponseEntity<?> getTicketByCinemaShow(@RequestParam(name = "showId") Long showId) {
        return ticketService.getTicketsByCinemaShow(showId);
    }
}
