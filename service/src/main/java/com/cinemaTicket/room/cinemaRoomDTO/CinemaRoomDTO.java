package com.cinemaTicket.room.cinemaRoomDTO;


import com.cinemaTicket.room.CinemaRoom;

public class CinemaRoomDTO {
    private Long id;
    private String name;
    private Integer row;
    private Integer number;

    public CinemaRoomDTO() {
    }

    public CinemaRoomDTO(Long id, String name, Integer row, Integer number) {
        this.id = id;
        this.name = name;
        this.row = row;
        this.number = number;
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
}
