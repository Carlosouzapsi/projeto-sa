package br.sc.senai.projetosa.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.sc.senai.projetosa.model.entities.Paciente;
import br.sc.senai.projetosa.model.enums.PerfilTipo;
import br.sc.senai.projetosa.services.PacienteService;
import br.sc.senai.projetosa.services.PacienteServiceImpl;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
			
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private PacienteServiceImpl paciente;
		
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
	public String salvar(@Valid Paciente paciente, BindingResult result, ModelMap model) {
		try {
			
			if(result.hasErrors()) {
				
				return "/cadastros/cadastroPaciente";
				
			}
			
			String crypt = new BCryptPasswordEncoder().encode(paciente.getSenha());
			paciente.setSenha(crypt);
			paciente.setTipo(PerfilTipo.PACIENTE);
			pacienteService.salvar(paciente);
			model.addAttribute("success", "Dados salvos com sucesso!");
		}
		catch(DataIntegrityViolationException ex) {
			System.out.println("Erro: " + ex.getMessage());
			model.addAttribute("fail", "Cadastro não realizado, email já existente!");
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
	
	@GetMapping("/alterarPerfil/")
	public String editarPerfil(Paciente paciente, Model model, @AuthenticationPrincipal User user) {
		try {
			
		    String email = securityContextHolder.getContext().getAuthentication().getName();
		    paciente.buscarPorEmail(email);
			model.addAttribute("paciente", paciente);
		
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return "cadastros/cadastroPaciente";
		
	}
	
	
	@GetMapping("/excluir/{idPac}")
	public String excluirPaciente(Paciente paciente, Model model) {
		try {
			pacienteService.excluir(paciente);
		}
		catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return listarPacientes(model);
	}
		
}
