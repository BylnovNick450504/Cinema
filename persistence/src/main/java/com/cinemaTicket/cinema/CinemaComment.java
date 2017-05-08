package com.cinemaTicket.cinema;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.user.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cinema_comment")
public class CinemaComment extends BaseEntity {

    @Lob
    @Type(type = "text")
    private String comment;

    @OneToOne
    @JoinColumn(name = "creator_id")
    private User user;

    private Date date;

    public CinemaComment() {
    }

    public CinemaComment(String comment, Date date) {
        this.comment = comment;
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
