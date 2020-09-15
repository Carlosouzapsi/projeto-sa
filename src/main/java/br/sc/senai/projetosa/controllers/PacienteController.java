package br.sc.senai.projetosa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senai.projetosa.repositories.PacienteRepository;

@RestController
@RequestMapping(path = "/api")
public class PacienteController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
}
