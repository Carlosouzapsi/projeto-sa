package br.sc.senai.projetosa.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.sc.senai.projetosa.model.entities.Paciente;
import br.sc.senai.projetosa.model.entities.ProfissionalPsi;
import br.sc.senai.projetosa.services.PacienteServiceImpl;
import br.sc.senai.projetosa.services.ProfissionalPsiImpl;

@Controller
public class LoginController {
	
	@Autowired
	private PacienteServiceImpl pacienteService;
	
	@Autowired 
	private ProfissionalPsiImpl profissionalPsiService;
		
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
		
		return "login/login";
	}
	
	//acesso negado
	@GetMapping({"/acesso-negado"})
	public String acessoNegado(ModelMap model, HttpServletResponse resp) {
		model.addAttribute("status",resp.getStatus());
		model.addAttribute("error","Acesso Negado");
		model.addAttribute("message", "Você não tem permissão para acesso a esta área ou ação");
		
		return "fragments/error";
		
	}
	
	

	
}
