package com.cinemaTicket.room;

import com.cinemaTicket.show.CinemaShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Past;

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
}
