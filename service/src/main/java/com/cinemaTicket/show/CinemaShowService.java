package com.cinemaTicket.show;


import com.cinemaTicket.core.CustomSoloRequest;
import org.springframework.http.ResponseEntity;

public interface CinemaShowService {
    ResponseEntity<?> addFilm(Long id, CustomSoloRequest filmItem);
    ResponseEntity<?> addCinemaRoom(Long id, CustomSoloRequest cinemaRoomItem);
    ResponseEntity<?> createCinemaShow(CinemaShow cinemaShow);
    ResponseEntity<?> updateCinemaShow(Long id, CinemaShow cinemaShow);
    ResponseEntity<?> deleteCinemaShow(Long id);
    ResponseEntity<?> createAndInitCinemaShow(CinemaShowInfo cinemaShowInfo);
    ResponseEntity<?> getCinemaShowByFilm(Long filmId);
}
