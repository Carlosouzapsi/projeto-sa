package br.sc.senai.projetosa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.sc.senai.projetosa.model.entities.ProfissionalPsi;
import br.sc.senai.projetosa.repositories.ProfissionalPsiRepository;

@Service
public class ProfissionalPsiImpl implements ProfissionalPsiService {
	
	@Autowired
	private ProfissionalPsiRepository profissionalPsiRepository;

	@Override
	public List<ProfissionalPsi> listarProfissionais() {
		return(List<ProfissionalPsi>) profissionalPsiRepository.findAll();
	}

	@Override
	public void salvar(ProfissionalPsi profissionalPsi) {
		profissionalPsiRepository.save(profissionalPsi);
	}

	@Override
	public void excluir(ProfissionalPsi profissionalPsi) {
		profissionalPsiRepository.delete(profissionalPsi);
	}

	@Override
	public ProfissionalPsi encontrarProfissionalPsi(ProfissionalPsi profissionalPsi) {
		return profissionalPsiRepository.findById(profissionalPsi.getIdPro()).orElse(null);
	}
	
	
	
	

}
