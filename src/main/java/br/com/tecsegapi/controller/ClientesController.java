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

import br.com.tecsegapi.model.Clientes;
import br.com.tecsegapi.repository.ClientesRepository;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Clientes salvar(@Valid @RequestBody Clientes cliente) {
		return clientesRepository.save(cliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clientes> buscar(@PathVariable Integer id) {
		Optional<Clientes> cliente = clientesRepository.findById(id);
		if (cliente==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente.get());
	}
	

	@GetMapping("listar/tipo/{tipo}")
	public ResponseEntity<Optional<List<Clientes>>> listar(@PathVariable("tipo") String tipo) {
		Optional<List<Clientes>> lista = clientesRepository.findByTipoOrderByNome(tipo);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/{nome}/{email}/{tipo}")
	public ResponseEntity<Optional<List<Clientes>>> listar(@PathVariable("nome") String nome, @PathVariable("email") String email, @PathVariable("email") String tipo) {
		if (nome.equalsIgnoreCase("@")) {
			nome = " ";
		}
		if (email.equalsIgnoreCase("@")) {
			email = " ";
		}
		Optional<List<Clientes>> lista = clientesRepository.findByTipoAndNomeContainingOrEmailContainingOrderByNome(tipo, nome, email);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar")
	public ResponseEntity<List<Clientes>> listar() {
		List<Clientes> lista = clientesRepository.findAll();
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	

}
