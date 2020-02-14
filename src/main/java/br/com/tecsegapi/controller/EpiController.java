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

import br.com.tecsegapi.model.Epi;
import br.com.tecsegapi.repository.EpiRepository;
import br.com.tecsegapi.repository.ProdutoRepository;

@CrossOrigin
@RestController
@RequestMapping("/epis")
public class EpiController {
	
	@Autowired
	private EpiRepository epiRepository;
		
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Epi salvar(@Valid @RequestBody Epi estoque) {
		return epiRepository.save(estoque);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Epi> findEpiById(@PathVariable Integer id) {
		Optional<Epi> epi = epiRepository.findById(id);
		if (epi==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(epi.get());
	}
	
	@GetMapping("/produto/id/{id}")
	public ResponseEntity<Epi> findProdutoById(@PathVariable Integer id) {
		Optional<Epi> estoque = epiRepository.findProdutoId(id);
		if (estoque==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estoque.get());
	}
	
	@GetMapping("listar/produto/descricao/{descricao}")
	public ResponseEntity<Optional<List<Epi>>> listarProdutoDescricao(@PathVariable("descricao") String descricao) {
		if (descricao.equalsIgnoreCase("@")) {
			descricao = "";
		}
		Optional<List<Epi>> lista = epiRepository.findEpiDescricao(descricao);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
}
