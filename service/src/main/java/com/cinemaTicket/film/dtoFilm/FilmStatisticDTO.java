package com.cinemaTicket.film.dtoFilm;

public class FilmStatisticDTO {
    private String Film;
    private Long soldTickets;

    public FilmStatisticDTO() {
    }

    public FilmStatisticDTO(String film, Long soldTickets) {
        Film = film;
        this.soldTickets = soldTickets;
    }

    public String getFilm() {
        return Film;
    }

    public void setFilm(String film) {
        Film = film;
    }

    public Long getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(Long soldTickets) {
        this.soldTickets = soldTickets;
    }
}
