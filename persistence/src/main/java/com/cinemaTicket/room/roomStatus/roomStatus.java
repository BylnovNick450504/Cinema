package com.cinemaTicket.room.roomStatus;

import com.cinemaTicket.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "room_status")
public class roomStatus extends BaseEntity {
    private String roomStatus;

    public roomStatus() {
    }

    public roomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
}
