package com.cinemaTicket.cinema.dtoCinemaComment;

import com.cinemaTicket.cinema.CinemaComment;
import com.cinemaTicket.core.DatePrinter;

public class CinemaCommentDTO {
    private Long id;
    private String comment;
    private String username;
    private String date;

    public CinemaCommentDTO() {
    }

    public CinemaCommentDTO(String comment, String username, String date) {
        this.comment = comment;
        this.username = username;
        this.date = date;
    }

    public CinemaCommentDTO(CinemaComment cinemaCommentItem) {
        this.id = cinemaCommentItem.getId();
        this.comment = cinemaCommentItem.getComment();
        this.username = cinemaCommentItem.getUser().getUsername();
        this.date = DatePrinter.printDayMonthYearHourMin(cinemaCommentItem.getDate());
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public String getUsername() {
        return username;
    }

    public String getDate() {
        return date;
    }

}
