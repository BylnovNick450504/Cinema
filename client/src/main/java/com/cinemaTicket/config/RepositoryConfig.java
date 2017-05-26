package com.cinemaTicket.config;

import com.cinemaTicket.film.Film;
import com.cinemaTicket.room.CinemaRoom;
import com.cinemaTicket.seat.Seat;
import com.cinemaTicket.show.CinemaShow;
import com.cinemaTicket.ticket.Ticket;
import com.cinemaTicket.user.User;
import com.cinemaTicket.user.role.Role;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(
                Seat.class,
                CinemaRoom.class,
                CinemaShow.class,
                Ticket.class,
                Film.class,
                User.class,
                Role.class
        );
    }
}
