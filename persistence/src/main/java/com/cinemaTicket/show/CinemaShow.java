package com.cinemaTicket.show;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.film.Film;
import com.cinemaTicket.room.CinemaRoom;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

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
        showDate = cinemaShow.getShowDate();
        status = cinemaShow.getStatus();
    }
}
