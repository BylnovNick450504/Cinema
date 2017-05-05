package com.cinemaTicket.seat;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.room.CinemaRoom;
import com.cinemaTicket.seat.seatStatus.SeatStatus;
import com.cinemaTicket.ticket.Ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "seat")
public class Seat extends BaseEntity {

    private int number;
    private int row;

    @OneToOne
    @JoinColumn(name = "seat_status_id")
    private SeatStatus seatStatus;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "cinema_room_id")
    private CinemaRoom cinemaRoom;

    @OneToOne(mappedBy = "seat")
    private Ticket ticket;

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

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void addTicket(Ticket ticketItem) {
        ticketItem.setSeat(this);
        this.ticket = ticketItem;
    }
}
