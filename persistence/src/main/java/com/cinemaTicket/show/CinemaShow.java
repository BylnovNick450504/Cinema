package com.cinemaTicket.show;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.room.CinemaRoom;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cinema_show")
public class CinemaShow extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "cinema_room_id")
    private CinemaRoom cinemaRoom;


}
