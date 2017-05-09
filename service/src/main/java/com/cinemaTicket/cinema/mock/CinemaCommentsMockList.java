package com.cinemaTicket.cinema.mock;

import java.util.List;


public class CinemaCommentsMockList {
    private List<CinemaCommentMock> cinemaCommentMockList;

    public CinemaCommentsMockList() {
    }

    public CinemaCommentsMockList(List<CinemaCommentMock> cinemaCommentMockList) {
        this.cinemaCommentMockList = cinemaCommentMockList;
    }

    public List<CinemaCommentMock> getCinemaCommentMockList() {
        return cinemaCommentMockList;
    }

    public void setCinemaCommentMockList(List<CinemaCommentMock> cinemaCommentMockList) {
        this.cinemaCommentMockList = cinemaCommentMockList;
    }
}
