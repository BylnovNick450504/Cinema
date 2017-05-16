package com.cinemaTicket.ticket.mockTicket;

import com.cinemaTicket.core.DatePrinter;
import com.cinemaTicket.ticket.Ticket;

public class MockTicket {
    private Long id;
    private String filmName;
    private String showDayMonthYear;
    private String showHourMin;
    private String roomName;
    private int row;
    private int number;
    private String status;
    private double price;

    public MockTicket() {
    }

    public MockTicket(Long id,
                      String filmName,
                      String showDayMonthYear,
                      String showHourMin,
                      String roomName,
                      int row,
                      int number,
                      String status,
                      double price
    ) {
        this.id = id;
        this.filmName = filmName;
        this.showDayMonthYear = showDayMonthYear;
        this.showHourMin = showHourMin;
        this.roomName = roomName;
        this.row = row;
        this.number = number;
        this.status = status;
        this.price = price;
    }

    public MockTicket(Ticket ticket) {
        this.id = ticket.getId();
        this.filmName = ticket.getCinemaShow().getFilm().getName();
        this.showDayMonthYear = DatePrinter.printDayMonthYear(ticket.getCinemaShow().getShowDate());
        this.showHourMin = DatePrinter.printHourMin(ticket.getCinemaShow().getShowDate());
        this.roomName = ticket.getSeat().getCinemaRoom().getName();
        this.row = ticket.getSeat().getRow();
        this.number = ticket.getSeat().getNumber();
        this.status = ticket.getStatus().toString();
        this.price = ticket.getCinemaShow().getPriceCoefficient() * ticket.getCinemaShow().getFilm().getRecommendTicketCost();
    }

    public Long getId() {
        return id;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getShowDayMonthYear() {
        return showDayMonthYear;
    }

    public String getShowHourMin() {
        return showHourMin;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }
}
