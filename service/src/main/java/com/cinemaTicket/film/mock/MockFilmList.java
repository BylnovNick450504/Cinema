package com.cinemaTicket.film.mock;

import java.util.ArrayList;
import java.util.List;

public class MockFilmList {
    private List<MockFilm> mockFilmList = new ArrayList<>();

    public MockFilmList() {
    }

    public MockFilmList(List<MockFilm> mockFilmList) {
        this.mockFilmList = mockFilmList;
    }

    public List<MockFilm> getMockFilmList() {
        return mockFilmList;
    }

    public void setMockFilmList(List<MockFilm> mockFilmList) {
        this.mockFilmList = mockFilmList;
    }
}
