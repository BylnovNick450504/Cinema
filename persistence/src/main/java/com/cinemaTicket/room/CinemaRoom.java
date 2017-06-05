package com.cinemaTicket.room;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.show.CinemaShow;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cinema_room")
public class CinemaRoom extends BaseEntity {
    @NotNull
    private String name;

    @NotNull
    private Integer row;

    @NotNull
    private Integer col;

    @NotNull
    private Integer roomStatus;

    @OneToMany(mappedBy = "cinemaRoom", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "cinemaRoom", cascade = CascadeType.ALL)
    private List<CinemaShow> cinemaShows = new ArrayList<>();

    public CinemaRoom() {
    }

    public CinemaRoom(String name, Integer row, Integer col, Integer roomStatus) {
        this.name = name;
        this.row = row;
        this.col = col;
        this.roomStatus = roomStatus;
    }

    public CinemaRoom(String name, Integer row, Integer col) {
        this.name = name;
        this.row = row;
        this.col = col;
    }

    public CinemaRoom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    void addSeat(Seat seatItem) {
        seatItem.setCinemaRoom(this);
        seats.add(seatItem);
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void set(Integer col) {
        this.col = col;
    }

    public List<CinemaShow> getCinemaShows() {
        return cinemaShows;
    }

    public void setCinemaShows(List<CinemaShow> cinemaShows) {
        this.cinemaShows = cinemaShows;
    }

    public void update(CinemaRoom cinemaRoom) {
        this.name = cinemaRoom.getName();
        this.row = cinemaRoom.getRow();
        this.col = cinemaRoom.getCol();
    }

    public void deleteSeatList() {
        seats.clear();
    }
}
