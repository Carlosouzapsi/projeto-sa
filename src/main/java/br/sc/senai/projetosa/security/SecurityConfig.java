

package br.sc.senai.projetosa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.sc.senai.projetosa.model.enums.PerfilTipo;
import br.sc.senai.projetosa.services.PacienteServiceImpl;
import br.sc.senai.projetosa.services.ProfissionalPsiImpl;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	PacienteServiceImpl pacienteServiceImpl;

	@Autowired
	ProfissionalPsiImpl profissionalPsiServiceImpl;
	
	private static final String ADMIN = PerfilTipo.ADMIN.getDesc();
    private static final String PSICOLOGO = PerfilTipo.PSICOLOGO.getDesc();
    private static final String PACIENTE = PerfilTipo.PACIENTE.getDesc();


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/bootstrap-4.5.2/js/**","/bootstrap-4.5.2/css/**","/css/**","fontawesome-5.14.0/css/**","fontawesome-5.14.0/js/**","fontawesome-5.14.0/less/**","fontawesome-5.14.0/metadata/**","fontawesome-5.14.0/scss/**","fontawesome-5.14.0/sprite/**","fontawesome-5.14.0/svgs/**","fontawesome-5.14.0/webfonts/**","/img/**","js/**").permitAll()
		.antMatchers("/","/home","/login").permitAll()
		.antMatchers("/profissionalOuPaciente", "/paciente/cadastrar", "/profissionalPsi/cadastrar").permitAll()
		.antMatchers("/profissionalPsi/salvar", "/paciente/salvar").permitAll()
		
		//Acessos privados admin
		.antMatchers("/paciente/**", "profissionalPsi/**", "/consulta/**").hasAnyAuthority("ADMIN", "PROFISSIONAL", "PACIENTE")
		
		//Acesso privados paciente
		.antMatchers("/profissionalPsi/listarProfissionalPsi").hasAuthority("PACIENTE")
		
		//Acesso privados profissionalPsi
		.antMatchers("/consulta/cadastrar").hasAuthority("PROFISSIONAL")



		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/",true)
		.failureUrl("/login-error")
		.permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/logout")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/acesso-negado");



	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		  auth
			.userDetailsService(pacienteServiceImpl)
			.passwordEncoder(new BCryptPasswordEncoder());
		  auth
			.userDetailsService(profissionalPsiServiceImpl)
			.passwordEncoder(new BCryptPasswordEncoder());
		*/
		 /*  
		ProfissionalPsi profissional = profissionalPsiServiceImpl.buscarPorEmail(
				SecurityContextHolder.getContext().getAuthentication().getName());

		Paciente paciente = pacienteServiceImpl.buscarPorEmail(
				SecurityContextHolder.getContext().getAuthentication().getName());

		if (profissional != null)
			auth
			.userDetailsService(profissionalPsiServiceImpl)
			.passwordEncoder(new BCryptPasswordEncoder());
		else if (paciente != null)
			auth
			.userDetailsService(pacienteServiceImpl)
			.passwordEncoder(new BCryptPasswordEncoder());*/
		
		auth
			.authenticationProvider(profissionalPsiProvider())
			.authenticationProvider(pacienteProvider());
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider pacienteProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(pacienteServiceImpl);
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	@Bean
	public DaoAuthenticationProvider profissionalPsiProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(profissionalPsiServiceImpl);
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	
	}

