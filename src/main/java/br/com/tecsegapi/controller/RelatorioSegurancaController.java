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
import br.com.tecsegapi.model.Relatorioseguranca;
import br.com.tecsegapi.repository.RelatorioSegurancaRepository;
import br.com.tecsegapi.util.Conversor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@CrossOrigin
@RestController
@RequestMapping("/relseguranca")
public class RelatorioSegurancaController {
	
	@Autowired
	private RelatorioSegurancaRepository relatorioSegurancaRepository;
	
	@Autowired
	private ConectionFactory conexao;
	
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
	
	@GetMapping("/rs/{id}")
	public void imprimirListaPresenca(@PathVariable("id") int id, HttpServletResponse response) throws JRException, IOException {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("id", id);
		InputStream isLogo = this.getClass().getResourceAsStream("/report/logohiper.jpg");
		InputStream isLogosst = this.getClass().getResourceAsStream("/report/logosst.png");
		BufferedImage logo = ImageIO.read(isLogo);
		BufferedImage logosst = ImageIO.read(isLogosst);
		parametros.put("logo", logo);
		parametros.put("logosst", logosst);
		// Pega o arquivo .jasper localizado em resources
		InputStream jasperStream = this.getClass().getResourceAsStream("/report/rs/relatoriors.jasper");
		
		// Cria o objeto JaperReport com o Stream do arquivo jasper
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		
		// Passa para o JasperPrint o relatório, os parâmetros e a fonte dos dados, no caso uma conexão ao banco de dados
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conexao.getConexao());
		
		// Configura a respota para o tipo PDF
		response.setContentType("application/pdf");
		// Define que o arquivo pode ser visualizado no navegador e também nome final do arquivo
		// para fazer download do relatório troque 'inline' por 'attachment'
		String fileName = "relatorioSeguranca-" + String.valueOf(id) + ".pdf"; 
		response.setHeader("Content-Disposition", "inline; " + fileName);

		// Faz a exportação do relatório para o HttpServletResponse
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	

}
