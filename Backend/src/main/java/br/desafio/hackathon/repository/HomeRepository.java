package br.desafio.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.desafio.hackathon.model.Home;

@Repository
public interface HomeRepository extends CrudRepository<Home, Long>{

		@Query("select h from Home h where h.nome like %?1%")
		public List<Home> buscarNome(String nome);
		
		@Query("select h from Home h where h.nome like %?1")
		public Home buscar(String nome);
		
	

	
}

