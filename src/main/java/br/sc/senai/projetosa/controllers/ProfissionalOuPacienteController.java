package br.sc.senai.projetosa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfissionalOuPacienteController {
	
	@GetMapping("/profissionalOuPaciente")
	public String ProfissionalOuPaciente() {
		
		return "cadastros/profissionalOuPaciente";
		
	}

}
