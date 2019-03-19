package br.desafio.hackathon.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.desafio.hackathon.model.Chinelo;


public interface ChineloRepository extends CrudRepository<Chinelo, Long> {
	
	//Query que permitirá excluir todos os chinelos associados a um determinado home
	 	@Modifying
	 	@Query(value="delete from chinelo where ho_nu = ?1",nativeQuery = true)
		public void  chineloDelete(long codigo);

}
