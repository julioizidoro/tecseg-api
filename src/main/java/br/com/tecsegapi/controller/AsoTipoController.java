package br.com.tecsegapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Asotipo;
import br.com.tecsegapi.repository.AsoTipoRepository;

@CrossOrigin
@RestController
@RequestMapping("/asotipo")
public class AsoTipoController {
	
	@Autowired
	private AsoTipoRepository asoTipoRepository;
	
	@GetMapping
	public ResponseEntity<List<Asotipo>> listar() {
		Sort sort = new Sort(Sort.Direction.ASC, "Nome");
		List<Asotipo> asotipo = asoTipoRepository.findAll(sort);
		if (asotipo==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(asotipo);
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<Optional<List<Asotipo>>> listar(@PathVariable("nome") String nome) {
		Optional<List<Asotipo>> asotipo = asoTipoRepository.findByNomeContainingOrderByNome(nome);
		if (asotipo==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(asotipo);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Optional<Asotipo>> cnsultar(@PathVariable("id") int id) {
		Optional<Asotipo> asoTipo = asoTipoRepository.findById(id);
		if (asoTipo==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(asoTipo);
	}

}
