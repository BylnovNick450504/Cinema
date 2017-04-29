package com.cinemaTicket.film.comment;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.film.Film;
import com.cinemaTicket.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "film_comment")
public class FilmComment extends BaseEntity {

    private String comment;
    private Date commentDate;

    @OneToOne
    @JoinColumn(name = "creator_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;

    public FilmComment() {
    }

    public FilmComment(String comment, Date commentDate) {
        this.comment = comment;
        this.commentDate = commentDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
