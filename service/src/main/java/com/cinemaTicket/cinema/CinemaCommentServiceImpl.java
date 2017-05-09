package com.cinemaTicket.cinema;

import com.cinemaTicket.cinema.mock.CinemaCommentMock;
import com.cinemaTicket.cinema.mock.CinemaCommentsMockList;
import org.springframework.beans.factory.annotation.Autowired;
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
    public CinemaCommentsMockList getCinemaComments() {
        Iterable<CinemaComment> cinemaComments = cinemaCommentRepository.findAll();
        List<CinemaCommentMock> cinemaCommentMocks = new ArrayList<>();

        for (CinemaComment cinemaComment : cinemaComments) {
            CinemaCommentMock cinemaCommentMock = new CinemaCommentMock(cinemaComment);
            cinemaCommentMocks.add(cinemaCommentMock);
        }
        return new CinemaCommentsMockList(cinemaCommentMocks);
    }
}

