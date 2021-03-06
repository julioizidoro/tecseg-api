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

import br.com.tecsegapi.model.Contasusuario;
import br.com.tecsegapi.repository.ContasUsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/contasusarios")
public class ContasUsuarioController {
	
	@Autowired
	private ContasUsuarioRepository contasUsuarioRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Contasusuario salvar(@Valid @RequestBody Contasusuario contasUsuario) {
		return contasUsuarioRepository.save(contasUsuario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Optional<Contasusuario>>> buscar(@PathVariable Integer id) {
		List<Optional<Contasusuario>> lista = contasUsuarioRepository.findConta(id);
		
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}

}
