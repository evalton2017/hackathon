package br.desafio.hackathon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.desafio.hackathon.exception.DesafioException;
import br.desafio.hackathon.model.Chinelo;
import br.desafio.hackathon.model.Home;
import br.desafio.hackathon.repository.ChineloRepository;
import br.desafio.hackathon.repository.HomeRepository;
import sun.invoke.empty.Empty;


@Service
public class HomeService {
	
	@Autowired
	private HomeRepository repository;
	
	@Autowired
	private ChineloRepository repositorych;
	
	//Lista os homers e seus chinelos
	public List<Home> listar() throws DesafioException{
		return (List<Home>) repository.findAll();
	}
	
	//metodo que irá salvar o home, ao salvar irá atribuir 0 para a quantidade de chinelo
	public Home salvar( Home home) throws Exception{
		String nome = home.getNome();
		if(repository.buscar(nome)!=null) {
			throw  new Exception("Usuario ja cadastrado");
		}else {
			home.setLimite(0);
			return repository.save(home);
		}
		
		//return repository.save(home);
	}
	public Home atualizar( Home home) throws Exception{
		return repository.save(home);

	}
	
	//metodo que irá salvar o chinelo, aqui será setado o valor +1 para a quantidade de chinelo o qual deverá ter no maximo 5
	public Home salvarChinelo(Home home, Chinelo chinelo) throws Exception {
		
		if(home.getLimite()>=0 && home.getLimite()<5) {
			home.setLimite(home.getLimite()+1);
			repository.save(home);
			repositorych.save(chinelo);
			return home;
		}else {
			throw  new Exception("Usuario ja possui 5 chinelos cadastrador");
		}
	}
	
	
	//pesquisar por nome
	public List<Home> pesquisar(String nome) throws DesafioException{
		return repository.buscarNome(nome);
			
	}
	
	//metodo para realizar a edição do Homer
	public Home buscar(Long id) throws DesafioException{
		return repository.findById(id).get();
		
	}

	
	//metodo para realizar a exclusão do home e seus chinelos
	
	public void primeiraMaiuscula(String nome) {
		nome = nome.substring(0,1).toUpperCase().concat(nome.substring(1));
	}
	
	//deletar um homer e seus filhos
	
	public void delete(Home home) throws DesafioException{
		//System.out.println(id);
		//repositorych.chineloDelete(id);
		repository.delete(home);;

	}
	
	public Optional<Chinelo> buscarChinelo(Long id) {
		return repositorych.findById(id);
	}
	
	
	
		
	
	
	
}

