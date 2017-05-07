package com.cinemaTicket.room;


import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.seat.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CinemaRoomServiceImpl implements CinemaRoomService{

    private final CinemaRoomRepository cinemaRoomRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public CinemaRoomServiceImpl(CinemaRoomRepository cinemaRoomRepository,
                                 SeatRepository seatRepository
    ) {
        this.cinemaRoomRepository = cinemaRoomRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public ResponseStatus initCinemaRoom(Long id, CinemaRoomInfo cinemaRoomInfo) {
        CinemaRoom cinemaRoom;
        int column = 1;
        int row = 1;
        final long SEAT_STATUS_ID = 1;
        final String SEAT_STATUS = "FREE";
        //find cinemaRoom in db
        cinemaRoom = cinemaRoomRepository.findOne(id);
        if (cinemaRoom == null) {
            return new ResponseStatus();
        }
        cinemaRoom.setRoomStatus(1);
        //generate seat for current cinemaRoom and save them in db
        for(int i = 0; i < cinemaRoomInfo.getRows(); i++, row++) {
            column = 1;
            for(int j = 0; j < cinemaRoomInfo.getColumns(); j++) {
                Seat seat = new Seat(row, column++);
                seat.setCinemaRoom(cinemaRoom);
                seatRepository.save(seat);
            }
        }
        return new ResponseStatus(true);
    }

    @Override
    public ResponseEntity<?> createCinemaRoom(CinemaRoom cinemaRoomItem) {
        int column;
        int row = 1;
        //generate seat for current cinemaRoom and save them in db
        for(int i = 0; i < cinemaRoomItem.getRow(); i++, row++) {
            column = 1;
            for(int j = 0; j < cinemaRoomItem.getCol(); j++) {
                Seat seat = new Seat(row, column++);
                cinemaRoomItem.addSeat(seat);
            }
        }
        cinemaRoomItem.setRoomStatus(1);
        cinemaRoomRepository.save(cinemaRoomItem);
        return new ResponseEntity<>(new ResponseStatus(true, "cinema room is created"),
                                    HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> detachCinemaRoom(Long id) {
        CinemaRoom cinemaRoom = cinemaRoomRepository.findOne(id);
        if (cinemaRoom == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no cinemaRoom"),
                                        HttpStatus.NOT_FOUND);
        }
        for(Seat seatTemp: cinemaRoom.getSeats()) {
            seatTemp.setCinemaRoom(null);

        }
        cinemaRoom.getSeats().clear();
        cinemaRoomRepository.delete(cinemaRoom);
        return new ResponseEntity<>(new ResponseStatus(), HttpStatus.CREATED);
    }
}
