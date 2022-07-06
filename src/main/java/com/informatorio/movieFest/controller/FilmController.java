package com.informatorio.movieFest.controller;

import com.informatorio.movieFest.domain.Actor;
import com.informatorio.movieFest.domain.Film;
import com.informatorio.movieFest.repository.ActorRepository;
import com.informatorio.movieFest.repository.FilmRepository;
import com.informatorio.movieFest.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FilmController {
    @Autowired
    FilmRepository filmRepository;

    @Autowired
    ActorRepository actorRepository;

    public FilmController(FilmRepository filmRepository, ActorRepository actorRepository) {
        this.filmRepository = filmRepository;
        this.actorRepository = actorRepository;
    }

    @Autowired
    IFilmService iFilmService;

    @PostMapping("/film")
    public ResponseEntity<?> addStudent(@RequestBody Film film) {
        iFilmService.createFilm(film);
        return ResponseEntity.status(HttpStatus.OK).body("LA peliculo ha sido agragado");

    }

    @PostMapping("/film/{idFilm}/actor")
    public ResponseEntity<?> addAcotr(@PathVariable Long idFilm, @RequestBody List<Long> actorIds) {

        iFilmService.addActorToMovie(idFilm, actorIds);
        return ResponseEntity.status(HttpStatus.OK).body("El Actor se ha agragado a la Pelicula");
    }

    //para este metodo se necesita un actorRepository.Inyectar debajo de film repositori
    //luego se crea una lista con los idfilms List<Actor> actors = actorIds
   /* @PostMapping("/film/{idFilm}/actor")
    public String addActorToMovie(@PathVariable Long idFilm, @RequestBody List<Long> actorIds) {

        Film film = filmRepository.findById(idFilm).orElse(null); //veo si la pelicula existe
        List<Actor> actors = actorIds.stream()
                .map(id -> actorRepository.findById(id))//busca todos los actores en la db
                .filter(Optional::isPresent) //filtra los valores null
                .map(Optional::get)//saca el valor del optional
                .collect(Collectors.toList());//almacena el valor en la lista actors

        for (Actor actor : actors) {
            film.addactor(actor);
        }
        filmRepository.save(film);
        return "OK";

    }*/

}