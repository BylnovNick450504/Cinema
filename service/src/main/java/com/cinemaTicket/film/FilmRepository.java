package com.cinemaTicket.film;

import com.cinemaTicket.film.genre.Genre;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {
    List<Film> findByName(@Param("name") String name);
    List<Film> findByPremiereDate(@Param("premiereDate") Date date);
    List<Film> findByGenres(Genre genre);
    List<Film> findByAgeGreaterThan(int age);
}
