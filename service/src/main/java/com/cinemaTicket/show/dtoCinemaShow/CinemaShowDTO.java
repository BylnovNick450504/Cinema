package com.cinemaTicket.show.dtoCinemaShow;

import com.cinemaTicket.core.DatePrinter;
import com.cinemaTicket.show.CinemaShow;

public class CinemaShowDTO {
    private Long id;
    private String showDayMonthYear;
    private String showHourMin;
    private String filmName;
    private String roomName;

    public CinemaShowDTO() {
    }

    public CinemaShowDTO(String showDayMonthYear, String showHourMin, String filmName, Long id) {
        this.showDayMonthYear = showDayMonthYear;
        this.showHourMin = showHourMin;
        this.filmName = filmName;
        this.id = id;
    }

    public CinemaShowDTO(Long id, String showDayMonthYear, String showHourMin, String filmName, String roomName) {
        this.id = id;
        this.showDayMonthYear = showDayMonthYear;
        this.showHourMin = showHourMin;
        this.filmName = filmName;
        this.roomName = roomName;
    }

    public CinemaShowDTO(CinemaShow cinemaShow) {
        this.id = cinemaShow.getId();
        this.filmName = cinemaShow.getFilm().getName();
        this.showDayMonthYear = DatePrinter.printDayMonthYear(cinemaShow.getShowDate());
        this.showHourMin = DatePrinter.printHourMin(cinemaShow.getShowDate());
        this.roomName = cinemaShow.getCinemaRoom().getName();
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

    public String getRoomName() {
        return roomName;
    }
}
