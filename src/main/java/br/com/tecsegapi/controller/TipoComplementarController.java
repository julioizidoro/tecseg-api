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

import br.com.tecsegapi.model.Tipocomplementar;
import br.com.tecsegapi.repository.TipoComplementarRepository;

@CrossOrigin
@RestController
@RequestMapping("/tipocomplementares")
public class TipoComplementarController {
	
	@Autowired
	private TipoComplementarRepository tipoComplementarRepository;
	
	@GetMapping
	public ResponseEntity<Optional<List<Tipocomplementar>>> listar(@PathVariable("nome") String descricao) {
		Optional<List<Tipocomplementar>> tipoComplementares = tipoComplementarRepository.findByDescricaoContainingOrderByDescricao(descricao);
		if (tipoComplementares==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(tipoComplementares);
	}

}
