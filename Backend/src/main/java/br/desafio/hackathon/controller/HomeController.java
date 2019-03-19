package br.desafio.hackathon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.desafio.hackathon.exception.DesafioException;
import br.desafio.hackathon.model.Chinelo;
import br.desafio.hackathon.model.Home;
import br.desafio.hackathon.service.HomeService;

@CrossOrigin
@Controller
@RequestMapping(value = "/homer")
public class HomeController {

	@Autowired
	private HomeService service;

	// Lista todos os homers, bem como seus chinelos
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Home> findAll() throws DesafioException {
		return service.listar();

	}

	// Metodo para salvar um home
	@RequestMapping(method = RequestMethod.POST, value = "/salvar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Home salvar(@RequestBody Home home) throws Exception {
		return service.salvar(home);

	}

	// Metodo para salvar o chinelo e atualizar o home
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, value = "/salvar/chinelo/{id}")
	public @ResponseBody Home salvarChinelo(@RequestBody Chinelo chinelo, @PathVariable Long id) throws Exception {
		Home home = service.buscar(id);
		chinelo.setHome(home);
		service.salvarChinelo(home, chinelo);

		return home;
	}

	// Metodo para atualizar o home
	@RequestMapping(method = { RequestMethod.POST,
			RequestMethod.PUT }, value = "/atualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Home atualizar(@RequestBody Home home) throws Exception {
		return service.atualizar(home);
	}

	// listar um ou mais cliente
	@GetMapping(value = "/pesquisar/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Home> buscarNome(@PathVariable("nome") String nome) throws DesafioException {
		System.out.println(nome);
		return service.pesquisar(nome);

	}

	// metodo para realizar a edição do Homer
	@RequestMapping(value = "editar/{codigo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Home buscarCliente(@PathVariable("codigo") String codigo) throws Exception {
		System.out.println(codigo);
		return service.buscar(Long.parseLong(codigo));
	}

	// metodo para realizar a exclusão do home e seus chinelos

	// metodo para deletar o home
	@RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deletar(@PathVariable("id") String id) throws Exception {
		Home home = service.buscar(Long.parseLong(id));
		service.delete(home);
		return "Home deletado com sucesso";
	}


}
