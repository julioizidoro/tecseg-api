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

import br.com.tecsegapi.model.Treinamentotipo;
import br.com.tecsegapi.repository.TreinamentoTipoRepository;

@CrossOrigin
@RestController
@RequestMapping("/treinamentotipo")
public class TreinamentoTipoController {
	
	@Autowired
	private TreinamentoTipoRepository treinamentoTipoRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Treinamentotipo salvar(@Valid @RequestBody Treinamentotipo Treinamentotipo) {
		return treinamentoTipoRepository.save(Treinamentotipo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Treinamentotipo> buscar(@PathVariable Integer id) {
		Optional<Treinamentotipo> Treinamentotipo = treinamentoTipoRepository.findById(id);
		
		if (Treinamentotipo==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(Treinamentotipo.get());
	}
	
	@GetMapping("listar/nome/{nome}")
	public ResponseEntity<Optional<List<Treinamentotipo>>> listarNome(@PathVariable("nome") String nome) {
		Optional<List<Treinamentotipo>> lista = treinamentoTipoRepository.findByNomeContainingOrderByNome(nome);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/tipo/{tipo}")
	public ResponseEntity<Optional<List<Treinamentotipo>>> listarTipo(@PathVariable("tipo") String tipo) {
		Optional<List<Treinamentotipo>> lista = treinamentoTipoRepository.findByTipoContainingOrderByNome(tipo);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("listar")
	public ResponseEntity<List<Treinamentotipo>> listar() {
		List<Treinamentotipo> lista = treinamentoTipoRepository.findAll();
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

}
