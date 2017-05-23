package com.cinemaTicket.show;

public class CinemaShowInfo {
    private Long showDate;
    private Integer status;
    private Long filmId;
    private Long cinemaRoomId;
    private Double coefficient;

    public CinemaShowInfo() {
    }

    public CinemaShowInfo(
        Long showDate,
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

    public Long getShowDate() {
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
