package com.cinemaTicket.film.filmDTO;

import java.util.ArrayList;
import java.util.List;

public class FilmDTOList {
    private List<FilmDTO> filmDTOList = new ArrayList<>();

    public FilmDTOList() {
    }

    public FilmDTOList(List<FilmDTO> filmDTOList) {
        this.filmDTOList = filmDTOList;
    }

    public List<FilmDTO> getFilmDTOList() {
        return filmDTOList;
    }

    public void setFilmDTOList(List<FilmDTO> filmDTOList) {
        this.filmDTOList = filmDTOList;
    }
}
