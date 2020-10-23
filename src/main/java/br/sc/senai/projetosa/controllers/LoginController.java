package br.sc.senai.projetosa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	// Abrir página de login
	@GetMapping({"/login"})
	public String login() {
		
		return "login/login";
	}
	
	//Login inválido
	@GetMapping({"/login-error"})
	public String loginError(ModelMap model) {
		model.addAttribute("alerta","erro");
		model.addAttribute("texto","Login ou senha incorretos, tente novamente!");
		return "login/login";
	}
	
	@GetMapping({"/logout"})
	public String logout() {
		
		return "index";
	}
	

}
