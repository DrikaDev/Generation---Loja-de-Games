package com.gamesgutiguti.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gamesgutiguti.model.Produto;
import com.gamesgutiguti.repository.ProdutoRepository;

import jakarta.validation.Valid;

//controlador da API Rest:
@RestController
//endereço inicial da controller:
@RequestMapping("/produtos")
//quais origens e quais cabeçalhos Http podem ter acesso a nossa API: 
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	//anotação responsável por fazer a injeção de dependência do Spring,
	//trazendo todos os metodos criados na Repository para cá:
	@Autowired
	private ProdutoRepository repository;
	
	//litarTodos - metodo de acesso para listar todos os produtos que teremos no banco de dados no futuro
	@GetMapping
	public ResponseEntity<List<Produto>> listarTodos () {
		return ResponseEntity.ok(repository.findAll());
	} 
	
	//getById - metodo vai retornar um objeto do banco de dados identificado pelo ID
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id) {
		return repository.findById(id).map(res -> ResponseEntity.ok(res))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nomes/{nome}")
	public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.
				findAllByNomeContainingIgnoreCase(nome));
	}
	
	//o metodo vai inserir todas as requisições do Http
	@PostMapping
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto Produto) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(Produto));
	}
	
	@PutMapping
	//o metodo vai atualizar todas as requisições do Http
	public ResponseEntity<Produto> put(@Valid @RequestBody Produto Produto) {
		return repository.findById(Produto.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.OK).
						body(repository.save(Produto)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
						.build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Produto> produto = repository.findById(id);

		if (produto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		repository.deleteById(id);
	}
}
