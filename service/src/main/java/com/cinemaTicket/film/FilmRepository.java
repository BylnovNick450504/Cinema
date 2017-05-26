package com.cinemaTicket.film;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {
    List<Film> findByName(@Param("name") String name);
    List<Film> findByPremiereDate(@Param("premiereDate") Date date);
    List<Film> findByAgeLessThanEqual(int age);
}
