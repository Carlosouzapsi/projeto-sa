package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sc.senai.projetosa.services.ConsultaService;

@Controller
@RequestMapping("/minhasConsultas")
public class MinhasConsultasListasController {
	
	@Autowired
	private ConsultaService consultaService;
	
	/* Lista consultas do paciente pelo ID dele */
	@GetMapping("/paciente/{idPac}")
	public String listarMinhasConsultasPaciente(Model model) {
		try {
			model.addAttribute("consulta", consultaService.listarConsultas());
			
		}
		catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
			
		}
		return "consultas/minhasConsultasListaPaciente";
	}
	
	/* Lista consultas do profissional pelo ID dele */
	@GetMapping("/paciente/{idPro}")
	public String listarMinhasConsultasProfissional(Model model) {
		try {
			model.addAttribute("consulta", consultaService.listarConsultas());
			
		}
		catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
			
		}
		return "consultas/minhasConsultasListaPaciente";
	}
	
}
