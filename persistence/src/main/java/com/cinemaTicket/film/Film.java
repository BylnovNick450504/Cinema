package com.cinemaTicket.film;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.core.DatePrinter;
import com.cinemaTicket.film.filmDTO.FilmDTO;
import com.cinemaTicket.show.CinemaShow;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "film")
public class Film extends BaseEntity {

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Size(min = 1, max = 100)
    private String producer;

    @NotNull
    private Integer budget;

    @NotNull
    private Date premiereDate;

    @NotNull
    private String description;

    @NotNull
    private Integer age;

    @NotNull
    private Integer rating;

    @NotNull
    private Double recommendTicketCost;

    @NotNull
    private Integer filmStatus;

    @NotNull
    private String picturePath;

    @NotNull
    private Integer duration;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<CinemaShow> cinemaShows = new ArrayList<>();

    public Film() {
    }

    public Film(String name,
                String producer,
                Integer budget,
                Date premiereDate,
                Integer age,
                String description,
                Integer rating,
                Double recommendTicketCost,
                String picturePath,
                Integer duration
    ) {
        this.name = name;
        this.producer = producer;
        this.budget = budget;
        this.premiereDate = premiereDate;
        this.age = age;
        this.description = description;
        this.rating = rating;
        this.recommendTicketCost = recommendTicketCost;
        this.picturePath = picturePath;
        this.duration = duration;
        this.filmStatus = 1;
    }

    public void updateFilm(Film film) {
        this.name = film.getName();
        this.producer = film.getProducer();
        this.budget = film.getBudget();
        this.premiereDate = film.getPremiereDate();
        this.age = film.getAge();
        this.description = film.getDescription();
        this.rating = film.getRating();
        this.recommendTicketCost = film.getRecommendTicketCost();
        this.picturePath = film.getPicturePath();
        this.duration = film.getDuration();
        this.filmStatus = film.getFilmStatus();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Double getRecommendTicketCost() {
        return recommendTicketCost;
    }

    public void setRecommendTicketCost(Double recommendTicketCost) {
        this.recommendTicketCost = recommendTicketCost;
    }

    public List<CinemaShow> getCinemaShows() {
        return cinemaShows;
    }

    public void setCinemaShows(List<CinemaShow> cinemaShows) {
        this.cinemaShows = cinemaShows;
    }

    public Integer getFilmStatus() {
        return filmStatus;
    }

    public void setFilmStatus(Integer filmStatus) {
        this.filmStatus = filmStatus;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void update(FilmDTO filmDTO) {
        name = filmDTO.getName();
        producer = filmDTO.getProducer();
        budget = filmDTO.getBudget();
        premiereDate = DatePrinter.convertToDate(filmDTO.getPremiereDate());
        description = filmDTO.getDescription();
        age = filmDTO.getAge();
        rating = filmDTO.getRating();
        recommendTicketCost = filmDTO.getRecommendTicketCost();
        filmStatus = filmDTO.getStatus();
        picturePath = filmDTO.getPicturePath();
        duration = filmDTO.getDuration();
    }
}

