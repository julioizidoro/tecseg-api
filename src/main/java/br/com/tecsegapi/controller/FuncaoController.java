package br.com.tecsegapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Funcao;
import br.com.tecsegapi.repository.FuncaoRepository;

@CrossOrigin
@RestController
@RequestMapping("/funcao")
public class FuncaoController {
	
	@Autowired
	private FuncaoRepository funcaoRepository;
	
	@GetMapping
	@Cacheable("consultaFuncao")
	public ResponseEntity<List<Funcao>> listar() {
		Sort sort = new Sort(Sort.Direction.ASC, "Nome");
		List<Funcao> funcao = funcaoRepository.findAll(sort);
		if (funcao==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(funcao);
	}
	
	
	@GetMapping("/nome/{nome")
	public ResponseEntity<List<Funcao>> getNome() {
		Sort sort = new Sort(Sort.Direction.ASC, "Nome");
		List<Funcao> funcao = funcaoRepository.findAll(sort);
		if (funcao==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(funcao);
	}
	
	
	@GetMapping("/cbo/{cbo")
	public ResponseEntity<List<Funcao>> getCBO() {
		Sort sort = new Sort(Sort.Direction.ASC, "Nome");
		List<Funcao> funcao = funcaoRepository.findAll(sort);
		if (funcao==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(funcao);
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	@CachePut(value="consultaFuncao", key="#funcao.idfuncao")
	public Funcao salvar(@Valid @RequestBody Funcao funcao) {
		return funcaoRepository.save(funcao);
	}
	
	

}
