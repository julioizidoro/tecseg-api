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
	
	
	

}
