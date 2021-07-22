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
		
		Evento event = eventRepo.findById(bet.getEvento())
				.orElseThrow(() -> new RuntimeException(String.format("No se pudo encontrar el evento con el id")));
		bet.setCuota(bet.getEquipo().equals(event.getEquipoA())?event.getCuotaA():event.getCuotaB()); 
		System.out.println(bet);
		betRepo.insert(bet);

		// Reduce el crédito
		Usuario user = userRepo.findById(bet.getUsuarioId())
				.orElseThrow(() -> new RuntimeException(String.format("No se pudo encontrar el usuario con el id")));
		user.setCredito(user.getCredito() - bet.getMonto());
		userRepo.save(user);

		// Actualizar cuotas
		
		if (bet.getEquipo().equals(event.getEquipoA()) && event.getCuotaA() > 1.1) {
			event.setCuotaA(event.getCuotaA() - 0.1);
			event.setCuotaB(event.getCuotaB() + 0.1);
		} else if (bet.getEquipo().equals(event.getEquipoB()) && event.getCuotaB() > 1.1) {
			event.setCuotaB(event.getCuotaB() - 0.1);
			event.setCuotaA(event.getCuotaA() + 0.1);
		}

		eventRepo.save(event);

	}

	public List<Apuesta> getAllBets() {
		return betRepo.findAll();
	}

	public List<Evento> getAllEvents() {

		return eventRepo.findAll();
	}

	public void endEvent(Evento event) {

		// Asigna el ganador del evento
		Evento actual = eventRepo.findById(event.getId()).orElseThrow(
				() -> new RuntimeException(String.format("No se pudo encontrar el evento con id %s", event.getId())));
		actual.setGanador(event.getGanador());
		eventRepo.save(actual);

		// Paga las apuestas del evento
		List<Apuesta> bets = betRepo.findAllByevento(event.getId());
		for (int i = 0; i < bets.size(); i++) {
			bets.get(i).setEstado("Cerrada");
			if (bets.get(i).getEquipo().equals(actual.getGanador())) {
				Usuario user = userRepo.findById(bets.get(i).getUsuarioId()).orElseThrow(
						() -> new RuntimeException(String.format("No se pudo encontrar el usuario con el id")));
				user.setCredito(user.getCredito() + (bets.get(i).getMonto() * bets.get(i).getCuota()));
				userRepo.save(user);
			}
		}
		betRepo.saveAll(bets);

	}

	public List<Apuesta> getAllBetsByUser(Usuario user) {
		return betRepo.findAllByusuarioId(user.getId()).orElseThrow(
				() -> new RuntimeException(String.format("No se pudo encontrar el usuario con id %s", user.getId())));
	}
	
	public Usuario login(Usuario usuario) {
		Usuario user = userRepo.findBycorreo(usuario.getCorreo());
		if(user.getPassword().equals(usuario.getPassword())&&user.getCorreo().equals(usuario.getCorreo())) {
			return user;
		}
		return null;
		
	}

	public Usuario getUserById(String id) {
		return userRepo.findById(id).orElseThrow(
				() -> new RuntimeException(String.format("No se pudo encontrar el usuario con el id")));
	}

}
