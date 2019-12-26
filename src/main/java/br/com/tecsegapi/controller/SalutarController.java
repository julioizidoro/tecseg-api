package br.com.tecsegapi.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
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

import br.com.tecsegapi.model.Salutar;
import br.com.tecsegapi.repository.SalutarRepository;
import br.com.tecsegapi.util.Conversor;

@CrossOrigin
@RestController
@RequestMapping("/salutar")
public class SalutarController {
	
	@Autowired
	private SalutarRepository salutarRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Salutar> buscar(@PathVariable Integer id) {
		Optional<Salutar> salutar = salutarRepository.findById(id);
		if (salutar==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(salutar.get());
	}
	
	
	@GetMapping("listar")
	public ResponseEntity<Optional<List<Salutar>>> listar() {
		Conversor c = new Conversor();
		Date datainicial = c.SomarDiasData(new Date(), -180);
		Optional<List<Salutar>> lista = salutarRepository.listar(datainicial, new Date());
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/{idloja}/{datainicial}/datafinal")
	public ResponseEntity<Optional<List<Salutar>>> listar(@PathVariable("idloja") int idloja, 
			@PathVariable("datainicial") Date datainicial, @PathVariable("datafinal") Date datafinal) {
		if (datainicial==null) {
			Conversor c = new Conversor();
			datainicial = c.SomarDiasData(new Date(), -180);
		}
		if (datafinal == null) {
			datafinal = new Date();
		}
		Optional<List<Salutar>> lista = salutarRepository.findAllLoja(idloja, datainicial, new Date());
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	@CachePut("consultaSalutar")
	public Salutar salvar(@Valid @RequestBody Salutar salutar) {
		return salutarRepository.save(salutar);
	}

}
