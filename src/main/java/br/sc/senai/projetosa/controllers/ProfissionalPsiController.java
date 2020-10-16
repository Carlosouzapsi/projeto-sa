package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sc.senai.projetosa.model.entities.Consulta;
import br.sc.senai.projetosa.model.entities.Paciente;
import br.sc.senai.projetosa.model.entities.ProfissionalPsi;
import br.sc.senai.projetosa.services.ProfissionalPsiService;


@Controller
@RequestMapping("/profissionalPsi")
public class ProfissionalPsiController {
	
	@Autowired
	ProfissionalPsiService profissionalPsiService;
	
	@GetMapping("/cadastrar")
	public String ProfissionalPsi(ProfissionalPsi profissionalpsi) {
		return "cadastros/cadastroProfissionalPsi";
	}
	
	@GetMapping("/listarProfissionaisPsi")
	public String listarProfissionaisPsi(Model model) {
		try {
			
			model.addAttribute("profissionalPsi", profissionalPsiService.listarProfissionais());
			
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return "listas/listaDeProfissionais";
		
	}
	
	@PostMapping("/salvar")
	public String salvar(ProfissionalPsi profissionalPsi) {
		try {
			profissionalPsiService.salvar(profissionalPsi);
			
		}
		catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
			
		}
		return "redirect:/";
	}
	
	@GetMapping("/alterar/{idPro}")
	public String editar(ProfissionalPsi profissionalPsi, Model model) {
		try {
			profissionalPsi = profissionalPsiService.encontrarProfissionalPsi(profissionalPsi);
			model.addAttribute("profissionalPsi", profissionalPsi);
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return "cadastros/cadastroProfissionalPsi";
	}
	
	@GetMapping("/excluir/{idPro}")
	public String excluirPaciente(ProfissionalPsi profissionalPsi) {
		try {
			profissionalPsiService.excluir(profissionalPsi);
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return "redirect:/";
	}

}
