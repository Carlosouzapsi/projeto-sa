package br.sc.senai.projetosa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.sc.senai.projetosa.model.entities.Consulta;
import br.sc.senai.projetosa.repositories.ConsultaRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService {
	
	@Autowired
	private ConsultaRepository consultaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Consulta> listarConsultas() {
		return (List<Consulta>) consultaRepository.findAll();
		
	}

	@Override
	@Transactional
	public void salvar(Consulta consulta) {
		consultaRepository.save(consulta);
		
	}

	@Override
	public void excluir(Consulta consulta) {
		consultaRepository.delete(consulta);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Consulta encontrarConsulta(Consulta consulta) {
		return consultaRepository.findById(consulta.getIdConsulta()).orElse(null);
	}

}
