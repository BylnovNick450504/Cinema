package com.cinemaTicket.ticket;

import com.cinemaTicket.show.CinemaShow;
import com.cinemaTicket.show.CinemaShowRepository;
import com.cinemaTicket.ticket.dtoTicket.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final CinemaShowRepository cinemaShowRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, CinemaShowRepository cinemaShowRepository) {
        this.ticketRepository = ticketRepository;
        this.cinemaShowRepository = cinemaShowRepository;
    }

    @Override
    public ResponseEntity<?> getTicketsByCinemaShow(Long showId) {
        CinemaShow cinemaShow = cinemaShowRepository.findOne(showId);
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        if (cinemaShow == null) {
            return new ResponseEntity<>(ticketDTOList, HttpStatus.CREATED);
        }
        List<Ticket> ticketList = ticketRepository.findByUserIsNullAndCinemaShow(cinemaShow);
        for (Ticket ticket : ticketList) {
            TicketDTO ticketDTO = new TicketDTO(ticket);
            ticketDTOList.add(ticketDTO);
        }
        return new ResponseEntity<>(ticketDTOList, HttpStatus.CREATED);
    }
}
