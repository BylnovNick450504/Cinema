package com.cinemaTicket.user;

import com.cinemaTicket.cinema.CinemaComment;
import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.security.JwtTokenUtil;
import com.cinemaTicket.security.custom.JwtUser;
import com.cinemaTicket.ticket.TicketInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    private final UserService userService;
    private JwtTokenUtil jwtTokenUtil;
    private UserDetailsService userDetailsService;
    private final String tokenHeader = "Authorization";
    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    public UserController(UserService userService, JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    private String getUserName(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        return jwtTokenUtil.getUsernameFromToken(token);
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    ResponseEntity<?> createUser(@RequestBody  User user) {
        logger.info("user controller");
        return userService.createUser(user);

    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }

    @RequestMapping(value = "/users/orderTicket", method = RequestMethod.POST)
    ResponseEntity<?> orderTicket(@RequestBody  TicketInfo ticketInfo, HttpServletRequest request) {
        String username = getUserName(request);
        return userService.orderTicket(username, ticketInfo);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    ResponseEntity<?> editUser(@RequestBody  UserInfo user, HttpServletRequest request) {
        String username = getUserName(request);
        return userService.editUser(username, user);
    }

    @RequestMapping(value = "/users/createCinemaComment", method = RequestMethod.POST)
    ResponseEntity<?> createCinemaComment(@RequestBody CinemaComment cinemaComment, HttpServletRequest request) {
        String username = getUserName(request);
        return userService.createCinemaComment(username, cinemaComment);
    }

    @RequestMapping(value = "/users/order", method = RequestMethod.POST)
    ResponseEntity<?> createCinemaComment(@RequestBody CustomSoloRequest ticketId, HttpServletRequest request) {
        String username = getUserName(request);
        return userService.orderTicket(username, ticketId);
    }
}
