package com.cinemaTicket.show;

import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.show.dtoCinemaShow.CinemaShowInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaShowController {

    private final CinemaShowService cinemaShowService;

    @Autowired
    public CinemaShowController(CinemaShowService cinemaShowService) {
        this.cinemaShowService = cinemaShowService;
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createCinemaShow(@RequestBody CinemaShow cinemaShow) {
        return cinemaShowService.createCinemaShow(cinemaShow);
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.PUT)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateCinemaShow(@PathVariable Long id, @RequestBody CinemaShow cinemaShow) {
        return cinemaShowService.updateCinemaShow(id, cinemaShow);
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.DELETE)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteCinemaShow(@PathVariable Long id) {
        return cinemaShowService.deleteCinemaShow(id);
    }

    @RequestMapping(value = "/show/{id}/bind/film", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> bindFilm(@PathVariable Long id, @RequestBody CustomSoloRequest filmItem) {
        return cinemaShowService.addFilm(id, filmItem);
    }

    @RequestMapping(value = "/show/{id}/bind/cinemaRoom", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> bindCinemaRoom(@PathVariable Long id, @RequestBody CustomSoloRequest cinemaRoomItem) {
        return cinemaShowService.addCinemaRoom(id, cinemaRoomItem);
    }

    @RequestMapping(value = "/show/createAndInit", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createAndInitCinemaRoom(@RequestBody CinemaShowInfo cinemaShowInfo) {
        return cinemaShowService.createAndInitCinemaShow(cinemaShowInfo);
    }

    @RequestMapping(value = "/show/getByFilm", method = RequestMethod.GET)
    public ResponseEntity<?> getCinemaShowByFilm(@RequestParam(name = "filmId") Long filmId) {
        return cinemaShowService.getCinemaShowByFilm(filmId);
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ResponseEntity<?> getCinemaShowList() {
        return cinemaShowService.getCinemaShowList();
    }

    @RequestMapping(value = "/show/safe/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteSafeCinemaShow(@PathVariable Long id) {
        return cinemaShowService.deleteSafeCinemaShow(id);
    }
}
