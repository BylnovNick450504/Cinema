package com.cinemaTicket.film;

import com.cinemaTicket.core.CustomMonoRequest;
import com.cinemaTicket.core.CustomSoloRequest;
import com.cinemaTicket.core.ResponseStatus;
import com.cinemaTicket.film.comment.FilmComment;
import com.cinemaTicket.film.comment.FilmCommentRepository;
import com.cinemaTicket.film.genre.Genre;
import com.cinemaTicket.film.genre.GenreRepository;
import com.cinemaTicket.film.info.FilmInfo;
import com.cinemaTicket.film.info.FilmInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final GenreRepository genreRepository;
    private final FilmRepository filmRepository;
    private final FilmInfoRepository filmInfoRepository;
    private final FilmCommentRepository filmCommentRepository;

    @Autowired
    public FilmServiceImpl(GenreRepository genreRepository, FilmRepository filmRepository, FilmInfoRepository filmInfoRepository, FilmCommentRepository filmCommentRepository) {
        this.genreRepository = genreRepository;
        this.filmRepository = filmRepository;
        this.filmInfoRepository = filmInfoRepository;
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
    public ResponseStatus addInfo(Long id, CustomMonoRequest infoIds) {
        Film film = filmRepository.findOne(id);
        if (film == null) {
            return new ResponseStatus();
        }
        List<FilmInfo> filmInfoList = new ArrayList<>();
        for (Long filmInfoId : infoIds.getIds()) {
            FilmInfo filmInfo = filmInfoRepository.findOne(filmInfoId);
            if (filmInfo == null) {
                return new ResponseStatus();
            }
            filmInfoList.add(filmInfo);
        }
        film.setFilmInfo(filmInfoList);
        filmRepository.save(film);
        return new ResponseStatus(true);
    }

    @Override
    public ResponseStatus addComment(Long id, CustomSoloRequest comment) {
        return null;
    }
}
