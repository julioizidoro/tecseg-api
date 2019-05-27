package br.com.tecsegapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Loja;
import br.com.tecsegapi.repository.LojaRepository;

@CrossOrigin
@RestController
@RequestMapping("/lojas")
public class LojaController {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@GetMapping("/{nome}")
	public ResponseEntity<Optional<List<Loja>>> listar(@PathVariable("nome") String nome) {
		Optional<List<Loja>> lojas = lojaRepository.findByNomeContainingOrderByNome(nome);
		if (lojas==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lojas);
	}
	
	@GetMapping
	@Cacheable("consultaLoja")
	public ResponseEntity<List<Loja>> listar() {
		Sort sort = new Sort(Sort.Direction.ASC, "Nome");
		List<Loja> lojas = lojaRepository.findAll(sort);
		if (lojas==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lojas);
	}

}
