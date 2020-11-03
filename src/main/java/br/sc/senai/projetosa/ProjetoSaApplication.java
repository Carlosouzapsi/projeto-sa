package br.sc.senai.projetosa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProjetoSaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoSaApplication.class, args);
		
	}


}
