package br.sc.senai.projetosa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.sc.senai.projetosa.model.entities.ProfissionalPsi;
import br.sc.senai.projetosa.repositories.ProfissionalPsiRepository;

@Service
public class ProfissionalPsiImpl implements ProfissionalPsiService, UserDetailsService {
	
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
	public void excluir(ProfissionalPsi profissionalPsi) {
		profissionalPsiRepository.delete(profissionalPsi);
	}

	@Override
	@Transactional(readOnly = true)
	public ProfissionalPsi encontrarProfissionalPsi(ProfissionalPsi profissionalPsi) {
		return profissionalPsiRepository.findById(profissionalPsi.getIdPro()).orElse(null);
	}
	
	@Transactional(readOnly = true)
	public ProfissionalPsi buscarPorEmail(String email) {
		
		return profissionalPsiRepository.findByEmail(email);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ProfissionalPsi profissionalPsi = buscarPorEmail(username);
		
		if(profissionalPsi == null) throw new UsernameNotFoundException("profissional não encontrado");
			
			return new User(
					profissionalPsi.getEmail(),
					profissionalPsi.getSenha(),
					AuthorityUtils.createAuthorityList(profissionalPsi.getTipo().getDesc())
					);
	
	}

}
