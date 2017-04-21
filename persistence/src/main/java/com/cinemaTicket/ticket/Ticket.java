package com.cinemaTicket.ticket;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.room.CinemaRoom;
import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.user.Person;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity {

    @OneToOne
    private CinemaRoom cinemaRoom;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    private Seat seat;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Ticket() {
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
