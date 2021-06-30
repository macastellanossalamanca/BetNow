package edu.escuelaing.BetNow.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BetNowController {

	@GetMapping("/inicio")
	public String inicio() {
		return "Esto es BetNow";
	}
}
