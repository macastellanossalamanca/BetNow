package edu.escuelaing.BetNow.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.BetNow.Modelo.Apuesta;
import edu.escuelaing.BetNow.Modelo.Usuario;
import edu.escuelaing.BetNow.Persistence.DataBaseConnection;

@Service("BetNow")
public class BetNowService {

	@Autowired
	DataBaseConnection dbService;

	public String createUser(Usuario usuario) {
		return dbService.insertarUsuario(usuario);
	}

	public List<Apuesta> findAll() {
		return dbService.buscarApuestas();
	}

	public List<Apuesta> findBetsById(String id) {

		return dbService.buscarApuestas(id);
	}

	public Usuario login(Usuario usuario) {
		return dbService.login(usuario);
	}
}
