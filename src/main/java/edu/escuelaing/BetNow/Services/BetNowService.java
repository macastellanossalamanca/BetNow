package edu.escuelaing.BetNow.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.BetNow.Modelo.Apuesta;
import edu.escuelaing.BetNow.Modelo.Evento;
import edu.escuelaing.BetNow.Modelo.Usuario;
import edu.escuelaing.BetNow.Persistence.BetRepository;
import edu.escuelaing.BetNow.Persistence.EventRepository;
import edu.escuelaing.BetNow.Persistence.UserRepository;


@Service("BetNow")
public class BetNowService {

	@Autowired
	UserRepository userRepo;
	@Autowired
	EventRepository eventRepo;
	@Autowired
	BetRepository betRepo;

	public void createUser(Usuario usuario) {
		userRepo.insert(usuario);
	}

	public void createEvent(Evento event) {
		eventRepo.insert(event);
	}
	
	public void addBet(Apuesta bet) {
		betRepo.insert(bet);
		
	}

	public Object getAllBets() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
