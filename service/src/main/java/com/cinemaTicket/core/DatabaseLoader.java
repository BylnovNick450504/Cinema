package com.cinemaTicket.core;



import com.cinemaTicket.seat.seatStatus.SeatStatus;
import com.cinemaTicket.seat.seatStatus.SeatStatusRepository;
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

    private final SeatStatusRepository seatStatusRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public DatabaseLoader(SeatStatusRepository seatStatusRepository,
                          UserRepository userRepository,
                          RoleRepository roleRepository) {
        this.seatStatusRepository = seatStatusRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        SeatStatus st1 = new SeatStatus("FREE");
        SeatStatus st2 = new SeatStatus("BOOKED");
        SeatStatus st3 = new SeatStatus("SOLD");

        seatStatusRepository.save(st1);
        seatStatusRepository.save(st2);
        seatStatusRepository.save(st3);

        Date date = new Date(2017, 6, 100, 13, 59, 00);


        User user1 = new User("bigboss","1234", "main@tut.by", "5340645","nick");
        User user2 = new User("zhenyaZap","letmein", "zap@tut.by", "3450236", "evgen");
        User user3 = new User("mosya","password", "helg@tut.by", "5972341238", "olga");

        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");
        roleRepository.save(role1);
        roleRepository.save(role2);


        user1.addRole(role1);
        user2.addRole(role2);
        user3.addRole(role1);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
