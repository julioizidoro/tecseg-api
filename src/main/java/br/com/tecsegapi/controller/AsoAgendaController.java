package br.com.tecsegapi.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Asoagenda;
import br.com.tecsegapi.repository.AsoAgendaRepository;

@CrossOrigin
@RestController
@RequestMapping("/asoagenda")
public class AsoAgendaController {
	
	@Autowired
	private AsoAgendaRepository asoAgendaRepository;
	
	@GetMapping
	@Cacheable("consultaAsoAgenda")
	public ResponseEntity<Optional<List<Asoagenda>>> listar() {
		Optional<List<Asoagenda>> agendas = asoAgendaRepository.findAllAsoAgenda();
		if (agendas==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(agendas);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Optional<Asoagenda>> consultar(@PathVariable("id") int id) {
		Optional<Asoagenda> agenda = asoAgendaRepository.findById(id);
		if (agenda==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(agenda);
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	@CachePut("consultaAsoAgenda")
	public Asoagenda salvar(@Valid @RequestBody Asoagenda asoAgenda) {
		return asoAgendaRepository.save(asoAgenda);
	}
	
	

}
