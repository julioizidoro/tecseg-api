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

import br.com.tecsegapi.model.Relatoriosegurancaitens;
import br.com.tecsegapi.repository.RelatorioSegurancaItensRepository;

@CrossOrigin
@RestController
@RequestMapping("/rsitens")
public class RelatorioSegurancaItensController {

	@Autowired
	private RelatorioSegurancaItensRepository relatorioSegurancaItensRepository;
	

	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Relatoriosegurancaitens salvar(@Valid @RequestBody Relatoriosegurancaitens rsitens) {
		return relatorioSegurancaItensRepository.save(rsitens);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Relatoriosegurancaitens> buscar(@PathVariable Integer id) {
		Optional<Relatoriosegurancaitens> rsitens = relatorioSegurancaItensRepository.findById(id);
		
		if (rsitens==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(rsitens.get());
	}
	
	@GetMapping("listar/{id}")
	public ResponseEntity<Optional<List<Relatoriosegurancaitens>>> listar(@PathVariable Integer id) {
		Optional<List<Relatoriosegurancaitens>> lista = relatorioSegurancaItensRepository.findAllRelatoriosItens(id);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
}
