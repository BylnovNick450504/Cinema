package com.cinemaTicket.room.roomStatus;

import com.cinemaTicket.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "room_status")
public class RoomStatus extends BaseEntity {
    private String roomStatus;

    public RoomStatus() {
    }

    public RoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
}
