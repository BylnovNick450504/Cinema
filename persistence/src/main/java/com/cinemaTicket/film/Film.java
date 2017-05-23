package com.cinemaTicket.film;

import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.core.DatePrinter;
import com.cinemaTicket.film.comment.FilmComment;
import com.cinemaTicket.film.filmDTO.FilmDTO;
import com.cinemaTicket.film.genre.Genre;
import com.cinemaTicket.show.CinemaShow;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "film")
public class Film extends BaseEntity {

    private String name;
    private String producer;
    private Double budget;
    private Date premiereDate;
    private String description;
    private Integer age;
    private Integer rating;
    private Integer recommendTicketCost;
    private Integer filmStatus;
    private String picturePath;
    private Integer duration;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_genre")
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<FilmComment> filmComments = new ArrayList<>();

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<CinemaShow> cinemaShows = new ArrayList<>();

    public Film() {
    }

    public Film(String name,
                String producer,
                double budget,
                Date premiereDate,
                int age,
                String description,
                int rating,
                int recommendTicketCost,
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

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<FilmComment> getFilmComments() {
        return filmComments;
    }

    public void setFilmComments(List<FilmComment> filmComments) {
        this.filmComments = filmComments;
    }

    public void addGenre(Genre genreItem) {
        genres.add(genreItem);
    }

    public void addComment(FilmComment filmCommentItem) {
        filmComments.add(filmCommentItem);
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

    public int getRecommendTicketCost() {
        return recommendTicketCost;
    }

    public void setRecommendTicketCost(int recommendTicketCost) {
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

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setRecommendTicketCost(Integer recommendTicketCost) {
        this.recommendTicketCost = recommendTicketCost;
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

