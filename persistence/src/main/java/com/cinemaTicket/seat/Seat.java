package com.cinemaTicket.seat;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.room.CinemaRoom;
import com.cinemaTicket.seat.seatStatus.SeatStatus;
import com.cinemaTicket.ticket.Ticket;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seat")
public class Seat extends BaseEntity {

    private int number;
    private int row;

    @OneToOne
    @JoinColumn(name = "seat_status_id")
    private SeatStatus seatStatus;

    @OneToOne
    @JoinColumn(name = "cinema_room_id")
    private CinemaRoom cinemaRoom;

    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public Seat() {
    }

    public Seat(int number, int row) {
        this.number = number;
        this.row = row;
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
}
