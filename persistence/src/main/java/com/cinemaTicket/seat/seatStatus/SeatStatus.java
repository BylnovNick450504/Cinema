package com.cinemaTicket.seat.seatStatus;


import com.cinemaTicket.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "seat_status")
public class SeatStatus extends BaseEntity {
    private String seatStatus;

    public SeatStatus() {
    }

    public SeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }
}
