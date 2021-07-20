package edu.escuelaing.BetNow.Persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.escuelaing.BetNow.Modelo.Apuesta;



public interface BetRepository extends MongoRepository<Apuesta, String>{

}
