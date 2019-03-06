package br.com.tecsegapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<List<Funcao>> listar() {
		Sort sort = new Sort(Sort.Direction.ASC, "Nome");
		List<Funcao> funcao = funcaoRepository.findAll(sort);
		if (funcao==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(funcao);
	}

}
