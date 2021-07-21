package edu.escuelaing.BetNow.Persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.escuelaing.BetNow.Modelo.Apuesta;



public interface BetRepository extends MongoRepository<Apuesta, String>{

	
	public Optional<List<Apuesta>> findAllByevento();
	public Optional<List<Apuesta>> findAllByusuario();
}
