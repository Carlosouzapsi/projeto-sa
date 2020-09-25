package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.sc.senai.projetosa.model.entities.ProfissionalPsi;
import br.sc.senai.projetosa.services.ProfissionalPsiService;


@Controller
public class ProfissionalPsiController {
	
	@Autowired
	ProfissionalPsiService profissionalPsiService;
	
	@GetMapping("/cadastroProfissionalPsi")
	public String ProfissionalPsi(ProfissionalPsi profissionalpsi) {
		
		return "cadastros/cadastroProfissionalPsi";
		
	}

}
