package br.com.tecsegapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Estoque;
import br.com.tecsegapi.repository.EstoqueRepository;
import br.com.tecsegapi.repository.ProdutoRepository;

@CrossOrigin
@RestController
@RequestMapping("estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Estoque salvar(@Valid @RequestBody Estoque estoque) {
		estoque.setProduto(produtoRepository.save(estoque.getProduto()));
		return estoqueRepository.save(estoque);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Estoque> findEstoqueById(@PathVariable Integer id) {
		Optional<Estoque> estoque = estoqueRepository.findById(id);
		if (estoque==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estoque.get());
	}
	
	@GetMapping("/produto/id/{id}")
	public ResponseEntity<Estoque> findProdutoById(@PathVariable Integer id) {
		Optional<Estoque> estoque = estoqueRepository.findProdutoId(id);
		if (estoque==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estoque.get());
	}
	
	@GetMapping("listar/produto/descricao/{descricao}")
	public ResponseEntity<Optional<List<Estoque>>> listarProdutoDescricao(@PathVariable("descricao") String descricao) {
		if (descricao.equalsIgnoreCase("@")) {
			descricao = "";
		}
		Optional<List<Estoque>> lista = estoqueRepository.findProdutoDescricao(descricao);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/produto/grupo/{id}")
	public ResponseEntity<Optional<List<Estoque>>> listarProdutoGrupo(@PathVariable("id") int id) {
		Optional<List<Estoque>> lista = estoqueRepository.findProdutoGrupo(id);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	

}
