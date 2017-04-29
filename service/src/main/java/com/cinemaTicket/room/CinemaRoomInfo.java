package com.cinemaTicket.room;


public class CinemaRoomInfo {
    private int rows;
    private int columns;

    public CinemaRoomInfo() {
    }

    public CinemaRoomInfo(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
