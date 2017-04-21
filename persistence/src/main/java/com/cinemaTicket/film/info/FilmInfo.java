package com.cinemaTicket.film.info;

import com.cinemaTicket.film.Film;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "film_info")
public class FilmInfo {
    private String info;

    public FilmInfo() {
    }

    public FilmInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
