package com.cinemaTicket.room;

import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.room.roomStatus.RoomStatus;
import com.cinemaTicket.room.roomStatus.RoomStatusRepository;
import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.seat.SeatRepository;
import com.cinemaTicket.seat.seatStatus.SeatStatus;
import com.cinemaTicket.seat.seatStatus.SeatStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CinemaRoomServiceImpl implements CinemaRoomService{

    private final CinemaRoomRepository cinemaRoomRepository;
    private final SeatRepository seatRepository;
    private final SeatStatusRepository seatStatusRepository;
    private final RoomStatusRepository roomStatusRepository;

    @Autowired
    public CinemaRoomServiceImpl(CinemaRoomRepository cinemaRoomRepository,
                                 SeatRepository seatRepository,
                                 SeatStatusRepository seatStatusRepository,
                                 RoomStatusRepository roomStatusRepository
    ) {
        this.cinemaRoomRepository = cinemaRoomRepository;
        this.seatRepository = seatRepository;
        this.seatStatusRepository = seatStatusRepository;
        this.roomStatusRepository = roomStatusRepository;
    }

    @Override
    public ResponseStatus initCinemaRoom(Long id, CinemaRoomInfo cinemaRoomInfo) {
        CinemaRoom cinemaRoom;
        int column = 1;
        int row = 1;
        final long SEAT_STATUS_ID = 1;
        final String SEAT_STATUS = "FREE";
        List<Seat> seats = new ArrayList<>();
        //find cinemaRoom in db
        cinemaRoom = cinemaRoomRepository.findOne(id);
        if (cinemaRoom == null) {
            return new ResponseStatus();
        }
        //find seatStatus "FREE" in db
        SeatStatus seatStatus = seatStatusRepository.findOne(SEAT_STATUS_ID);
        if(seatStatus == null || !seatStatus.getSeatStatus().equals(SEAT_STATUS)) {
            return new ResponseStatus();
        }
        //generate seat for current cinemaRoom and save them in db
        for(int i = 0; i < cinemaRoomInfo.getRows(); i++, row++) {
            column = 1;
            for(int j = 0; j < cinemaRoomInfo.getColumns(); j++) {
                Seat seat = new Seat(row, column++);
                seatRepository.save(seat);
            }
        }
        return new ResponseStatus(true);
    }

    @Override
    public ResponseStatus addRoomStatus(Long id, CustomSoloRequest roomStatusId) {
        //find cinemaRoom according ID from URL
        CinemaRoom cinemaRoom = cinemaRoomRepository.findOne(id);
        if (cinemaRoom == null) {
            return new ResponseStatus();
        }
        //find roomStatus according information from request body
        RoomStatus roomStatus = roomStatusRepository.findOne(roomStatusId.getId());
        if (roomStatus == null) {
            return new ResponseStatus();
        }
        //bind cinemaRoom and roomStatus and commit action in db
        cinemaRoom.setRoomStatus(roomStatus);
        cinemaRoomRepository.save(cinemaRoom);
        return new ResponseStatus(true);
    }
}
