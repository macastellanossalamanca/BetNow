package edu.escuelaing.BetNow.Persistence;




import org.springframework.data.mongodb.repository.MongoRepository;

import edu.escuelaing.BetNow.Modelo.Usuario;



public interface UserRepository extends MongoRepository<Usuario, String> {

	Usuario findBycorreo(String correo);

	

	 
	  
}
