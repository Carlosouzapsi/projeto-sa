package br.sc.senai.projetosa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.sc.senai.projetosa.services.UsuarioService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioService service;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/bootstrap-4.5.2/js/**","/bootstrap-4.5.2/css/**","/css/**","fontawesome-5.14.0/css/**","fontawesome-5.14.0/js/**","fontawesome-5.14.0/less/**","fontawesome-5.14.0/metadata/**","fontawesome-5.14.0/scss/**","fontawesome-5.14.0/sprite/**","fontawesome-5.14.0/svgs/**","fontawesome-5.14.0/webfonts/**","/img/**","js/**").permitAll()
			.antMatchers("/","/home").permitAll()
			
			//Acessos privados admin:
			.antMatchers("/paciente/**").hasAuthority("ADMIN")
			
			//Acessos privados profissionais:
			.antMatchers("/ProfissionalPsi/***").hasAuthority("PROFISSIONAL")
			
			
			.anyRequest().authenticated()
			.and()
				 .formLogin()
				 .loginPage("/login")
				 .defaultSuccessUrl("/",true)
				 .failureUrl("/login-error")
				 .permitAll()
			.and()
				 .logout()
				 .logoutSuccessUrl("/logout");
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
}

