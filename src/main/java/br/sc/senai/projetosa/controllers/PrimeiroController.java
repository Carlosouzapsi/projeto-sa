package br.sc.senai.projetosa.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	@RequestMapping(path = { "/ola", "/saudacao" })
	public String ola() {
		return "Ola Spring Boot!";
	}

}
