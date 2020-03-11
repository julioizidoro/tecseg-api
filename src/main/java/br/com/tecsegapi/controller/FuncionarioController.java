package br.com.tecsegapi.controller;

import java.io.File;
import java.net.URI;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Funcionario;
import br.com.tecsegapi.repository.FuncionarioRepository;
import br.com.tecsegapi.service.S3Service;
import br.com.tecsegapi.util.Conversor;
import br.com.tecsegapi.util.GerarExcel;

@CrossOrigin
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private S3Service s3Service;
	
	@GetMapping("/{nome}/{sit}")
	public ResponseEntity<Optional<List<Funcionario>>> listar(@PathVariable("nome") String nome, @PathVariable("sit") String sit1) {
		if (nome.equalsIgnoreCase("@")) {
			nome = " ";
		}
		String sit2= sit1;
		if (sit1.equalsIgnoreCase("@")) {
			sit1 = "Ativo";
			sit2 = "Afastado";
		}else {
			sit2 = sit1;
		}
		Optional<List<Funcionario>> funcionarios = funcionarioRepository.findAllNome(nome, sit1, sit2);
		if (funcionarios==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(funcionarios);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Optional<Funcionario>> consultar(@PathVariable("id") int id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if (funcionario==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(funcionario);
	}
	
	@GetMapping("cpf/{cpf}")
	public ResponseEntity<Optional<Funcionario>> consultar(@PathVariable("cpf") String cpf) {
		Optional<Funcionario> funcionario = funcionarioRepository.findBycpf(cpf);
		if (funcionario==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(funcionario);
	}
	
	@GetMapping("funcao/{idfuncao}/{nome}/{sit}")
	@Cacheable("consultaFuncionarioFuncao")
	public ResponseEntity<Optional<List<Funcionario>>> consultarFuncionarioFuncao(@PathVariable("idfuncao") int idfuncao, 
			@PathVariable("nome") String nome, @PathVariable("sit") String sit1) {
		if (nome.equalsIgnoreCase("@")) {
			nome = " ";
		}
		String sit2;
		if (sit1.equalsIgnoreCase("@")) {
			sit1 = "Ativo";
			sit2 = "Afastado";
		}else {
			sit2 = sit1;
		}
		Optional<List<Funcionario>> funcionario = funcionarioRepository.findAllFuncionarioFuncao(idfuncao, nome, sit1, sit2);
		if (funcionario==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(funcionario);
	}
	
	@GetMapping("loja/{idloja}/{nome}/{sit}")
	@Cacheable("consultaFuncionarioLoja")
	public ResponseEntity<Optional<List<Funcionario>>> consultarFuncinarioLoja(@PathVariable("idloja") int idloja, 
			@PathVariable("nome") String nome, @PathVariable("sit") String sit1) {
		if (nome.equalsIgnoreCase("@")) {
			nome = " ";
		}
		String sit2;
		if (sit1.equalsIgnoreCase("@")) {
			sit1 = "Ativo";
			sit2 = "Afastado";
		}else {
			sit2 = sit1;
		}
		Optional<List<Funcionario>> funcionario = funcionarioRepository.findAllFuncionarioLoja(idloja, nome, sit1, sit2);
		if (funcionario==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(funcionario);
	}
	
	@GetMapping("{idloja}/{idfuncao}/{nome}/{sit}")
	@Cacheable("consultaFuncionarioFuncaoLoja")
	public ResponseEntity<Optional<List<Funcionario>>> consultarFuncionarioLoja(
			@PathVariable("idloja") int idloja, 
			@PathVariable("idfuncao") int idfuncao, 
			@PathVariable("nome") String nome,
			@PathVariable("sit") String sit1) {
		if (nome.equalsIgnoreCase("@")) {
			nome = " ";
		}
		String sit2;
		if (sit1.equalsIgnoreCase("@")) {
			sit1 = "Ativo";
			sit2 = "Afastado";
		}else {
			sit2 = sit1;
		}
		Optional<List<Funcionario>> funcionario = funcionarioRepository.findAllFuncionarioFuncaoLoja(idloja, idfuncao, nome, sit1, sit2);
		if (funcionario==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(funcionario);
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	@CachePut("consultaFuncionario")
	public Funcionario salvar(@Valid @RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@PutMapping("/atualizar")
	@ResponseStatus(HttpStatus.CREATED)
	@CachePut("consultaFuncionario")
	public Funcionario atualizar(@Valid @RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	@GetMapping("salutar")
	public ResponseEntity<Void> gerarSalutar() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		if (funcionarios==null) {
			return ResponseEntity.notFound().build();
		}
		GerarExcel gerar = new GerarExcel();
		gerar.excelSalutar(funcionarios);
		File file = gerar.getFile();
		URI uri = s3Service.uploadFile(file);
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("lojasalutar/{idloja}")
	public ResponseEntity<Optional<List<Funcionario>>> consultarLoja(@PathVariable("idloja") int idloja) {
		Optional<List<Funcionario>> lista = funcionarioRepository.findAllLoja(idloja);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("lojasalutar/{idloja}/{datainicial}/{datafinal}")
	public ResponseEntity<Optional<List<Funcionario>>> consultarLojaData(@PathVariable("idloja") int idloja,
			@PathVariable("datainicial") String datainicial, @PathVariable("datafinal") String datafinal) {
		Conversor c = new Conversor();
		Date di = c.ConvercaoStringData(datainicial);
		Date df = c.ConvercaoStringData(datafinal);
		Optional<List<Funcionario>> lista = funcionarioRepository.findAllLojaData(idloja, df);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	public void ctps() {
		List<Funcionario> lista = funcionarioRepository.findAll();
		for (int i=0;i<lista.size();i++) {
			Funcionario f = lista.get(i);
			String dados="";
			if ((f.getSerie()==null) && (f.getCtps()!=null)) {
			for (int n=0;n<f.getCtps().length()-1;n++) {
				if (f.getCtps().charAt(n)!= '/') {
					dados = dados + f.getCtps().charAt(n); 
				}else {
					f.setSerie(f.getCtps().substring(n+1, f.getCtps().length()));
					f.setCtps(dados);
					funcionarioRepository.save(f);
					System.out.println(dados);
				}
			}
			}
			 
			
		}
	}
	
	@GetMapping("aniversariantes")
	public ResponseEntity<Optional<List<Funcionario>>> getAniversariantes() {
		GregorianCalendar calendar = new GregorianCalendar();
		int dia = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		int mes = calendar.get(GregorianCalendar.MONTH) + 1;
		int mes1 = mes;
		int mes2= mes;
		int dia1 = dia - 5;
		if (dia1<1) {
			dia1= 31;
			mes1 = mes1 - 1;
			if (mes1<1) {
				mes1 = 12;
			}
		}
		int dia2 = dia + 7;
		if (dia2>31) {
			dia2 = 0 + (dia2 - 31);
			mes2 = mes2 + 1;
			if (mes2==12) {
				mes2 = 1;
			}
		}		
		Optional<List<Funcionario>> lista = funcionarioRepository.getAniversariantes(mes1, dia1, mes2, dia2);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
	}

}
