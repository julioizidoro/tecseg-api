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

import br.com.tecsegapi.model.Usuario;
import br.com.tecsegapi.repository.UsuarioRepository;
import br.com.tecsegapi.util.Criptografia;



@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("buscar/{situacao}")
	public ResponseEntity<Optional<List<Usuario>>> buscarSituacao(@PathVariable("situacao") boolean situacao) {
		Optional<List<Usuario>> usuarios = usuarioRepository.findBySituacaoOrderByNome(situacao);
		if (usuarios==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuarios);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@Valid @RequestBody Usuario usuario) {
		Criptografia criptografia = new Criptografia();
		usuario.setSenha(criptografia.encript(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> buscar(@PathVariable Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if (usuario==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("/{login}/{senha}")
	public ResponseEntity<Optional<Usuario>> buscar(@PathVariable("login") String login, @PathVariable("senha") String senha) {
		Criptografia criptografia = new Criptografia();
		senha = (criptografia.encript(senha));
		Optional<Usuario> usuario = usuarioRepository.findByLoginAndSenhaAndSituacao(login, senha,true);
		
		if (usuario==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("buscarnome/{nome}")
	public ResponseEntity<Optional<List<Usuario>>> buscarNome(@PathVariable("nome") String nome) {
		Optional<List<Usuario>> usuarios = usuarioRepository.findByNomeContainingOrderByNome(nome);
		
		if (usuarios==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuarios);
	}

}
