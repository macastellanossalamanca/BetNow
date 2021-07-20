package edu.escuelaing.BetNow.Persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.escuelaing.BetNow.Modelo.Evento;

public interface EventRepository extends MongoRepository<Evento, String>{

}
