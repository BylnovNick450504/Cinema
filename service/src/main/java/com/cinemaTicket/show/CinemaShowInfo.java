package com.cinemaTicket.show;


import java.util.Date;

public class CinemaShowInfo {
    private Date showDate;
    private Integer status;
    private Long filmId;
    private Long cinemaRoomId;
    private Double coefficient;

    public CinemaShowInfo() {
    }

    public CinemaShowInfo(Date showDate,
                          Integer status,
                          Long filmId,
                          Long cinemaRoomId,
                          Double coefficient
    ) {
        this.showDate = showDate;
        this.status = status;
        this.filmId = filmId;
        this.cinemaRoomId = cinemaRoomId;
        this.coefficient = coefficient;
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

    public Double getCoefficient() {
        return coefficient;
    }
}
