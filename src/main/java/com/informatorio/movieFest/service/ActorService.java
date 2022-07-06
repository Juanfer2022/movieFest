package com.informatorio.movieFest.service;

import com.informatorio.movieFest.domain.Actor;
import com.informatorio.movieFest.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService implements IActorService{
    @Autowired
    ActorRepository actorRepository;

    public void createActor(Actor actor){
      actorRepository.save(actor);
    }
}


