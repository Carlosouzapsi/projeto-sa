package br.sc.senai.projetosa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.sc.senai.projetosa.model.entities.ProfissionalPsi;


public interface ProfissionalPsiRepository extends JpaRepository<ProfissionalPsi, Integer> {
	
	@Query("select u from Paciente u where u.email like :email")
	ProfissionalPsi findByEmail(@Param("email") String email);

}
