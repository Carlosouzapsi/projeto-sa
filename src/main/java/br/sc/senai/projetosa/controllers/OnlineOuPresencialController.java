package br.sc.senai.projetosa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OnlineOuPresencialController {
	
	@GetMapping("/escolhaModalidade")
	public String escolhaModalide() {
		return "consultas/escolhaModalidade";
	}

}
