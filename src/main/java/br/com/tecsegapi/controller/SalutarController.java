package br.com.tecsegapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Acesso;
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
	
	@GetMapping("listar/{nome}")
	public ResponseEntity<Optional<List<Salutar>>> listar(@PathVariable("nome") String nome) {
		Optional<List<Salutar>> lista = salutarRepository.findByNomeContainingOrderByNome(nome);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
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

}
