package com.cinemaTicket.film;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {
}
