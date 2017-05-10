package com.cinemaTicket.ticket.mockTicket;


public class MockTicket {
    private Long ticketId;
    private String filmName;
    private String showDayMonthYear;
    private String showHourMin;
    private String roomName;
    private int row;
    private int number;

    public MockTicket() {
    }

    public MockTicket(Long ticketId,
                      String filmName,
                      String showDayMonthYear,
                      String showHourMin,
                      String roomName,
                      int row,
                      int number
    ) {
        this.ticketId = ticketId;
        this.filmName = filmName;
        this.showDayMonthYear = showDayMonthYear;
        this.showHourMin = showHourMin;
        this.roomName = roomName;
        this.row = row;
        this.number = number;
    }

    public Long getTicketId() {
        return ticketId;
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
}
