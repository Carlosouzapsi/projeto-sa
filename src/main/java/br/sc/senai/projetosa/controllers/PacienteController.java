package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.sc.senai.projetosa.repositories.PacienteRepository;

@Controller
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping("/pacientes")
	public String getFuncionarios(Model model) {
		
		model.addAttribute("pacientes", pacienteRepository.findAll());
		return "pacientes";
		
	}
	
}
