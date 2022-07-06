package com.informatorio.movieFest.controller;

import com.informatorio.movieFest.domain.Actor;
import com.informatorio.movieFest.repository.ActorRepository;
import com.informatorio.movieFest.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {


    //ActorRepository actorRepository;

    //public ActorController(ActorRepository actorRepository) {
     //   this.actorRepository = actorRepository;
   // }
    @Autowired
    IActorService iActorService;
    @PostMapping("/actor")
    public ResponseEntity<?> addStudent(@RequestBody Actor actor){
        iActorService.createActor(actor);
        return ResponseEntity.ok(HttpStatus.OK);
    //public Actor createActor(@ReiquestBody Actor actor){
      //  return actorRepository.save(actor);

    }
}
