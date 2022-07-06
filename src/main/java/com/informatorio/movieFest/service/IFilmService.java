package com.informatorio.movieFest.service;

import com.informatorio.movieFest.domain.Film;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IFilmService {

    public void createFilm(Film film);
    public void addActorToMovie(Long idFilm, List<Long> actorIds);

}
