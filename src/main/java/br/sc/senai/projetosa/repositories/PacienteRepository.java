package br.sc.senai.projetosa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.senai.projetosa.model.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
			
}
