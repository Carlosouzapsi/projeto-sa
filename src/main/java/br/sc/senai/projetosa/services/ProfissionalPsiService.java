package br.sc.senai.projetosa.services;

import java.util.List;


import br.sc.senai.projetosa.model.entities.ProfissionalPsi;

public interface ProfissionalPsiService {
	
	public List<ProfissionalPsi> listarProfissionais();
	
	public void salvar(ProfissionalPsi profissionalPsi);
	
	public void excluir(ProfissionalPsi profissionalPsi);
	
	public ProfissionalPsi encontrarProfissionalPsi(ProfissionalPsi profissionalPsi);

}
