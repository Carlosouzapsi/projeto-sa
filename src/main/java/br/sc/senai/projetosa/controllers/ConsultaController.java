package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sc.senai.projetosa.model.entities.Consulta;
import br.sc.senai.projetosa.services.ConsultaService;
import br.sc.senai.projetosa.services.PacienteService;

@Controller 
@RequestMapping("/consulta")
public class ConsultaController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private ConsultaService consultaService;
	
	@GetMapping("/cadastrar")
	public String adicionar(Consulta consulta, Model model) {
		model.addAttribute("paciente", pacienteService.listarPacientes());
		return "cadastros/cadastroConsulta";
		
	}
	
	@PostMapping("/salvar")
	public String salvar(Consulta consulta) {
		try {
			consultaService.salvar(consulta);
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return "cadastros/cadastroConsulta";
	}
	
	@GetMapping("/alterar/{idConsulta}")
	public String editar(Consulta consulta, Model model) {
		try {
			consulta = consultaService.encontrarConsulta(consulta);
			model.addAttribute("consulta", consulta);
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return "cadastros/cadastroConsulta";
	}
	
}
