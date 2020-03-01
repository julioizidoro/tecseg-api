package br.com.tecsegapi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

import br.com.tecsegapi.config.ConectionFactory;
import br.com.tecsegapi.model.Treinamento;
import br.com.tecsegapi.model.Treinamentoparticipante;
import br.com.tecsegapi.repository.TreinamentoParticipanteRepository;
import br.com.tecsegapi.repository.TreinamentoRepository;
import br.com.tecsegapi.util.Conversor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@CrossOrigin
@RestController
@RequestMapping("/treinamentos")
public class TreinamentoController {
	
	@Autowired
	private TreinamentoRepository treinamentoRepository;
	
	@Autowired 
	private TreinamentoParticipanteRepository treinamentoParticipanteRepository;
	
	@Autowired
	private ConectionFactory conexao;
	
	
	@PostMapping("participante/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	//@CachePut("consultaTreinamento")
	public Treinamentoparticipante salvarPArticipante(@Valid @RequestBody Treinamentoparticipante participante) {
		Treinamentoparticipante verficar = treinamentoParticipanteRepository.findParticipante(participante.getTreinamento().getIdtreinamento(), participante.getFuncionario().getIdfuncionario());
		if (verficar == null) {
			return treinamentoParticipanteRepository.save(participante);
		} else return verficar;		
	}
	
	@PostMapping("participante/nota")
	@ResponseStatus(HttpStatus.CREATED)
	//@CachePut("consultaTreinamento")
	public Treinamentoparticipante salvarNotasParticipante(@Valid @RequestBody Treinamentoparticipante participante) {
		return treinamentoParticipanteRepository.save(participante);
	}
	
	@PostMapping("salvar")
	@ResponseStatus(HttpStatus.CREATED)
	//@CachePut("consultaTreinamento")
	public Treinamento salvar(@Valid @RequestBody Treinamento treinamento) {
		if (treinamento.getSituacao().equalsIgnoreCase("Finalizado")) {
			if (treinamento.getDatavencimento() == null) {
				Conversor c = new Conversor();
				int dias = treinamento.getTreinamentotipo().getPeriodicidade();
				treinamento.setDatavencimento(c.SomarDiasData(treinamento.getData(), dias));
			}
		}
		return treinamentoRepository.save(treinamento);
	}
	
	@DeleteMapping("participante/deletar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void deleteParticipante(@PathVariable("id") int id) {
		treinamentoParticipanteRepository.deleteById(id);
	}
	
	@GetMapping("/participantes/{id}")
	public ResponseEntity<Optional<List<Treinamentoparticipante>>> findAllParticipante(@PathVariable("id") int id) {
		Optional<List<Treinamentoparticipante>> participantes = treinamentoParticipanteRepository.findAllPadrao(id);
		if (participantes==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(participantes);
	}
	
	@GetMapping("/dias/{dias}")
	//@Cacheable("consultaTreinamento")
	public ResponseEntity<Optional<List<Treinamento>>> findAllDias(@PathVariable("dias") int dias) {
		Conversor c = new Conversor();
		Date dataConsulta = c.SomarDiasData(new Date(), dias);
		Optional<List<Treinamento>> treinamentos = treinamentoRepository.findAllDias(dataConsulta);
		if (treinamentos==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(treinamentos);
	}
	
	@GetMapping
	//@Cacheable("consultaTreinamento")
	public ResponseEntity<Optional<List<Treinamento>>> findAll() {
		Conversor c = new Conversor();
		Date dataConsulta = c.SomarDiasData(new Date(), -90);
		Optional<List<Treinamento>> treinamentos = treinamentoRepository.findAllPadrao(dataConsulta);
		if (treinamentos==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(treinamentos);
	}
	
	@GetMapping("/listapresenca/{id}")
	public void imprimirListaPresenca(@PathVariable("id") int id, HttpServletResponse response) throws JRException, IOException {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("id", id);
		InputStream isLogo = this.getClass().getResourceAsStream("/report/logohiper.jpg");
		BufferedImage logo = ImageIO.read(isLogo);
		parametros.put("logo", logo);
		// Pega o arquivo .jasper localizado em resources
		InputStream jasperStream = this.getClass().getResourceAsStream("/report/treinamento/listapresenca.jasper");
		
		// Cria o objeto JaperReport com o Stream do arquivo jasper
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		
		// Passa para o JasperPrint o relatório, os parâmetros e a fonte dos dados, no caso uma conexão ao banco de dados
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conexao.getConexao());
		
		// Configura a respota para o tipo PDF
		response.setContentType("application/pdf");
		// Define que o arquivo pode ser visualizado no navegador e também nome final do arquivo
		// para fazer download do relatório troque 'inline' por 'attachment'
		String fileName = "listapresentaca-" + String.valueOf(id) + ".pdf"; 
		response.setHeader("Content-Disposition", "inline; " + fileName);

		// Faz a exportação do relatório para o HttpServletResponse
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	
}
