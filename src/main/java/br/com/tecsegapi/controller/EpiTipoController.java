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

import br.com.tecsegapi.model.Epitipo;
import br.com.tecsegapi.repository.EpiTipoRepository;

@CrossOrigin
@RestController
@RequestMapping("/epitipo")
public class EpiTipoController {
	
	@Autowired
	private EpiTipoRepository epiTipoRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Epitipo salvar(@Valid @RequestBody Epitipo Epitipo) {
		return epiTipoRepository.save(Epitipo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Epitipo> buscar(@PathVariable Integer id) {
		Optional<Epitipo> epiTipo = epiTipoRepository.findById(id);
		
		if (epiTipo==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(epiTipo.get());
	}
	
	@GetMapping("listar/{descricao}")
	public ResponseEntity<Optional<List<Epitipo>>> listar(@PathVariable("descricao") String descricao) {
		if (descricao.equals("@")) {
			descricao = " ";
		}
		Optional<List<Epitipo>> lista = epiTipoRepository.findByDescricaoContainingOrderByDescricao(descricao);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}	
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar")
	public ResponseEntity<List<Epitipo>> listar() {
		List<Epitipo> lista = epiTipoRepository.findAll();
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

}
