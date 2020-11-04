package br.sc.senai.projetosa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.sc.senai.projetosa.model.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
	
	
	//@Query("select u from Paciente u where u.email like :email")
	Paciente findByEmailLike(@Param("email") String email);
	
			
}
