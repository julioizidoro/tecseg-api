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

import br.com.tecsegapi.model.Clinicapagto;
import br.com.tecsegapi.repository.ClinicaPagtoRepository;

@CrossOrigin
@RestController
@RequestMapping("/acessos")
public class ClinicaPagtoController {
	
	@Autowired
	private ClinicaPagtoRepository clinicaPagtoRepository;
	
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Clinicapagto salvar(@Valid @RequestBody Clinicapagto clinicaPagto) {
		return clinicaPagtoRepository.save(clinicaPagto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clinicapagto> buscar(@PathVariable Integer id) {
		Optional<Clinicapagto> clinicaPagto = clinicaPagtoRepository.findById(id);
		if (clinicaPagto==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(clinicaPagto.get());
	}
	
	@GetMapping("listar")
	public ResponseEntity<List<Clinicapagto>> listar() {
		List<Clinicapagto> lista = clinicaPagtoRepository.findAll();
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	
	

}
