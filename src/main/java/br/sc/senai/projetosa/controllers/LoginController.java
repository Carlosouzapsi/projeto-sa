package br.sc.senai.projetosa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login/usuario")
	public String login() {
		
		return "login/login";
	}

}
