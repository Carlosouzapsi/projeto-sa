package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.sc.senai.projetosa.model.entities.Consulta;
import br.sc.senai.projetosa.services.ConsultaService;

@Controller
public class ConsultaController {
	
	@Autowired
	ConsultaService consultaService;
	
	@GetMapping("/escolhaModalidade")
	public String ModalidadeEscolha(Consulta consulta) {
		
		return "consultas/escolha-modalidade";
		
	}

}
