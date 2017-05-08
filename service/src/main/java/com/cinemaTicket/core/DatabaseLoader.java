package com.cinemaTicket.core;



import com.cinemaTicket.film.Film;
import com.cinemaTicket.film.FilmRepository;
import com.cinemaTicket.room.CinemaRoom;
import com.cinemaTicket.room.CinemaRoomRepository;
import com.cinemaTicket.user.User;
import com.cinemaTicket.user.UserRepository;
import com.cinemaTicket.user.role.Role;
import com.cinemaTicket.user.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DatabaseLoader implements ApplicationRunner {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final FilmRepository filmRepository;
    private final CinemaRoomRepository cinemaRoomRepository;

    @Autowired
    public DatabaseLoader(UserRepository userRepository,
                          RoleRepository roleRepository,
                          FilmRepository filmRepository,
                          CinemaRoomRepository cinemaRoomRepository
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.filmRepository = filmRepository;
        this.cinemaRoomRepository = cinemaRoomRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Date date1 = new Date(2017,6, 25);
        Film film1 = new Film("agent 008", "stolone", 100500, date1,  14, "new awesome action!",55, 4 );
        Film film2 = new Film("divergent", "jack black", 80000200, new Date(2016, 5, 10),  14, "for young people",40, 6 );
        Film film3 = new Film("defenders", "mixalkov", 30040, new Date(2015, 7, 9),  16, "not bad",30, 3 );

        filmRepository.save(film1);
        filmRepository.save(film2);
        filmRepository.save(film3);

        //////////////////////////////////////////////

        CinemaRoom cinemaRoom1 = new CinemaRoom("green", 15, 10);
        CinemaRoom cinemaRoom2 = new CinemaRoom("red",15, 10);
        CinemaRoom cinemaRoom3 = new CinemaRoom("blue",15, 10);

        cinemaRoomRepository.save(cinemaRoom1);
        cinemaRoomRepository.save(cinemaRoom2);
        cinemaRoomRepository.save(cinemaRoom3);



        User user1 = new User("bigboss","1234", "main@tut.by","nick");
        User user3 = new User("zhenyaZap","letmein", "zap@tut.by", "evgen");
        User user4 = new User("mosya","password", "helg@tut.by", "olga");
        User user5 = new User("qwerty","1234", "helg@tut.by", "olga");

        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");

//        role1.addUser(user1);
//        role1.addUser(user4);
//        role2.addUser(user3);
        roleRepository.save(role1);
        roleRepository.save(role2);
        user1.addRole(role1);
        user3.addRole(role2);
        user4.addRole(role1);
        user5.addRole(role1);

        userRepository.save(user1);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
    }
}
