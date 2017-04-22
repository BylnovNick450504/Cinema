package com.cinemaTicket.user;

import com.cinemaTicket.cinema.CinemaComment;
import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.film.comment.FilmComment;
import com.cinemaTicket.ticket.Ticket;
import com.cinemaTicket.user.role.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<FilmComment> filmComments = new ArrayList<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<CinemaComment> cinemaComments = new ArrayList<>();

    public Person() {
    }

    public Person(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
    }

    public void addTicket(Ticket ticketItem) {
        tickets.add(ticketItem);
    }
}
