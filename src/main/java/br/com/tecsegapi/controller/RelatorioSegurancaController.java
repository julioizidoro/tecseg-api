package br.com.tecsegapi.controller;

import java.util.Date;
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

import br.com.tecsegapi.model.Acesso;
import br.com.tecsegapi.model.Relatorioseguranca;
import br.com.tecsegapi.repository.RelatorioSegurancaRepository;
import br.com.tecsegapi.util.Conversor;

@CrossOrigin
@RestController
@RequestMapping("/relseguranca")
public class RelatorioSegurancaController {
	
	@Autowired
	private RelatorioSegurancaRepository relatorioSegurancaRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Relatorioseguranca salvar(@Valid @RequestBody Relatorioseguranca rs) {
		return relatorioSegurancaRepository.save(rs);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Relatorioseguranca> buscar(@PathVariable Integer id) {
		Optional<Relatorioseguranca> rs = relatorioSegurancaRepository.findById(id);
		
		if (rs==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(rs.get());
	}
	
	@GetMapping("listar")
	public ResponseEntity<Optional<List<Relatorioseguranca>>> listar() {
		Conversor c = new Conversor();
		Date data = c.SomarDiasData(new Date(), -180);
		Optional<List<Relatorioseguranca>> lista = relatorioSegurancaRepository.findAllRelatorios(data);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	

}
