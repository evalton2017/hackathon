package br.desafio.hackathon.test;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.desafio.hackathon.model.Home;
import br.desafio.hackathon.repository.HomeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:META-INF/spring-context.xml"})
public class HomeTest {
	
	@Autowired
	private HomeRepository homeRepository;
	
	/*Teste para salvar um home*/
	@Test
	public void inserirHome() {
		Home home = new Home();
		
		home.setId(2L);
		home.setNome("Bart");
		home.setLimite(2);
		homeRepository.save(home);
		
	}
	
	@Test 
	public void consultaHome() {
		Optional<Home> home = homeRepository.findById(1L);
		
		System.out.println(home.get().getNome());
		System.out.println(home.get().getId());
		
	}

	@Test 
	public void listar() {
		List<Home> lista = (List<Home>) homeRepository.findAll();
		
		for(Home h:lista) {
			System.out.println(h.getNome());
			System.out.println(h.getLimite());
			System.out.println(h.getId());
		}
		
	}
}