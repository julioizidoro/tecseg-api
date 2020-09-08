package br.com.tecsegapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Epicontrole;
import br.com.tecsegapi.repository.EpiControleRepository;

@CrossOrigin
@RestController
@RequestMapping("/epicontrole")
public class EpiControleController {
	
	@Autowired
	private EpiControleRepository epiControleRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Epicontrole salvar(@Valid @RequestBody Epicontrole epiControle) {
		return epiControleRepository.save(epiControle);
	}
	
	//@GetMapping("listar/{sql}")
	//public ResponseEntity<Optional<List<Epicontrole>>> listar(@PathVariable("sql") String sql) {
//		Optional<List<Epicontrole>> lista = epiControleRepository.findSql(sql);
	//	if (lista==null) {
		//	return ResponseEntity.notFound().build();
	//	}
		
//		return ResponseEntity.ok(lista);
//	}
	

}
