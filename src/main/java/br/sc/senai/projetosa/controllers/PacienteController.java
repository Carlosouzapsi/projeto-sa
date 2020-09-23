package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.sc.senai.projetosa.model.entities.Paciente;
import br.sc.senai.projetosa.services.PacienteService;


@Controller
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping("/cadastroPaciente")
	public String cadastroPaciente(Paciente paciente) {
		return "cadastros/cadastroPaciente";
	}
	
	@GetMapping("/adicionar")
	public String adicionar(Paciente paciente) {	
		return "alterar";	
	}
	
	@PostMapping("/salvar")
	public String salvar(Paciente paciente) {
		pacienteService.salvar(paciente);
		return "redirect:/";
	}

}
