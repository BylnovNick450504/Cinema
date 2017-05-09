package com.cinemaTicket.film.mock;

import java.util.Date;

public class MockFilm {
    private String name;
    private String producer;
    private double budget;
    private Date premiereDate;
    private String description;
    private int age;
    private int rating;
    private int recommendTicketCost;
    private String picturePath;

    public MockFilm() {}

    public MockFilm(String name,
                    String producer,
                    double budget,
                    Date premiereDate,
                    String description,
                    int age,
                    int rating,
                    int recommendTicketCost,
                    String picturePath

    ) {
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

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public double getBudget() {
        return budget;
    }

    public Date getPremiereDate() {
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
}
