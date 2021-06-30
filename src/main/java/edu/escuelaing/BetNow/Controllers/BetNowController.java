package edu.escuelaing.BetNow.Controllers;

import java.util.logging.Logger;
import java.util.List;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.BetNow.Modelo.Apuesta;
import edu.escuelaing.BetNow.Services.BetNowService;

@RestController
public class BetNowController {

	@Autowired
    private BetNowService service;
	
	@GetMapping("/inicio")
	public String inicio() {
		return "Esto es BetNow";
	}
	
	@PostMapping(value = "/createUser/{nombre}")
    public ResponseEntity<String> createUser(@PathVariable() String nombre) {
		try {
            return new ResponseEntity<>(service.createUser(nombre), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(BetNowController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	@GetMapping(value = "/allBets")
    public ResponseEntity<List<Apuesta>> findAllRoulette() {
        try {
            return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(BetNowController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping(value = "/findBetsUser/{id}")
    public ResponseEntity<List<Apuesta>> findUserById(@PathVariable() String id) {
        try {
            return new ResponseEntity<>(service.findBetsById(id), HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(BetNowController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
