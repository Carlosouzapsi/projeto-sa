package br.sc.senai.projetosa.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.sc.senai.projetosa.model.entities.Produto;

public interface ProdutoRepository 
	extends CrudRepository<Produto, Integer> {
	
}
