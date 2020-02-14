package br.com.tecsegapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Produtogrupo;
import br.com.tecsegapi.repository.ProdutoGrupoRepository;

@CrossOrigin
@RestController
@RequestMapping("/produtogrupo")
public class ProdutoGrupoController {
	
	@Autowired
	private ProdutoGrupoRepository produtoGrupoRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Produtogrupo> buscar(@PathVariable Integer id) {
		Optional<Produtogrupo> produtoGrupo = produtoGrupoRepository.findById(id);
		
		if (produtoGrupo==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produtoGrupo.get());
	}
	
	@GetMapping("listar/{descricao}")
	public ResponseEntity<Optional<List<Produtogrupo>>> listar(@PathVariable("descricao") String descricao) {
		Optional<List<Produtogrupo>> lista = produtoGrupoRepository.findByDescricaoContainingOrderByDescricao(descricao);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar")
	public ResponseEntity<List<Produtogrupo>> listar() {
		List<Produtogrupo> lista = produtoGrupoRepository.findAll();
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

}
