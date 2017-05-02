package com.cinemaTicket.user;

import com.cinemaTicket.cinema.CinemaComment;
import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.film.comment.FilmComment;
import com.cinemaTicket.ticket.Ticket;
import com.cinemaTicket.user.role.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "person")
public class User extends BaseEntity {

    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private String username;
    private String email;
    private String phoneNumber;
    private String name;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FilmComment> filmComments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CinemaComment> cinemaComments = new ArrayList<>();

    @Column(name = "last_password_reset_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordResetDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ROLE_PERSON")
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(String username,
                String password,
                String email,
                String phoneNumber,
                String name) {
        this.username = username;
        setPassword(password);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<FilmComment> getFilmComments() {
        return filmComments;
    }

    public void setFilmComments(List<FilmComment> filmComments) {
        this.filmComments = filmComments;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<CinemaComment> getCinemaComments() {
        return cinemaComments;
    }

    public void setCinemaComments(List<CinemaComment> cinemaComments) {
        this.cinemaComments = cinemaComments;
    }

    public void addFilmComment(FilmComment filmCommentItem) {
        filmComments.add(filmCommentItem);
    }

    public void addCinemaComment(CinemaComment cinemaCommentItem) {
        cinemaComments.add(cinemaCommentItem);
        cinemaCommentItem.setUser(this);
    }

    public void addTicket(Ticket ticketItem) {
        tickets.add(ticketItem);
        ticketItem.setUser(this);
    }
    //replace i n Role
    public void addRole(Role roleItem) {
        roles.add(roleItem);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
