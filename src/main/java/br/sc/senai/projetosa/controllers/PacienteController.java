package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sc.senai.projetosa.model.entities.Paciente;
import br.sc.senai.projetosa.model.enums.PerfilTipo;
import br.sc.senai.projetosa.services.PacienteService;
import br.sc.senai.projetosa.services.PacienteServiceImpl;

//request mapping padroniza isso:

//http://localhost:8080/paciente/cadastrar
//http://localhost:8080/paciente/alterar
//http://localhost:8080/paciente/perfil

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteServiceImpl service;
		
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
	public String salvar(Paciente paciente, ModelMap model) {
		try {
			String crypt = new BCryptPasswordEncoder().encode(paciente.getSenha());
			paciente.setSenha(crypt);
			paciente.setTipo(PerfilTipo.ADMIN);
			pacienteService.salvar(paciente);
			model.addAttribute("success", "Dados salvos com sucesso!");
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
			model.addAttribute("fail", "Algo deu errado, tente novamente!");
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
	
	@GetMapping("/excluir/{idPac}")
	public String excluirPaciente(Paciente paciente) {
		try {
			pacienteService.excluir(paciente);
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return "redirect:/";
	}
	
	//Verificar se é possível excluir esse componente do controller.
	/*
	@PostMapping("/logar")
	public String Logar(Paciente paciente, ModelMap model, @AuthenticationPrincipal User user) {
		try {
			paciente = service.buscarPorEmail(user.getUsername());
			if(paciente != null) {
				model.addAttribute("paciente", paciente);
				
			}
			
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return "redirect:/";
	}
*/
	
}
