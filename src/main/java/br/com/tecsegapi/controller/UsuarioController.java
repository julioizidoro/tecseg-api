package br.com.tecsegapi.controller;


import java.net.URI;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.tecsegapi.model.Usuario;
import br.com.tecsegapi.repository.UsuarioRepository;
import br.com.tecsegapi.service.S3Service;
import br.com.tecsegapi.util.Criptografia;


@CrossOrigin
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private S3Service s3Service;
	
	@GetMapping("buscar/{situacao}")
	public ResponseEntity<Optional<List<Usuario>>> buscarSituacao(@PathVariable("situacao") boolean situacao) {
		Optional<List<Usuario>> usuarios = usuarioRepository.findBySituacaoOrderByNome(situacao);
		if (usuarios==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuarios);
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@Valid @RequestBody Usuario usuario) {
		Criptografia criptografia = new Criptografia();
		String senha = (criptografia.encript(usuario.getSenha()));
		usuario.setSenha(senha);
		return usuarioRepository.save(usuario);
	}
	
	@PostMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if (usuario==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario.get());
	}
	
	@GetMapping("/logar/{login}/{senha}")
	public ResponseEntity<Usuario> buscar(@PathVariable("login") String login, @PathVariable("senha") String senha) {
		Criptografia criptografia = new Criptografia();
		senha = (criptografia.encript(senha));
		Usuario usuario = usuarioRepository.findByLoginAndSenhaAndSituacao(login, senha, true);
		
		if (usuario==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping("buscarnome/{nome}")
	public ResponseEntity<Optional<List<Usuario>>> buscarNome(@PathVariable("nome") String nome) {
		Optional<List<Usuario>> usuarios = usuarioRepository.findByNomeContainingOrderByNome(nome);
		
		if (usuarios.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("cripto/{senha}")
	public ResponseEntity<Usuario> criptoSenha(@PathVariable("senha") String senha) {
		Criptografia criptografia = new Criptografia();
		senha = (criptografia.encript(senha));
		Usuario usuario = new Usuario();
		usuario.setSenha(senha);
		return ResponseEntity.ok(usuario);
	}
	
	
	@PostMapping("/picture")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name="file") MultipartFile file) {
		URI uri = s3Service.uploadFilePictureUser(file);
		return ResponseEntity.created(uri).build();
	}
}
