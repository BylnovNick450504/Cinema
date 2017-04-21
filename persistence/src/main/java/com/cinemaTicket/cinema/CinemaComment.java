package com.cinemaTicket.cinema;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.user.Person;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cinema_comment")
public class CinemaComment extends BaseEntity {
    private String comment;

    @OneToOne
    @JoinColumn(name = "creator_id")
    private Person person;

    public CinemaComment() {
    }

    public CinemaComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
