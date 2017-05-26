package com.cinemaTicket.seat;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.room.CinemaRoom;
import com.cinemaTicket.ticket.Ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seat")
public class Seat extends BaseEntity {

    @NotNull
    private int number;

    @NotNull
    private int row;

    @NotNull
    @OneToOne
    @JoinColumn(name = "cinema_room_id")
    private CinemaRoom cinemaRoom;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    public Seat() {
    }

    public Seat(int row, int number) {
        this.row = row;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticketItem) {
        ticketItem.setSeat(this);
        tickets.add(ticketItem);
    }
}
