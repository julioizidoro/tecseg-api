package br.com.tecsegapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.tecsegapi.model.Salutarfuncionario;
import br.com.tecsegapi.repository.SalutarFuncionarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/salutarfuncionario")
public class SalutarFuncionarioController {
	
	@Autowired
	private SalutarFuncionarioRepository salutarFuncionarioRepository;
	
	@GetMapping("listar/{idsalutar}")
	public ResponseEntity<Optional<List<Salutarfuncionario>>> listar(@PathVariable("idsalutar") int idsalutar){
		Optional<List<Salutarfuncionario>> lista = salutarFuncionarioRepository.findAllSalutar(idsalutar);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Salutarfuncionario> salvar(@Valid @RequestBody List<Salutarfuncionario> lista) {
		List<Salutarfuncionario> listaSalva = new ArrayList<Salutarfuncionario>();
 		for (int i=0; i<lista.size();i++) {
			Salutarfuncionario salutarFuncionarios = salutarFuncionarioRepository.save(lista.get(i));
			listaSalva.add(salutarFuncionarios);
		}
		return listaSalva;
	}
}
