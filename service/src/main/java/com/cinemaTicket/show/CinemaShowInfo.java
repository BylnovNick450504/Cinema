package com.cinemaTicket.show;


import java.util.Date;

public class CinemaShowInfo {
    private Date showDate;
    private Integer status;
    private Long filmId;
    private Long cinemaRoomId;

    public CinemaShowInfo() {
    }

    public CinemaShowInfo(Date showDate,
                          Integer status,
                          Long filmId,
                          Long cinemaRoomId
    ) {
        this.showDate = showDate;
        this.status = status;
        this.filmId = filmId;
        this.cinemaRoomId = cinemaRoomId;
    }

    public Date getShowDate() {
        return showDate;
    }

    public Integer getStatus() {
        return status;
    }

    public Long getFilmId() {
        return filmId;
    }

    public Long getCinemaRoomId() {
        return cinemaRoomId;
    }
}
