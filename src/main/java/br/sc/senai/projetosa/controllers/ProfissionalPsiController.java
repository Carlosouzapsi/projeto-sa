package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.sc.senai.projetosa.repositories.ProfissionalPsiRepository;

@Controller
public class ProfissionalPsiController {
	
	@Autowired
	ProfissionalPsiRepository profissionalPsiRepository;
	
	@GetMapping("/profissional-psi")
	public String getProfissionalPsi(Model model) {
		
		return "profissional-psi";
		
	}

}
