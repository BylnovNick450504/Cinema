package com.cinemaTicket.room;

import com.cinemaTicket.room.roomStatus.RoomStatus;
import com.cinemaTicket.seat.Seat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cinema_room")
public class CinemaRoom {
    private String name;

    @OneToOne
    @JoinColumn(name = "room_status_id")
    private RoomStatus RoomStatus;

    @OneToMany(mappedBy = "cinemaRoom", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    public CinemaRoom() {
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
        return RoomStatus;
    }

    public void setRoomStatus(RoomStatus RoomStatus) {
        this.RoomStatus = RoomStatus;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
