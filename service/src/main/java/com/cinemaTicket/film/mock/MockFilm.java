package com.cinemaTicket.film.mock;

import com.cinemaTicket.film.Film;

import java.util.Date;

public class MockFilm {
    private Long id;
    private String name;
    private String producer;
    private double budget;
    private String premiereDate;
    private String description;
    private int age;
    private int rating;
    private int recommendTicketCost;
    private String picturePath;


    public MockFilm() {}

    public MockFilm(Long id,
                    String name,
                    String producer,
                    double budget,
                    String premiereDate,
                    String description,
                    int age,
                    int rating,
                    int recommendTicketCost,
                    String picturePath

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
    }

    public MockFilm(Film film) {
        this.id = film.getId();
        this.name = film.getName();
        this.producer = film.getProducer();
        this.budget = film.getBudget();
        this.premiereDate = convertData(film.getPremiereDate());
        this.description = film.getDescription();
        this.age = film.getAge();
        this.rating = film.getRating();
        this.recommendTicketCost = film.getRecommendTicketCost();
        this.picturePath = film.getPicturePath();
    }

    private String checkDayAndMonth(int digit) {
        if (digit < 10) {
            return "0" + digit;
        }
        return  "" + digit;
    }

    private String checkYear(int year) {
        return "20" + year%100;
    }

    private String convertData(Date date) {
        return "" + checkDayAndMonth(date.getDay()) +
                "." +
                checkDayAndMonth(date.getMonth()) +
                "." +
                checkYear(date.getYear());
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public double getBudget() {
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

    public int getRecommendTicketCost() {
        return recommendTicketCost;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public Long getId() {
        return id;
    }
}
