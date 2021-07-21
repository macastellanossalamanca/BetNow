package edu.escuelaing.BetNow.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.BetNow.Modelo.Apuesta;
import edu.escuelaing.BetNow.Modelo.Evento;
import edu.escuelaing.BetNow.Modelo.Usuario;
import edu.escuelaing.BetNow.Services.BetNowService;

@RestController
@RequestMapping("/api")
public class BetNowController {

    @Autowired
    private BetNowService service;

    @GetMapping("/inicio")
    public String inicio() {
        return "Esto es BetNow";
    }
    
    @PostMapping("createUser")
    public ResponseEntity<?> createUser(@RequestBody Usuario user) {
    	service.createUser(user);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PostMapping("createEvent")
    public ResponseEntity<?> createEvent(@RequestBody Evento event) {
    	service.createEvent(event);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PostMapping("makeBet")
    public ResponseEntity<?> makeBet(@RequestBody Apuesta bet) {
    	service.addBet(bet);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("allBets")
    public ResponseEntity<List> getAllBets() {
    	return ResponseEntity.ok(service.getAllBets());
    }
    
    @GetMapping("allBetsByEvent")
    public ResponseEntity<List> getAllBetsByEvent(@RequestBody Evento event) {
    	return ResponseEntity.ok(service.getAllBetsByEvent(event));
    }
    
    @GetMapping("allBetsByUser")
    public ResponseEntity<List> getAllBetsByUser(@RequestBody Usuario user) {
    	return ResponseEntity.ok(service.getAllBetsByUser(user));
    }
    
    @PutMapping("endEvent")
    public ResponseEntity<?> finalizarEvento(@RequestBody Evento event) {
    	service.endEvent(event);
    	return ResponseEntity.ok().build();
    }
    
    

//    @PostMapping(value = "/createUser")
//    public ResponseEntity<String> createUser(@RequestBody Usuario user) {
//        try {
//            return new ResponseEntity<>(service.createUser (user), HttpStatus.ACCEPTED);
//        } catch (Exception e) {
//            Logger.getLogger(BetNowController.class.getName()).log(Level.SEVERE, null, e);
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

//    @GetMapping(value = "/allBets")
//    public ResponseEntity<List<Apuesta>> findAllBets() {
//        try {
//            return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
//        } catch (Exception e) {
//            Logger.getLogger(BetNowController.class.getName()).log(Level.SEVERE, null, e);
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping(value = "/findBetsUser/{id}")
//    public ResponseEntity<List<Apuesta>> findUserById(@PathVariable() String id) {
//        try {
//            return new ResponseEntity<>(service.findBetsById(id), HttpStatus.OK);
//        } catch (Exception e) {
//            Logger.getLogger(BetNowController.class.getName()).log(Level.SEVERE, null, e);
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
