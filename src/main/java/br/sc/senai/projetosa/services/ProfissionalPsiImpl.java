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
	@Transactional(readOnly = true)
	public List<ProfissionalPsi> listarProfissionais() {
		return(List<ProfissionalPsi>) profissionalPsiRepository.findAll();
	}

	@Override
	@Transactional
	public void salvar(ProfissionalPsi profissionalPsi) {
		profissionalPsiRepository.save(profissionalPsi);
	}

	@Override
	@Transactional
	public void excluir(ProfissionalPsi profissionalPsi) {
		profissionalPsiRepository.delete(profissionalPsi);
	}

	@Override
	@Transactional(readOnly = true)
	public ProfissionalPsi encontrarProfissionalPsi(ProfissionalPsi profissionalPsi) {
		return profissionalPsiRepository.findById(profissionalPsi.getIdPro()).orElse(null);
	}
	
	
	
	

}
