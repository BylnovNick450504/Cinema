package com.cinemaTicket.room;

import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.room.dtoCinemaRoom.CinemaRoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaRoomController {

    private final CinemaRoomService cinemaRoomService;

    @Autowired
    public CinemaRoomController(CinemaRoomService cinemaRoomService) {
        this.cinemaRoomService = cinemaRoomService;
    }

    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public ResponseEntity<?> createCinemaRoom(@RequestBody CinemaRoom cinemaRoom) {
        return cinemaRoomService.createCinemaRoom(cinemaRoom);
    }

    @RequestMapping(value = "/room/detach/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> detachCinemaRoom(@PathVariable Long id) {
        return cinemaRoomService.detachCinemaRoom(id);
    }

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public ResponseEntity<?> getActiveCinemaRoomList() {
        return cinemaRoomService.getActiveCinemaRooms();
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSafeCinemaRoom(@PathVariable Long id) {
        return cinemaRoomService.deleteSafe(id);
    }

    @RequestMapping(value = "/room", method = RequestMethod.PUT)
    public ResponseEntity<?> changeCinemaRoom(@RequestBody CinemaRoomDTO cinemaRoomDTO) {
        return cinemaRoomService.updateCinemaRoom(cinemaRoomDTO);
    }

    @RequestMapping(value = "/room/check", method = RequestMethod.POST)
    public ResponseEntity<?> isUsed(@RequestBody CustomSoloRequest roomId) {
        return cinemaRoomService.isUsed(roomId);
    }
}
