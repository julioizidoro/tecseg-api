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

import br.com.tecsegapi.model.Clinica;
import br.com.tecsegapi.repository.ClinicaRepository;

@CrossOrigin
@RestController
@RequestMapping("/clinicas")
public class ClinicaController {
	
	@Autowired
	private ClinicaRepository clinicaRepository;
	
	@GetMapping
	@Cacheable("consultaClinica")
	public ResponseEntity<List<Clinica>> listar() {
		Sort sort = new Sort(Sort.Direction.ASC, "Nome");
		List<Clinica> clinicas = clinicaRepository.findAll(sort);
		if (clinicas==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(clinicas);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Optional<Clinica>> consultar(@PathVariable("id") int id) {
		Optional<Clinica> clinica = clinicaRepository.findById(id);
		if (clinica==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(clinica);
	}
}
