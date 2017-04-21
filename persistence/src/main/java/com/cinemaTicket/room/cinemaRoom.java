package com.cinemaTicket.room;

import com.cinemaTicket.room.roomStatus.roomStatus;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cinema_room")
public class cinemaRoom {
    private String name;

    @OneToOne
    @JoinColumn(name = "room_status_id")
    private roomStatus roomStatus;

    public cinemaRoom() {
    }

    public cinemaRoom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.cinemaTicket.room.roomStatus.roomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(com.cinemaTicket.room.roomStatus.roomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }
}
