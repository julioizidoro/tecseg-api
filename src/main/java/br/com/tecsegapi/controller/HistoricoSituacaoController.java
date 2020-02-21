package br.com.tecsegapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Historicosituacao;
import br.com.tecsegapi.repository.HistoricoSituacaoRepository;

@CrossOrigin
@RestController
@RequestMapping("/historicosituacao")
public class HistoricoSituacaoController {
	
	@Autowired
	private HistoricoSituacaoRepository historicoSituacaoRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Historicosituacao salvar(@Valid @RequestBody Historicosituacao historico) {
		return historicoSituacaoRepository.save(historico);
	}
	
	@GetMapping("listar")
	public ResponseEntity<Optional<List<Historicosituacao>>> listar() {
		Optional<List<Historicosituacao>> lista = historicoSituacaoRepository.findAfastados();
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	
	
}
