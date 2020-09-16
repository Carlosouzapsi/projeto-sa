package br.sc.senai.projetosa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senai.projetosa.model.entities.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
	
}
