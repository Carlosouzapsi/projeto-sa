package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sc.senai.projetosa.repositories.PacienteRepository;

@Controller
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@RequestMapping("/cadastroPaciente")
	public String form() {
		return "cadastros/cadastroPaciente";
	}
	
}
