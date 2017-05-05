package com.cinemaTicket.show;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.film.Film;
import com.cinemaTicket.room.CinemaRoom;
import com.cinemaTicket.ticket.Ticket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cinema_show")
public class CinemaShow extends BaseEntity {
    private Date showDate;

    @OneToOne
    @JoinColumn(name = "cinema_room_id")
    private CinemaRoom cinemaRoom;

    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;

    private Integer status;

    @OneToMany(mappedBy = "cinemaShow", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    public CinemaShow() {
    }

    public CinemaShow(Date showDate, int status) {
        this.showDate = showDate;
        this.status = status;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void update(CinemaShow cinemaShow) {
        setShowDate(cinemaShow.getShowDate());
        setStatus(cinemaShow.getStatus());
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticketItem) {
        ticketItem.setCinemaShow(this);
        tickets.add(ticketItem);
    }
}
