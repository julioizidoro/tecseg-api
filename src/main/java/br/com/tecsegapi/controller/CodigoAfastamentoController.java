package br.com.tecsegapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Codigoafastamento;
import br.com.tecsegapi.repository.CodigoAfastamentoRepository;

@CrossOrigin
@RestController
@RequestMapping("/codafastamento")
public class CodigoAfastamentoController {
	
	@Autowired
	private CodigoAfastamentoRepository codigoAfastamentoRepository;
	
	@GetMapping
	public ResponseEntity<List<Codigoafastamento>> listar() {
		Sort sort = new Sort(Sort.Direction.ASC, "Descricao");
		List<Codigoafastamento> lista = codigoAfastamentoRepository.findAll(sort);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Codigoafastamento> getId(@PathVariable Integer id) {
		Optional<Codigoafastamento> codigo = codigoAfastamentoRepository.findById(id);
		if (codigo==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(codigo.get());
	}

}
