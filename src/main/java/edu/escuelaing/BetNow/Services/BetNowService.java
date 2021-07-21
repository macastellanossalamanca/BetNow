package edu.escuelaing.BetNow.Services;

import java.util.List;

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

	public List<Apuesta> getAllBets() {
		return betRepo.findAll();
	}

	public void endEvent(Evento event) {
		Evento actual = eventRepo.findById(event.getId()).orElseThrow(
				() -> new RuntimeException(String.format("No se pudo encontrar el evento con id %s", event.getId())));
		actual.setGanador(event.getGanador());
		eventRepo.save(actual);
	}

	public List<Apuesta> getAllBetsByEvent(Evento event) {
		
		return betRepo.findAllByevento().orElseThrow(
				() -> new RuntimeException(String.format("No se pudo encontrar el evento con id %s", event.getId())));
	}

	public List<Apuesta> getAllBetsByUser(Usuario user) {
		return betRepo.findAllByusuario().orElseThrow(
				() -> new RuntimeException(String.format("No se pudo encontrar el usuario con id %s", user.getId())));
	}

	
}
