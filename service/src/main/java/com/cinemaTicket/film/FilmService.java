package com.cinemaTicket.film;


import com.cinemaTicket.core.CustomMonoRequest;
import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;

public interface FilmService {
    ResponseStatus addGenres(Long id, CustomMonoRequest genres);
    ResponseStatus addInfo(Long id, CustomMonoRequest info);
    ResponseStatus addComment(Long id, CustomSoloRequest comment);
}
