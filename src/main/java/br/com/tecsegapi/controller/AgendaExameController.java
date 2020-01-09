package br.com.tecsegapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Agendaexame;
import br.com.tecsegapi.model.Treinamentoparticipante;
import br.com.tecsegapi.repository.AgendaExameRepository;

@CrossOrigin
@RestController
@RequestMapping("/agendaexame")
public class AgendaExameController {
	
	@Autowired
	private AgendaExameRepository agendaExameRepository;
	
	@GetMapping("listar/{idasoagenda}")
	public ResponseEntity<Optional<List<Agendaexame>>> listar(@PathVariable("idasoagenda") int idasoagenda){
		Optional<List<Agendaexame>> lista = agendaExameRepository.findAllSAgendaExame(idasoagenda);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping("/salvarlista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Agendaexame> salvar(@Valid @RequestBody List<Agendaexame> lista) {
		List<Agendaexame> listaSalva = new ArrayList<Agendaexame>();
 		for (int i=0; i<lista.size();i++) {
			Agendaexame agendaExame = agendaExameRepository.save(lista.get(i));
			listaSalva.add(agendaExame);
		}
		return listaSalva;
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Agendaexame salvarAgendaExame(@Valid @RequestBody Agendaexame agendaExame) {
		agendaExame = agendaExameRepository.save(agendaExame);
		return agendaExame;
	}
}
