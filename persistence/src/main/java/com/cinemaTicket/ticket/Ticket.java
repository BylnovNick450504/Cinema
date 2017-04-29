package com.cinemaTicket.ticket;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.show.CinemaShow;
import com.cinemaTicket.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity {

    @OneToOne
    private CinemaShow cinemaShow;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    private Seat seat;

    @OneToOne
    @JoinColumn(name = "person_id")
    private User user;

    private Date showDate;

    public Ticket() {
    }

    public Ticket(Date showDate) {
        this.showDate = showDate;
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

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }


}
