package com.cinemaTicket.cinema.mock;


import com.cinemaTicket.cinema.CinemaComment;

import java.util.Date;

public class CinemaCommentMock {
    private String comment;
    private String username;
    private String date;

    public CinemaCommentMock() {
    }

    public CinemaCommentMock(String comment, String username, String date) {
        this.comment = comment;
        this.username = username;
        this.date = date;
    }

    private String checkDigit(int digit) {
        if (digit < 10) {
            return "0"+digit;
        }
        return ""+digit;
    }

    private String convertYear(int year) {
        return "20"+year%100;
    }

    public CinemaCommentMock(CinemaComment cinemaCommentItem) {
        this.comment = cinemaCommentItem.getComment();
        this.username = cinemaCommentItem.getUser().getUsername();
        Date tempDate = cinemaCommentItem.getDate();
        StringBuffer buf = new StringBuffer();
        buf.append(checkDigit(tempDate.getDay()));
        buf.append(".");
        buf.append(checkDigit(tempDate.getMonth()));
        buf.append(".");
        buf.append(convertYear(tempDate.getYear()));
        buf.append(" ");
        buf.append(tempDate.getHours());
        buf.append(":");
        buf.append(tempDate.getMinutes());
        this.date = buf.toString();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
