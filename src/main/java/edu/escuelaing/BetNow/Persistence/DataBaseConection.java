package edu.escuelaing.BetNow.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.BetNow.Modelo.Usuario;

@Service("DBConection")
public class DataBaseConection {
	
	@Autowired
	private UserRepository userRepository;

	public String insertarUsuario() {
		userRepository.save(new Usuario("Miguel","macastellanoss@hotmail.com"));
		return userRepository.findByFirstName("Miguel").getId();
	}

}
