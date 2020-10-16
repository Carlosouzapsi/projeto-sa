package br.sc.senai.projetosa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.sc.senai.projetosa.model.entities.Paciente;
import br.sc.senai.projetosa.repositories.PacienteRepository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService {
	
	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	public UserDetails loadUserByUsername(String emailPac) throws UsernameNotFoundException {
		Paciente paciente = pacienteRepository.findByEmail(emailPac);
		
		if(paciente == null) {
			throw new UsernameNotFoundException("Paciente não encontrado!");
		}
		return new User(paciente.getUsername(), paciente.getPassword(), true, true, true, true, paciente.getAuthorities());
	}

}
