package com.informatorio.movieFest.service;

import com.informatorio.movieFest.domain.Actor;
import com.informatorio.movieFest.domain.Film;
import com.informatorio.movieFest.repository.ActorRepository;
import com.informatorio.movieFest.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmService implements IFilmService {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    ActorRepository actorRepository;

    public void createFilm(Film film) {
        filmRepository.save(film);
    }


    public void addActorToMovie(Long idFilm, List<Long> actorIds){

        Film film = filmRepository.findById(idFilm).orElse(null); //veo si la pelicula existe
        List<Actor> actors = actorIds.stream()
                .map(id->actorRepository.findById(id))//busca todos los actores en la db
                .filter(Optional::isPresent) //filtra los valores null
                .map(Optional::get)//saca el valor del optional
                .collect(Collectors.toList());//almacena el valor en la lista actors

        for(Actor actor: actors){
            film.addactor(actor);
        }
        filmRepository.save(film);


    }

}
