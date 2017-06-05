package com.cinemaTicket.film.dtoFilm;

import com.cinemaTicket.core.DatePrinter;
import com.cinemaTicket.film.Film;

public class FilmDTO {
    private Long id;
    private String name;
    private String producer;
    private int budget;
    private String premiereDate;
    private String description;
    private int age;
    private int rating;
    private double recommendTicketCost;
    private int status;
    private String picturePath;
    private int duration;

    public FilmDTO() {}

    public FilmDTO(Long id,
                   String name,
                   String producer,
                   int budget,
                   String premiereDate,
                   String description,
                   int age,
                   int rating,
                   double recommendTicketCost,
                   int status,
                   String picturePath,
                   int duration
    ) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.budget = budget;
        this.premiereDate = premiereDate;
        this.description = description;
        this.age = age;
        this.rating = rating;
        this.recommendTicketCost = recommendTicketCost;
        this.picturePath = picturePath;
        this.duration = duration;
        this.status = status;
    }

    public FilmDTO(Film film) {
        this.id = film.getId();
        this.name = film.getName();
        this.producer = film.getProducer();
        this.budget = film.getBudget();
        this.premiereDate = DatePrinter.printDayMonthYear(film.getPremiereDate());
        this.description = film.getDescription();
        this.age = film.getAge();
        this.rating = film.getRating();
        this.recommendTicketCost = film.getRecommendTicketCost();
        this.picturePath = film.getPicturePath();
        this.duration = film.getDuration();
        this.status = film.getFilmStatus();
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public int getBudget() {
        return budget;
    }

    public String getPremiereDate() {
        return premiereDate;
    }

    public String getDescription() {
        return description;
    }

    public int getAge() {
        return age;
    }

    public int getRating() {
        return rating;
    }

    public double getRecommendTicketCost() {
        return recommendTicketCost;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public Long getId() {
        return id;
    }

    public Integer getDuration() {
        return duration;
    }

    public int getStatus() {
        return status;
    }

    public Film getFilm() {
        return new Film(
                getName(),
                getProducer(),
                getBudget(),
                DatePrinter.convertToDate(getPremiereDate()),
                getAge(),
                getDescription(),
                getRating(),
                getRecommendTicketCost(),
                getPicturePath(),
                getDuration(),
                getStatus()
        );
    }
}
