package com.cinemaTicket.ticket;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.show.CinemaShow;
import com.cinemaTicket.user.User;

import javax.persistence.*;


@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "cinema_show_id")
    private CinemaShow cinemaShow;

    @OneToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @OneToOne
    @JoinColumn(name = "person_id")
    private User user;

    private TicketStatus status;

    public Ticket() {
    }

    public Ticket(CinemaShow cinemaShow) {
        this.cinemaShow = cinemaShow;
    }

    public CinemaShow getCinemaShow() {
        return cinemaShow;
    }

    public void setCinemaShow(CinemaShow cinemaShow) {
        this.cinemaShow = cinemaShow;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
