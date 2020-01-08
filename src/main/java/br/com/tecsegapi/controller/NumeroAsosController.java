package br.com.tecsegapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Numeroasos;
import br.com.tecsegapi.repository.NumeroAsosRepository;

@CrossOrigin
@RestController
@RequestMapping("/numeroasos")
public class NumeroAsosController {
	
	@Autowired
	private NumeroAsosRepository numeroAsosRepository;
	
	@GetMapping("/id")
	public ResponseEntity<Numeroasos> getNumeros() {
		Optional<Numeroasos> numeroAsos = numeroAsosRepository.findById(1);
		
		if (numeroAsos==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(numeroAsos.get());
	}

}
