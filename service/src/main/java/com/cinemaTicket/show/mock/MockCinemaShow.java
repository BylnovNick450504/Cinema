package com.cinemaTicket.show.mock;

import com.cinemaTicket.core.DatePrinter;
import com.cinemaTicket.show.CinemaShow;

public class MockCinemaShow {
    private Long id;
    private String showDayMonthYear;
    private String showHourMin;
    private String filmName;

    public MockCinemaShow() {
    }

    public MockCinemaShow(String showDayMonthYear, String showHourMin, String filmName, Long id) {
        this.showDayMonthYear = showDayMonthYear;
        this.showHourMin = showHourMin;
        this.filmName = filmName;
        this.id = id;
    }

    public MockCinemaShow(CinemaShow cinemaShow) {
        this.id = cinemaShow.getId();
        this.filmName = cinemaShow.getFilm().getName();
        this.showDayMonthYear = DatePrinter.printDayMonthYear(cinemaShow.getShowDate());
        this.showHourMin = DatePrinter.printHourMin(cinemaShow.getShowDate());
    }

    public String getShowDayMonthYear() {
        return showDayMonthYear;
    }

    public String getShowHourMin() {
        return showHourMin;
    }

    public String getFilmName() {
        return filmName;
    }

    public Long getId() {
        return id;
    }
}
