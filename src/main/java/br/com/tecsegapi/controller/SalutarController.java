package br.com.tecsegapi.controller;

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

import br.com.tecsegapi.model.Funcionario;
import br.com.tecsegapi.model.Salutar;
import br.com.tecsegapi.repository.SalutarRepository;

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
	public ResponseEntity<List<Salutar>> listar() {
		List<Salutar> lista = salutarRepository.findAll();
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/{idloja}")
	public ResponseEntity<Optional<List<Salutar>>> listar(@PathVariable("idloja") int idloja) {
		Optional<List<Salutar>> lista = salutarRepository.findAllLoja(idloja);
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
