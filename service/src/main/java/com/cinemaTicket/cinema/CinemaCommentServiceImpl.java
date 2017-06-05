package com.cinemaTicket.cinema;

import com.cinemaTicket.cinema.dtoCinemaComment.CinemaCommentDTO;
import com.cinemaTicket.core.ResponseStatus;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CinemaCommentServiceImpl implements CinemaCommentService {

    private final CinemaCommentRepository cinemaCommentRepository;

    @Autowired
    public CinemaCommentServiceImpl(CinemaCommentRepository cinemaCommentRepository) {
        this.cinemaCommentRepository = cinemaCommentRepository;
    }

    @Override
    public ResponseEntity<?> getCinemaComments() {
        Iterable<CinemaComment> cinemaComments = cinemaCommentRepository.findAll();
        List<CinemaCommentDTO> cinemaCommentDTOS = new ArrayList<>();

        for (CinemaComment cinemaComment : cinemaComments) {
            CinemaCommentDTO cinemaCommentDTO = new CinemaCommentDTO(cinemaComment);
            cinemaCommentDTOS.add(cinemaCommentDTO);
        }
        return new ResponseEntity<>(cinemaCommentDTOS, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deleteCinemaComment(Long cinemaCommentId) {
        CinemaComment cinemaComment = cinemaCommentRepository.findOne(cinemaCommentId);
        System.out.println(cinemaComment);
        if (cinemaComment == null) {
            return new ResponseEntity<>(new ResponseStatus(false, "no cinemaComment"), HttpStatus.CREATED);
        }
        cinemaCommentRepository.delete(cinemaCommentId);
        return new ResponseEntity<>(new ResponseStatus(true, "cinemaComment is deleted"), HttpStatus.CREATED);
    }
}
