package br.com.tecsegapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
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

import br.com.tecsegapi.model.Produto;
import br.com.tecsegapi.repository.ProdutoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("descricao/{descricao}")
	public ResponseEntity<Optional<List<Produto>>> pesquisar(@PathVariable("descricao") String descricao) {
		Optional<List<Produto>> lista = produtoRepository.findByDescricaoContainingOrderByDescricao(descricao);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Optional<Produto>> pesquisar(@PathVariable("id") int id) {
		Optional<Produto> lista = produtoRepository.findById(id);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping
	@Cacheable("consultaProdutos")
	public ResponseEntity<List<Produto>> listar() {
		Sort sort = new Sort(Sort.Direction.ASC, "Descricao");
		List<Produto> lista = produtoRepository.findAll(sort);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping("/salvar")
	@CachePut("consultaProdutos")
	@ResponseStatus(HttpStatus.CREATED)
	public Produto salvar(@Valid @RequestBody Produto Produto) {
		return produtoRepository.save(Produto);
	}


}

