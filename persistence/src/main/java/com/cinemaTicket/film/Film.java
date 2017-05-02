package com.cinemaTicket.film;


import com.cinemaTicket.core.BaseEntity;
import com.cinemaTicket.film.comment.FilmComment;
import com.cinemaTicket.film.genre.Genre;
import com.cinemaTicket.film.info.FilmInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "film")
public class Film extends BaseEntity {
    private String name;
    private String producer;
    private double budget;
    private Date premiereDate;
    private String description;
    private int age;
    private int rating;
    private int recommendTicketCost;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "film_genre")
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "film_info")
    private List<FilmInfo> filmInfo = new ArrayList<>();

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<FilmComment> filmComments = new ArrayList<>();

    public Film() {
    }

    public Film(String name,
                String producer,
                double budget,
                Date premiereDate,
                int age,
                String description,
                int rating,
                int recommendTicketCost
    ) {
        this.name = name;
        this.producer = producer;
        this.budget = budget;
        this.premiereDate = premiereDate;
        this.age = age;
        this.description = description;
        this.rating = rating;
        this.recommendTicketCost = recommendTicketCost;
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

    public List<FilmInfo> getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(List<FilmInfo> filmInfo) {
        this.filmInfo = filmInfo;
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

    public void addInfo(FilmInfo infoItem) {
        filmInfo.add(infoItem);
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
}
