package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sc.senai.projetosa.model.entities.Paciente;
import br.sc.senai.projetosa.services.PacienteService;

//request mapping padroniza isso:

//http://localhost:8080/paciente/cadastrar
//http://localhost:8080/paciente/alterar
//http://localhost:8080/paciente/perfil

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
		
	@GetMapping("/cadastrar")
	public String adicionar(Paciente paciente, Model model) {	
		return "cadastros/cadastroPaciente";	
	}
	
	@GetMapping("/listarPacientes")
	public String listarPacientes(Model model) {
		try {
			model.addAttribute("paciente", pacienteService.listarPacientes());
			
		}
		catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
		return "listas/listaDePacientes";
		
	}
	
	@PostMapping("/salvar")
	public String salvar(Paciente paciente) {
		try {
			pacienteService.salvar(paciente);	
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return "cadastros/cadastroPaciente";
	}
	
	
	@GetMapping("/alterar/{idPac}")
	public String editar(Paciente paciente, Model model) {
		try {
			paciente = pacienteService.encontrarPaciente(paciente);
			model.addAttribute("paciente", paciente);
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return "cadastros/cadastroPaciente";
	}
	
	

}
