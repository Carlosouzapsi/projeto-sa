package br.sc.senai.projetosa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.sc.senai.projetosa.model.entities.Paciente;
import br.sc.senai.projetosa.repositories.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService, UserDetailsService {
	
	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Paciente> listarPacientes() {
		return (List<Paciente>) pacienteRepository.findAll();
	}

	@Override
	@Transactional
	public void salvar(Paciente paciente) {
		pacienteRepository.save(paciente);
	}

	@Override
	@Transactional
	public void excluir(Paciente paciente) {
		pacienteRepository.delete(paciente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Paciente encontrarPaciente(Paciente paciente) {
		return pacienteRepository.findById(paciente.getIdPac()).orElse(null);
	}
	
	@Transactional(readOnly = true)
	public Paciente buscarPorEmail(String email) {
		
		System.out.println(pacienteRepository.findByEmailLike(email));
		return pacienteRepository.findByEmailLike(email);
		
	}

	@Override @Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Paciente paciente = buscarPorEmail(username);
		return new User(
				paciente.getEmail(),
				paciente.getSenha(),
				AuthorityUtils.createAuthorityList(paciente.getTipo().getDesc())
				);	
		
	}
	

	
}
