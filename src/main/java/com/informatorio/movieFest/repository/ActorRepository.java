package com.informatorio.movieFest.repository;

import com.informatorio.movieFest.domain.Actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long > {
}
