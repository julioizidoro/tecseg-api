package br.com.tecsegapi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
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
import br.com.tecsegapi.model.Clinicapagto;
import br.com.tecsegapi.model.Clinicapagtoexame;
import br.com.tecsegapi.model.Lojavaloraso;
import br.com.tecsegapi.repository.AgendaExameRepository;
import br.com.tecsegapi.repository.ClinicaPagtoExameReoisitory;
import br.com.tecsegapi.repository.ClinicaPagtoRepository;
import br.com.tecsegapi.repository.FuncionarioRepository;
import br.com.tecsegapi.util.Conversor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@CrossOrigin
@RestController
@RequestMapping("/agendaexame")
public class AgendaExameController {
	
	@Autowired
	private AgendaExameRepository agendaExameRepository;
	@Autowired
	private ClinicaPagtoRepository clinicaPagtoRepository;
	@Autowired 
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private ClinicaPagtoExameReoisitory clinicaPagtoExameReoisitory;

	@Autowired
	private ConectionFactory conexao;
	
	@GetMapping("listar/{idasoagenda}")
	public ResponseEntity<Optional<List<Agendaexame>>> listar(@PathVariable("idasoagenda") int idasoagenda){
		Optional<List<Agendaexame>> lista = agendaExameRepository.findAllSAgendaExame(idasoagenda);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping("/salvarlista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Agendaexame> salvar(@Valid @RequestBody List<Agendaexame> lista) {
		List<Agendaexame> listaSalva = new ArrayList<Agendaexame>();
 		for (int i=0; i<lista.size();i++) {
			Agendaexame agendaExame = agendaExameRepository.save(lista.get(i));
			listaSalva.add(agendaExame);
		}
		return listaSalva;
	}
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public Agendaexame salvarAgendaExame(@Valid @RequestBody Agendaexame agendaExame) {
		if ((agendaExame.getSituacao().equalsIgnoreCase("Finalizado")) && (!agendaExame.isCanculado())) {
			calcularValorExame(agendaExame);
			agendaExame.setCanculado(true);
		}
		agendaExame = agendaExameRepository.save(agendaExame);
		return agendaExame;
	}
	
	public void calcularValorExame(Agendaexame agendaExame) {
		Conversor c = new Conversor();
		String mesAno = c.getMesAno(agendaExame.getDatalancamento());
		Clinicapagto clinicaPagto = clinicaPagtoRepository.getClinicaPagto(mesAno, agendaExame.getAsoagenda().getFuncionario().getLoja().getIdloja());
		if (clinicaPagto==null) {
			clinicaPagto = new Clinicapagto();
			clinicaPagto.setClinica(agendaExame.getClinica());
			clinicaPagto.setFuncionarios(funcionarioRepository.calculaTotalFncionarios(agendaExame.getDatalancamento(), agendaExame.getAsoagenda().getFuncionario().getLoja().getIdloja()));
			clinicaPagto.setLoja(agendaExame.getAsoagenda().getFuncionario().getLoja());
			clinicaPagto.setMesano(mesAno);
			clinicaPagto.setUsuario(agendaExame.getUsuario());
			clinicaPagto.setValorexames(0.0f);
			Lojavaloraso lojavaloraso = new Lojavaloraso();
			
			clinicaPagto.setValorfuncionarios(lojavaloraso.getValoraso() * clinicaPagto.getFuncionarios());
			clinicaPagto.setValortotal(clinicaPagto.getValorexames() + clinicaPagto.getValorfuncionarios());
			if (agendaExame.getAsotipo().getCategoria().equalsIgnoreCase("aso")) {
				Clinicapagtoexame clinicapagtoexame = new Clinicapagtoexame();
				clinicapagtoexame.setAsotipo(agendaExame.getAsotipo());
				clinicapagtoexame.setQuantidade(1);
				clinicapagtoexame.setValorunitario(agendaExame.getAsotipo().getValor());
				clinicapagtoexame.setValortotal(clinicapagtoexame.getValorunitario());
				clinicaPagto = clinicaPagtoRepository.save(clinicaPagto);
				clinicaPagtoExameReoisitory.save(clinicapagtoexame);
			} else {
				if (agendaExame.getAsotipo().getCategoria().equalsIgnoreCase("aso")) {
					boolean achou= false;
					Clinicapagtoexame clinicapagtoexame = new Clinicapagtoexame();
					int idasoTipo = agendaExame.getAsotipo().getIdasotipo();
					for (int i=0;i<clinicaPagto.getClinicapagtoexameList().size();i++) {
						if (idasoTipo == clinicaPagto.getClinicapagtoexameList().get(i).getAsotipo().getIdasotipo()) {
							achou = true;
							clinicapagtoexame = clinicaPagto.getClinicapagtoexameList().get(i);
							i = 10000;
						}
					}
					if (!achou) {
						clinicapagtoexame = new Clinicapagtoexame();
						clinicapagtoexame.setAsotipo(agendaExame.getAsotipo());
						clinicapagtoexame.setQuantidade(1);
						clinicapagtoexame.setValorunitario(agendaExame.getAsotipo().getValor());
						clinicapagtoexame.setValortotal(clinicapagtoexame.getValorunitario());
					} else {
						clinicapagtoexame.setQuantidade(clinicapagtoexame.getQuantidade() + 1);
						clinicapagtoexame.setValortotal(clinicapagtoexame.getValorunitario() * clinicapagtoexame.getQuantidade());
					}
					clinicaPagto.setValorexames(clinicapagtoexame.getValortotal());
					clinicaPagto.setValorexames(clinicaPagto.getValorexames() + clinicapagtoexame.getValorunitario());
				} else {
					if (agendaExame.getAsotipo().getIdasotipo() == 1) {
						clinicaPagto.setFuncionarios(clinicaPagto.getFuncionarios() + 1);
						clinicaPagto.setValorfuncionarios(clinicaPagto.getFuncionarios() * agendaExame.getAsotipo().getValor());
					}
				}
				clinicaPagto = clinicaPagtoRepository.save(clinicaPagto);
				
			}
			
			
		}
	}
	
	@GetMapping("/autorizacaounidos/{id}/{ex}")
	public void imprimirFichaAutorizacaoUnidos(@PathVariable("id") int id, @PathVariable("ex") String ex, HttpServletResponse response) throws JRException, IOException {
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("id", id);
		InputStream isLogo = this.getClass().getResourceAsStream("/report/logosalutar.jpg");
		BufferedImage logo = ImageIO.read(isLogo);
		parametros.put("logo", logo);
		parametros.put("exames", ex);
		// Pega o arquivo .jasper localizado em resources
		InputStream jasperStream = this.getClass().getResourceAsStream("/report/agenda/AutorizacaoLaboratorioUnidos.jasper");

		// Cria o objeto JaperReport com o Stream do arquivo jasper
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);

		// Passa para o JasperPrint o relatório, os parâmetros e a fonte dos dados, no
		// caso uma conexão ao banco de dados
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conexao.getConexao());

		// Configura a respota para o tipo PDF
		response.setContentType("application/pdf");
		// Define que o arquivo pode ser visualizado no navegador e também nome final do
		// arquivo
		// para fazer download do relatório troque 'inline' por 'attachment'
		response.setHeader("Content-Disposition", "inline; filename=AutorizacaoConsultaOcupacional.pdf");

		// Faz a exportação do relatório para o HttpServletResponse
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

}
