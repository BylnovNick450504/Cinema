package com.cinemaTicket.user;

import com.cinemaTicket.security.JwtTokenUtil;
import com.cinemaTicket.security.custom.JwtUser;
import com.cinemaTicket.ticket.TicketInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    private final UserService userService;
    private JwtTokenUtil jwtTokenUtil;
    private UserDetailsService userDetailsService;
    private final String tokenHeader = "Authorization";

    @Autowired
    public UserController(UserService userService, JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }


    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }

    @RequestMapping(value = "/users/orderTicket", method = RequestMethod.POST)
    ResponseEntity<?> orderTicket(TicketInfo ticketInfo, HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        return userService.orderTicket(username, ticketInfo);
        //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
