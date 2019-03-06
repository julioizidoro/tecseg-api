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

import br.com.tecsegapi.model.Tipoatestado;
import br.com.tecsegapi.repository.TipoAtestadoRepository;


@RestController
@RequestMapping("/tipoatestados")
public class TipoAtestadoController {
	
	@Autowired
	private TipoAtestadoRepository tipoAtestadoRepository;
	
	@GetMapping
	public ResponseEntity<List<Tipoatestado>> listar() {
		List<Tipoatestado> tipoAtestados = tipoAtestadoRepository.findAll();
		if (tipoAtestados==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(tipoAtestados);
	}

}
