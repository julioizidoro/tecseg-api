package br.com.tecsegapi.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Asocontrole;

import br.com.tecsegapi.repository.AsoControleRepository;
import br.com.tecsegapi.util.Conversor;

@CrossOrigin
@RestController
@RequestMapping("/asocontrole")
public class AsoControleController {
	
	@Autowired
	private AsoControleRepository asoControleRepository;
	
	@GetMapping("/datavencimento/{datavencimentostart}/{datavencimentoend}")
	public ResponseEntity<Optional<List<Asocontrole>>> listar(@PathVariable("datavencimentostart") String datavencimentostart, @PathVariable("datavencimentoend") String datavencimentoend) {
		Conversor c = new Conversor();
		Date dataStart = c.ConvercaoStringData(datavencimentostart);
		Date dataEnd = c.ConvercaoStringData(datavencimentoend);
		Optional<List<Asocontrole>> asoControle = asoControleRepository.findAll(dataStart, dataEnd);
		if (asoControle==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(asoControle);
	}
	
	@GetMapping
	public ResponseEntity<Optional<List<Asocontrole>>> listar() {
		Optional<List<Asocontrole>> asoControle = asoControleRepository.findAllFinalizadoo();
		if (asoControle==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(asoControle);
	}

}
