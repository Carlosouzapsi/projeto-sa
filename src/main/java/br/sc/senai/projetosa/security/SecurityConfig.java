

package br.sc.senai.projetosa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
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
	        auth.inMemoryAuthentication()
	        .passwordEncoder(passwordEncoder())
	        .withUser("user@email.com").password(passwordEncoder().encode("123456")).roles("USER")
	        .and()
	        .withUser("admin").password(passwordEncoder().encode("123456")).roles("USER", "ADMIN");
	    }
	 
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
}

