package com.cinemaTicket.ticket;


public class TicketInfo {
    private Long showId;
    private int row;
    private int number;

    public TicketInfo() {
    }

    public TicketInfo(Long showId, int row, int number) {
        this.showId = showId;
        this.row = row;
        this.number = number;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
