package com.cinemaTicket.room.dtoCinemaRoom;

import com.cinemaTicket.room.CinemaRoom;

public class CinemaRoomDTO {
    private Long id;
    private String name;
    private Integer row;
    private Integer number;
    private Integer status;

    public CinemaRoomDTO() {
    }

    public CinemaRoomDTO(Long id, String name, Integer row, Integer number, Integer status) {
        this.id = id;
        this.name = name;
        this.row = row;
        this.number = number;
        this.status = status;
    }

    public CinemaRoomDTO(CinemaRoom cinemaRoom) {
        this.id = cinemaRoom.getId();
        this.name = cinemaRoom.getName();
        this.row = cinemaRoom.getRow();
        this.number = cinemaRoom.getCol();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getStatus() {
        return status;
    }

    public CinemaRoom getCinemaRoom() {
        return new CinemaRoom(
                getName(),
                getRow(),
                getNumber(),
                getStatus()
        );
    }
}
