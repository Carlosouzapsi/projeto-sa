package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.sc.senai.projetosa.model.entities.Consulta;
import br.sc.senai.projetosa.services.ConsultaService;

@Controller //controller da consulta!
public class ConsultaController {
	
	@Autowired
	ConsultaService consultaService;
	
	@GetMapping("/escolhaModalidade")
	public String ModalidadeEscolha(Consulta consulta) {
		
		return "consultas/escolhaModalidade";
		
	}
	
	@GetMapping("escolhaModalidade/modalidadeOnline")
	public String ModalidadeOnline(Consulta consulta) {
		
		return "consultas/modalidadeOnlineLista";
		
	}
	
	@GetMapping("escolhaModalidade/modalidadePresencial")
	public String ModalidadePresencial(Consulta consulta) {
		
		return "consultas/modalidadePresencialLista";
		
	}

}
