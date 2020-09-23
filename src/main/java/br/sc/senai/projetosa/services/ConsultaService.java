package br.sc.senai.projetosa.services;

import java.util.List;

import br.sc.senai.projetosa.model.entities.Consulta;

public interface ConsultaService {
	
	public List<Consulta> listarConsultas();
	
	public void salvar(Consulta consulta);
	
	public void excluir(Consulta consulta);
	
	public Consulta encontrarConsulta(Consulta consulta);
	
}
