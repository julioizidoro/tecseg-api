package br.com.tecsegapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Setor;
import br.com.tecsegapi.repository.SetorRepository;

@CrossOrigin
@RestController
@RequestMapping("/setor")
public class SetorController {
	
	@Autowired
	private SetorRepository setorRepository;
	
	@GetMapping
	//@Cacheable("consultaSetor")
	public ResponseEntity<List<Setor>> listar() {
		Sort sort = new Sort(Sort.Direction.ASC, "Nome");
		List<Setor> setor = setorRepository.findAll(sort);
		if (setor==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(setor);
	}

	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Setor salvar(@Valid @RequestBody Setor setor) {
		setor = setorRepository.save(setor);
		return setor;
	}
}
