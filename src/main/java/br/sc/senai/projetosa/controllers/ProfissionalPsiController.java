package br.sc.senai.projetosa.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sc.senai.projetosa.model.entities.ProfissionalPsi;
import br.sc.senai.projetosa.model.enums.PerfilTipo;
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
	public String listarProfissionaisPsi(ModelMap model) {
		try {
			
			model.addAttribute("profissionalPsi", profissionalPsiService.listarProfissionais());
			
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return "listas/listaDeProfissionais";
		
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid ProfissionalPsi profissionalPsi, BindingResult result, ModelMap model) {
		try {
			
			if(result.hasErrors()) {
				
				return "/cadastros/cadastroProfissionalPsi";
				
			}
			String crypt = new BCryptPasswordEncoder().encode(profissionalPsi.getSenha());
			profissionalPsi.setSenha(crypt);
			profissionalPsi.setTipo(PerfilTipo.PSICOLOGO);
			profissionalPsiService.salvar(profissionalPsi);
			model.addAttribute("success", "Dados salvos com sucesso!");
			
		}
		catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
			model.addAttribute("fail", "Algo deu errado, tente novamente!");
			
		}
		return "cadastros/cadastroProfissionalPsi";
	}
	
	@GetMapping("/alterar/{idPro}")
	public String editar(@PathVariable("idPro") Long idPro, ProfissionalPsi profissionalPsi, Model model) {
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
	public String excluirProfissionalPsi(@PathVariable("idPro") Long idPro, ProfissionalPsi profissionalPsi, ModelMap model) {
		try {
			profissionalPsiService.excluir(profissionalPsi);
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return listarProfissionaisPsi(model);
	}

}
