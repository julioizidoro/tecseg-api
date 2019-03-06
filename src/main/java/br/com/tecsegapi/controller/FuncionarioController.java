package br.com.tecsegapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
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

import br.com.tecsegapi.model.Funcionario;
import br.com.tecsegapi.repository.FuncionarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/{nome}")
	public ResponseEntity<Optional<List<Funcionario>>> listar(@PathVariable("nome") String nome) {
		Optional<List<Funcionario>> funcionarios = funcionarioRepository.findByNomeContainingOrderByNome(nome);
		if (funcionarios==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(funcionarios);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Optional<Funcionario>> cnsultar(@PathVariable("id") int id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if (funcionario==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(funcionario);
	}
	
	
	@GetMapping
	@Cacheable("consultaFuncionario")
	public ResponseEntity<List<Funcionario>> listar() {
		Sort sort = new Sort(Sort.Direction.ASC, "Nome");
		List<Funcionario> funcionarios = funcionarioRepository.findAll(sort);
		if (funcionarios==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(funcionarios);
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	@CachePut("consultaFuncionario")
	public Funcionario salvar(@Valid @RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

}
