package br.sc.senai.projetosa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.sc.senai.projetosa.model.entities.Paciente;
import br.sc.senai.projetosa.repositories.PacienteRepository;

@SpringBootApplication
public class ProjetoSaApplication {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoSaApplication.class, args);
		
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Paciente paciente = new Paciente();
			paciente.setCpfPac("000");
			paciente.setNomePac("João");
			
			this.pacienteRepository.save(paciente);
		};
	}

	

}
