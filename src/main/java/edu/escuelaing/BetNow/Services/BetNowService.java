package edu.escuelaing.BetNow.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.BetNow.Modelo.Apuesta;
import edu.escuelaing.BetNow.Modelo.Usuario;
import edu.escuelaing.BetNow.Persistence.DataBaseConection;


@Service("BetNow")
public class BetNowService {

	@Autowired
	DataBaseConection dbService;

	public String createUser(Usuario usuario) {
		return dbService.insertarUsuario();
	}

	
}
