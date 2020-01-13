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

import br.com.tecsegapi.config.ConectionFactory;
import br.com.tecsegapi.model.Agendaexame;
import br.com.tecsegapi.model.Asoagenda;
import br.com.tecsegapi.repository.AgendaExameRepository;
import br.com.tecsegapi.repository.AsoAgendaRepository;
import br.com.tecsegapi.util.Conversor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@CrossOrigin
@RestController
@RequestMapping("/asoagenda")
public class AsoAgendaController {

	@Autowired
	private AsoAgendaRepository asoAgendaRepository;
	
	@Autowired
	private AgendaExameRepository agendaExameRepository;
	
	@Autowired
	private ConectionFactory conexao;

	@GetMapping
	//@Cacheable("consultaAsoAgenda")
	public ResponseEntity<Optional<List<Asoagenda>>> listar() {
		Optional<List<Asoagenda>> agendas = asoAgendaRepository.findAllAsoAgenda();
		if (agendas == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(agendas);
	}

	// Somente Loja
	@GetMapping("/loja/{idloja}/{nome}")
	//@Cacheable("consultaAsoAgenda")
	public ResponseEntity<Optional<List<Asoagenda>>> findAllLoja(@PathVariable("idloja") int idloja,
			@PathVariable("nome") String nome) {
		if (nome.equalsIgnoreCase("@")) {
			nome = " ";
		}
		Optional<List<Asoagenda>> agendas = asoAgendaRepository.findAllLoja(idloja, nome);
		if (agendas == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(agendas);
	}

	// Somente Situacao
	@GetMapping("/situacao/{situacao}/{nome}")
	//@Cacheable("consultaAsoAgenda")
	public ResponseEntity<Optional<List<Asoagenda>>> findAllSituacao(@PathVariable("situacao") String situacao,
			@PathVariable("nome") String nome) {
		if (nome.equalsIgnoreCase("@")) {
			nome = " ";
		}
		Optional<List<Asoagenda>> agendas = asoAgendaRepository.findAllSituacao(situacao, nome);
		if (agendas == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(agendas);
	}

	// Somente Nome
	@GetMapping("/nome/{nome}")
	//@Cacheable("consultaAsoAgenda")
	public ResponseEntity<Optional<List<Asoagenda>>> findAllNome(@PathVariable("nome") String nome) {
		if (nome.equalsIgnoreCase("@")) {
			nome = " ";
		}
		Optional<List<Asoagenda>> agendas = asoAgendaRepository.findAllNome(nome);
		if (agendas == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(agendas);
	}

	// tudo
	@GetMapping("{idloja}/{nome}/{situacao}")
	//@Cacheable("consultaAsoAgenda")
	public ResponseEntity<Optional<List<Asoagenda>>> findAll(@PathVariable("idloja") int idloja,
			@PathVariable("nome") String nome, @PathVariable("situacao") String situacao) {
		if (nome.equalsIgnoreCase("@")) {
			nome = " ";
		}
		Optional<List<Asoagenda>> agendas = asoAgendaRepository.findAll(idloja, nome, situacao);
		if (agendas == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(agendas);
	}

	@GetMapping("id/{id}")
	public ResponseEntity<Optional<Asoagenda>> consultar(@PathVariable("id") int id) {
		Optional<Asoagenda> agenda = asoAgendaRepository.findById(id);
		if (agenda == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(agenda);
	}

	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	//@CachePut("consultaAsoAgenda")
	public Asoagenda salvar(@Valid @RequestBody Asoagenda asoAgenda) {
		return asoAgendaRepository.save(asoAgenda);
	}
	
	@GetMapping("/autorizacao/{id}")
	public void imprimirFichaAutorizacao(@PathVariable("id") int id, HttpServletResponse response) throws JRException, IOException {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("id", id);
		InputStream isLogo = this.getClass().getResourceAsStream("/report/logosalutar.jpg");
		BufferedImage logo = ImageIO.read(isLogo);
		parametros.put("logo", logo);
		List<Agendaexame> lista = getAgendaExame(id);
		int asoTipo = 0;
		String manipulacaoAlimentos = "N";
		String ec = "";
		String am = "";
		for (Agendaexame exame : lista) {
			if (exame.getSituacao().equalsIgnoreCase("Agendado")) {
				if (exame.getAsotipo().getCategoria().equalsIgnoreCase("aso")) {
					asoTipo = exame.getAsotipo().getIdasotipo();
				} else if (exame.getAsotipo().getCategoria().equalsIgnoreCase("avm")) {
					am = am + " - " + exame.getAsotipo().getNome();
				} else if (exame.getAsotipo().getCategoria().equalsIgnoreCase("exc")) {
					ec = ec + " - " +  exame.getAsotipo().getNome();
				} else if (exame.getAsotipo().getCategoria().equalsIgnoreCase("maa")) {
					manipulacaoAlimentos = "S";
				} 
			}
		}
		parametros.put("manipulacaoalimento", manipulacaoAlimentos);
		parametros.put("amdescricao", am);
		parametros.put("ecdescricao", ec);
		parametros.put("asotipo", asoTipo);
		// Pega o arquivo .jasper localizado em resources
		InputStream jasperStream = this.getClass().getResourceAsStream("/report/AutorizacaoConsultaSalutar.jasper");
		
		// Cria o objeto JaperReport com o Stream do arquivo jasper
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		
		// Passa para o JasperPrint o relatório, os parâmetros e a fonte dos dados, no caso uma conexão ao banco de dados
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conexao.getConexao());
		
		// Configura a respota para o tipo PDF
		response.setContentType("application/pdf");
		// Define que o arquivo pode ser visualizado no navegador e também nome final do arquivo
		// para fazer download do relatório troque 'inline' por 'attachment'
		response.setHeader("Content-Disposition", "inline; filename=AutorizacaoConsultaOcupacional.pdf");

		// Faz a exportação do relatório para o HttpServletResponse
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	@GetMapping("/autorizacaounidos/{id}/{lab}")
	public void imprimirFichaAutorizacaoUnidos(@PathVariable("id") int id, @PathVariable("lab") int lab, HttpServletResponse response) throws JRException, IOException {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("id", id);
		InputStream isLogo = this.getClass().getResourceAsStream("/report/logosalutar.jpg");
		BufferedImage logo = ImageIO.read(isLogo);
		parametros.put("logo", logo);
		List<Agendaexame> lista = getAgendaExame(id);
		String exames = "";
		for (Agendaexame exame : lista) {
			if (exame.getSituacao().equalsIgnoreCase("Agendado")) {
				if (exame.getClinicaexame().getClinica().getIdclinica() == lab) {
					exames = exames + exame.getAsotipo().getNome() + " / ";
				}
				if (exame.getAsotipo().getCategoria().equalsIgnoreCase("aso")) {
					parametros.put("tipoexame",exame.getAsotipo().getNome());
					parametros.put("asotipo",exame.getAsotipo().getIdasotipo());
				}
			}
		}
		parametros.put("exames", exames);
		parametros.put("clinia", lista.get(0).getClinica().getNome());
		parametros.put("endereco", lista.get(0).getClinica().getEndereco() + ", " + lista.get(0).getClinica().getNumero() + " - " +
		               lista.get(0).getClinica().getComplemento());
		parametros.put("cidade", lista.get(0).getClinica().getCidade() + "(" + lista.get(0).getClinica().getEstado()  + ")");
		parametros.put("fone", lista.get(0).getClinica().getFone());
		// Pega o arquivo .jasper localizado em resources
		InputStream jasperStream = this.getClass().getResourceAsStream("/report/agenda/AutorizacaoLaboratorioUnidos.jasper");
		
		// Cria o objeto JaperReport com o Stream do arquivo jasper
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		
		// Passa para o JasperPrint o relatório, os parâmetros e a fonte dos dados, no caso uma conexão ao banco de dados
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conexao.getConexao());
		
		// Configura a respota para o tipo PDF
		response.setContentType("application/pdf");
		// Define que o arquivo pode ser visualizado no navegador e também nome final do arquivo
		// para fazer download do relatório troque 'inline' por 'attachment'
		response.setHeader("Content-Disposition", "inline; filename=AutorizacaoLaboratorioUnidos.pdf");

		// Faz a exportação do relatório para o HttpServletResponse
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	public List<Agendaexame> getAgendaExame(int idAsoAgenda) {
		Optional<List<Agendaexame>> lista = agendaExameRepository.findAllSAgendaExame(idAsoAgenda);
		return lista.get();
	}
	
	//Listar proximos 7 dias
	@GetMapping("/listar7")
	//@Cacheable("consultaAsoAgenda")
	public ResponseEntity<Optional<List<Asoagenda>>> findAll7Dias() {
		Conversor c = new Conversor();
		Date data = c.SomarDiasData(new Date(), 7);
		Optional<List<Asoagenda>> agendas = asoAgendaRepository.findAllData7(data);
		if (agendas == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(agendas);
	}
	
	
	
	

}
