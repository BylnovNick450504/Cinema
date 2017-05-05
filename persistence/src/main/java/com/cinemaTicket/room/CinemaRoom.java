package com.cinemaTicket.room;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.room.roomStatus.RoomStatus;
import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.show.CinemaShow;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cinema_room")
public class CinemaRoom extends BaseEntity {
    private String name;
    private Integer row;
    private Integer col;

    @OneToOne
    @JoinColumn(name = "room_status_id")
    private RoomStatus roomStatus;

    @OneToMany(mappedBy = "cinemaRoom", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "cinemaRoom", cascade = CascadeType.ALL)
    private List<CinemaShow> cinemaShows = new ArrayList<>();

    public CinemaRoom() {
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

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void addSeat(Seat seatItem) {
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

}
