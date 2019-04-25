package br.com.tecsegapi.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Treinamento;
import br.com.tecsegapi.repository.TreinamentoRepository;
import br.com.tecsegapi.util.Conversor;

@CrossOrigin
@RestController
@RequestMapping("/treinamentos")
public class TreinamentoController {
	
	@Autowired
	private TreinamentoRepository treinamentoRepository;
	
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	@CachePut("consultaTreinamento")
	public Treinamento salvar(@Valid @RequestBody Treinamento treinamento) {
		return treinamentoRepository.save(treinamento);
	}
	
	@GetMapping
	@Cacheable("consultaTreinamento")
	public ResponseEntity<Optional<List<Treinamento>>> findAll() {
		Conversor c = new Conversor();
		Date dataConsulta = c.SomarDiasData(new Date(), -15);
		Optional<List<Treinamento>> treinamentos = treinamentoRepository.findAllPadrao(dataConsulta);
		if (treinamentos==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(treinamentos);
	}
}