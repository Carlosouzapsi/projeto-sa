package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.sc.senai.projetosa.model.entities.Paciente;
import br.sc.senai.projetosa.repositories.PacienteRepository;

@Controller
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@RequestMapping(value= "/cadastroPaciente", method=RequestMethod.GET)
	public String form() {
		return "cadastros/cadastroPaciente";
	}
	
	@RequestMapping(value="/cadastroPaciente", method=RequestMethod.POST)
	public String form(Paciente paciente) {
		
		
		return "redirect:/cadastroPaciente";
		
	}
	
}
