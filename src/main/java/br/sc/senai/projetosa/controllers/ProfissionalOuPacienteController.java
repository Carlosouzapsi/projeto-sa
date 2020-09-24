package br.sc.senai.projetosa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfissionalOuPacienteController {
	
	@GetMapping("/profissional-ou-paciente")
	public String ProfissionalOuPaciente() {
		
		return "cadastros/profissional-ou-paciente";
		
	}

}
