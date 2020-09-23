package br.sc.senai.projetosa.services;

import java.util.List;

import br.sc.senai.projetosa.model.entities.Paciente;

public interface PacienteService {
	
	public List<Paciente> listarPacientes();
	
	public void salvar(Paciente paciente);
	
	public void excluir(Paciente paciente);
	
	public Paciente encontrarPaciente(Paciente paciente);

}
