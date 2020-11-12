

package br.sc.senai.projetosa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.sc.senai.projetosa.services.PacienteServiceImpl;
import br.sc.senai.projetosa.services.ProfissionalPsiImpl;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired 
	PacienteServiceImpl pacienteServiceImpl;
	
	@Autowired
	ProfissionalPsiImpl profissionalPsiImpl;
	/*
	private static final String ADMIN = PerfilTipo.ADMIN.getDesc();
    private static final String PSICOLOGO = PerfilTipo.PSICOLOGO.getDesc();
    private static final String PACIENTE = PerfilTipo.PACIENTE.getDesc();
	*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/bootstrap-4.5.2/js/**","/bootstrap-4.5.2/css/**","/css/**","fontawesome-5.14.0/css/**","fontawesome-5.14.0/js/**","fontawesome-5.14.0/less/**","fontawesome-5.14.0/metadata/**","fontawesome-5.14.0/scss/**","fontawesome-5.14.0/sprite/**","fontawesome-5.14.0/svgs/**","fontawesome-5.14.0/webfonts/**","/img/**","js/**").permitAll()
			.antMatchers("/","/home","/login").permitAll()
			.antMatchers("/profissionalOuPaciente", "/paciente/cadastrar", "/profissionalPsi/cadastrar").permitAll()
			.antMatchers("/profissionalPsi/salvar", "/paciente/salvar").permitAll()
		
			
			
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
		  System.out.println("USUARIO: " + pacienteServiceImpl);

		  auth
		  	.userDetailsService(profissionalPsiImpl)
		  	.passwordEncoder(new BCryptPasswordEncoder());
		  auth
		  	.userDetailsService(pacienteServiceImpl)
		  	.passwordEncoder(new BCryptPasswordEncoder());
	      
	    }
	 
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
}

