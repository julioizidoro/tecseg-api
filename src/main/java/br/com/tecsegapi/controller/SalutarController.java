package br.com.tecsegapi.controller;

import java.util.Date;
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

import br.com.tecsegapi.model.Salutar;
import br.com.tecsegapi.repository.SalutarFuncionarioRepository;
import br.com.tecsegapi.repository.SalutarRepository;
import br.com.tecsegapi.util.Conversor;

@CrossOrigin
@RestController
@RequestMapping("/salutar")
public class SalutarController {
	
	@Autowired
	private SalutarRepository salutarRepository;
	@Autowired 
	private SalutarFuncionarioRepository salutarFuncionarioRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Salutar> buscar(@PathVariable Integer id) {
		Optional<Salutar> salutar = salutarRepository.findById(id);
		if (salutar==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(salutar.get());
	}
	
	
	@GetMapping("listar/{datainicial}/{datafinal}")
	public ResponseEntity<Optional<List<Salutar>>> listar(@PathVariable("datainicial") Date datainicial, @PathVariable("datafinal") Date datafinal) {
		if (datainicial.after(datafinal)) {
			Conversor c = new Conversor();
			datainicial = c.SomarDiasData(new Date(), -180);
		}
		Optional<List<Salutar>> lista = salutarRepository.listar(datainicial, datafinal);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar")
	public ResponseEntity<Optional<List<Salutar>>> listar() {
			Conversor c = new Conversor();
			Date datainicial = c.SomarDiasData(new Date(), -180);
		Optional<List<Salutar>> lista = salutarRepository.listar(datainicial, new Date());
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/{idloja}/{datainicial}/datafinal")
	public ResponseEntity<Optional<List<Salutar>>> listar(@PathVariable("idloja") int idloja, 
			@PathVariable("datainicial") Date datainicial, @PathVariable("datafinal") Date datafinal) {
		if (datainicial.after(datafinal)) {
			Conversor c = new Conversor();
			datainicial = c.SomarDiasData(new Date(), -180);
		}
		Optional<List<Salutar>> lista = salutarRepository.findAllLoja(idloja, datainicial, new Date());
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar/{idloja}")
	public ResponseEntity<Optional<List<Salutar>>> listar(@PathVariable("idloja") int idloja){
		Conversor c = new Conversor();
    	Date datainicial = c.SomarDiasData(new Date(), -180);
		Optional<List<Salutar>> lista = salutarRepository.findAllLoja(idloja, datainicial, new Date());
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Salutar salvar(@Valid @RequestBody Salutar salutar) {
		salutar = salutarRepository.save(salutar);
		return salutar;
	}
	
	@DeleteMapping("/deletar")
	@ResponseStatus(HttpStatus.CREATED)
	public void deletar(@Valid @RequestBody Salutar salutar) {
		salutarFuncionarioRepository.deleteSalutar(salutar.getIdsalutar());
		salutarRepository.delete(salutar);
	}

}
