package com.cinemaTicket.film;

import com.cinemaTicket.core.CustomMonoRequest;
import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.film.comment.FilmComment;
import com.cinemaTicket.film.comment.FilmCommentRepository;
import com.cinemaTicket.film.genre.Genre;
import com.cinemaTicket.film.genre.GenreRepository;
import com.cinemaTicket.film.mock.MockFilm;
import com.cinemaTicket.film.mock.MockFilmList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final GenreRepository genreRepository;
    private final FilmRepository filmRepository;
    private final FilmCommentRepository filmCommentRepository;

    @Autowired
    public FilmServiceImpl(GenreRepository genreRepository, FilmRepository filmRepository, FilmCommentRepository filmCommentRepository) {
        this.genreRepository = genreRepository;
        this.filmRepository = filmRepository;
        this.filmCommentRepository = filmCommentRepository;
    }

    @Override
    public ResponseStatus addGenres(Long id, CustomMonoRequest genreIds) {
        Film film = filmRepository.findOne(id);
        if (film == null) {
            return new ResponseStatus();
        }
        List<Genre> genreList = new ArrayList<>();

        for (Long genreId : genreIds.getIds()) {
            Genre genre = genreRepository.findOne(genreId);
            if (genre == null) {
                return new ResponseStatus();
            }
            genreList.add(genre);
        }
        film.setGenres(genreList);
        filmRepository.save(film);
        return new ResponseStatus(true);
    }

    @Override
    public ResponseStatus addComment(Long id, CustomSoloRequest comment) {
        Film film = filmRepository.findOne(id);
        if (film == null) {
            return new ResponseStatus();
        }
        FilmComment filmComment = filmCommentRepository.findOne(comment.getId());
        if (filmComment == null) {
            return new ResponseStatus();
        }
        film.addComment(filmComment);
        filmRepository.save(film);
        return new ResponseStatus(true);
    }

    @Override
    public ResponseEntity<?> createFilm(Film film) {
        film = filmRepository.save(film);
        return new ResponseEntity<>(film, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateFilm(Long id, Film newFilm) {
        Film oldFilm = filmRepository.findOne(id);
        if (oldFilm == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        oldFilm.updateFilm(newFilm);
        filmRepository.save(oldFilm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deleteFilm(Long id) {
        filmRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public MockFilmList getByName(String name) {
        List<Film> filmList = filmRepository.findByName(name);
        List<MockFilm> mockFilms = new ArrayList<>();
        for (Film film : filmList) {
            MockFilm mockFilm = new MockFilm(film);
            mockFilms.add(mockFilm);
        }
        return new MockFilmList(mockFilms);
    }
}
