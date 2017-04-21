package com.cinemaTicket.film.comment;

import com.cinemaTicket.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "film_comment")
public class FilmComment extends BaseEntity {

    private String comment;
    private Date commentDate;

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
}
