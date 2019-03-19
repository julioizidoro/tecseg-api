package br.com.tecsegapi.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import br.com.tecsegapi.model.Asocontrole;
import br.com.tecsegapi.model.Asotipo;
import br.com.tecsegapi.model.Funcionario;
import br.com.tecsegapi.repository.AsoControleRepository;
import br.com.tecsegapi.repository.AsoTipoRepository;
import br.com.tecsegapi.repository.FuncionarioRepository;
import br.com.tecsegapi.util.Conversor;


@CrossOrigin
@RestController
@RequestMapping("/asocontrole")
public class AsoControleController {
	
	@Autowired
	private AsoControleRepository asoControleRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private AsoTipoRepository asoTipoRepository;
	
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
	@Cacheable("consultaAsoControle")
	public ResponseEntity<Optional<List<Asocontrole>>> listar() {
		Conversor c = new Conversor();
		Date data = c.SomarDiasData(new Date(), 60);
		Optional<List<Asocontrole>> asoControle = asoControleRepository.findAllFinalizadoo(data);
		if (asoControle==null) {
			return ResponseEntity.notFound().build();
		}
		asoControle = gerarSituacao(asoControle);
		return ResponseEntity.ok(asoControle);
	}
	
	@GetMapping("/calculardata/{dataexame}/{dias}")
	public ResponseEntity<Date> calcularVencimento(@PathVariable("dataexame") String dataExame, 
			@PathVariable("dias") int dias) {
		Conversor c = new Conversor();
		Date dataVencimento = c.ConvercaoStringData(dataExame);
		dias = dias * 30;
		dataVencimento = c.SomarDiasData(dataVencimento, dias);
		return ResponseEntity.ok(dataVencimento);
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	@CachePut("consultaAsoControle")
	public Asocontrole salvar(@Valid @RequestBody Asocontrole asoControle) {
		return asoControleRepository.save(asoControle);
	}
	
	@PostMapping("/upload")
	@ResponseStatus(HttpStatus.CREATED)
	//@CachePut("consultaFuncionario")
	public void upload(@RequestParam MultipartFile file) {
	//	UploadAWSS3 s3 = new UploadAWSS3("local");
//		s3.uploadFile(file, "remoto");
	}
	
	
	
	
	
	public  Optional<List<Asocontrole>> gerarSituacao(Optional<List<Asocontrole>> optional) {
		Conversor c = new Conversor();
		for (int i=0;i<optional.get().size();i++) {
			String sit = c.verficarSituacaoAtestado(optional.get().get(i));
			optional.get().get(i).setSituacao(sit);
		}
		return optional;
	}
	
	public void gerarExames() {
		List<Funcionario> listaf = funcionarioRepository.findAll();
		Optional<Asotipo> tipo = asoTipoRepository.findById(2);
		Conversor c = new Conversor();
		for (int i = 0; i < listaf.size(); i++) {
			if (listaf.get(i).getDataexame() != null) {
				Asocontrole aso = new Asocontrole();
				aso.setAsotipo(tipo.get());
				aso.setDataexame(listaf.get(i).getDataexame());
				int dias = tipo.get().getPeriodicidade();
				dias = dias * 30;
				Date data = c.SomarDiasData(listaf.get(i).getDataexame(), dias);
				aso.setDatavencimento(data);
				aso.setFinalizado(false);
				aso.setFuncionario(listaf.get(i));
				asoControleRepository.save(aso);
			}
		}
		System.out.print("terminou");

	}
	
	

}
