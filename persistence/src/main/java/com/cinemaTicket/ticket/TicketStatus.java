package com.cinemaTicket.ticket;


public enum TicketStatus {
    ACTIVE(1), OVERDUE(2);

    private int status;

    TicketStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
