package com.cinemaTicket.film.mock;

import com.cinemaTicket.film.Film;

public final class FilmFactory {

    private FilmFactory() {};

    public static Film create(MockFilm mockFilm) {
        return new Film(
                mockFilm.getName(),
                mockFilm.getProducer(),
                mockFilm.getBudget(),
                mockFilm.getPremiereDate(),
                mockFilm.getAge(),
                mockFilm.getDescription(),
                mockFilm.getRating(),
                mockFilm.getRecommendTicketCost(),
                mockFilm.getPicturePath()
        );
    }
}
