package com.cinemaTicket.film;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {
}
