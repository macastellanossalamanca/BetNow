package edu.escuelaing.BetNow.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.BetNow.Modelo.Apuesta;
import edu.escuelaing.BetNow.Persistence.DataBaseConnection;

@Service("BetNow")
public class BetNowService {

	@Autowired
    DataBaseConnection dbService;

	public String createUser(String nombre) {
		
		return null;
	}

	public List<Apuesta> findAll() {
		
		return null;
	}

	public List<Apuesta> findBetsById(String id) {
		
		return null;
	}
}
