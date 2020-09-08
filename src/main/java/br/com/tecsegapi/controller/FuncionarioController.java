package br.com.tecsegapi.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.bean.Contratoexp;
import br.com.tecsegapi.config.ConectionFactory;
import br.com.tecsegapi.model.Funcionario;
import br.com.tecsegapi.repository.FuncionarioRepository;
import br.com.tecsegapi.service.S3Service;
import br.com.tecsegapi.util.Conversor;
import br.com.tecsegapi.util.GerarExcel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@CrossOrigin
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private S3Service s3Service;
	
	@Autowired
	private ConectionFactory conexao;
	
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
	public ResponseEntity<Funcionario> consultar(@PathVariable("cpf") String cpf) {
		Funcionario funcionario = funcionarioRepository.findBycpf(cpf);
		if (funcionario==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(funcionario);
	}
	
	@GetMapping("funcao/{idfuncao}/{nome}/{sit}/{sexo}")
	@Cacheable("consultaFuncionarioFuncao")
	public ResponseEntity<Optional<List<Funcionario>>> consultarFuncionarioFuncao(@PathVariable("idfuncao") int idfuncao, 
			@PathVariable("nome") String nome, @PathVariable("sit") String sit1, @PathVariable("sexo") String sexo) {
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
		Optional<List<Funcionario>> funcionario = funcionarioRepository.findAllFuncionarioFuncao(idfuncao, nome, sit1, sit2, sexo);
		if (funcionario==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(funcionario);
	}
	
	@GetMapping("loja/{idloja}/{nome}/{sit}/{sexo}")
	@Cacheable("consultaFuncionarioLoja")
	public ResponseEntity<Optional<List<Funcionario>>> consultarFuncinarioLoja(@PathVariable("idloja") int idloja, 
			@PathVariable("nome") String nome, @PathVariable("sit") String sit1, @PathVariable("sexo") String sexo) {
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
		Optional<List<Funcionario>> funcionario = funcionarioRepository.findAllFuncionarioLoja(idloja, nome, sit1, sit2, sexo);
		if (funcionario==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(funcionario);
	}
	
	@GetMapping("{idloja}/{idfuncao}/{nome}/{sit}/{sexo}")
	@Cacheable("consultaFuncionarioFuncaoLoja")
	public ResponseEntity<Optional<List<Funcionario>>> consultarFuncionarioLoja(
			@PathVariable("idloja") int idloja, 
			@PathVariable("idfuncao") int idfuncao, 
			@PathVariable("nome") String nome,
			@PathVariable("sit") String sit1,
			@PathVariable("sexo") String sexo) {
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
		Optional<List<Funcionario>> funcionario = funcionarioRepository.findAllFuncionarioFuncaoLoja(idloja, idfuncao, nome, sit1, sit2, sexo);
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
		Optional<List<Funcionario>> lista = funcionarioRepository.findAllLoja(idloja, "N");
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
	
	@GetMapping("calcudarexp/{dias}/{data}") 
	public Date calcularDataExperiencia(
			@PathVariable("dias") int dias,
			@PathVariable("data") String data) {
		Conversor c = new Conversor();
		Date dataCalculada = c.ConvercaoStringData(data);
		dataCalculada = c.SomarDiasData(dataCalculada, dias);
		
	return dataCalculada;
	}
	
	@GetMapping("contratos")
	public ResponseEntity<List<Contratoexp>> findContrato() {
		Conversor c = new Conversor();
		Date idata = c.SomarDiasData(new Date(), -7);
		String sDate = c.ConvercaoDataBR(new Date());
	    int dia = Integer.parseInt(sDate.substring(0,2));
	    int mes = Integer.parseInt(sDate.substring(3,5));
	    int ano = Integer.parseInt(sDate.substring(6,10));
	    if (dia>=25) {
	    	dia = 1;
	    	if (mes==12) {
	    		mes=1;
	    		ano++;
	    	}else {
	    		mes++;
	    	}
	    } else {
	    	dia = c.getRestoMes(mes);
	    }
	    if (dia<10) {
	    	sDate = '0' + String.valueOf(dia);
	    } else sDate = String.valueOf(dia);
	    if (mes<10) {
	    	sDate =  "0" + String.valueOf(mes)  + "-" + sDate;
	    } else sDate = String.valueOf(mes) + "-" + sDate;
	    sDate = Integer.valueOf(ano) + "-" + sDate;
	    Date fdata = c.ConvercaoStringData(sDate);
	    List<Funcionario> lista = funcionarioRepository.findContrato(idata, fdata);
		List<Contratoexp> listaContrato = new ArrayList<Contratoexp>();
		if (lista!=null) {
			for (int i=0;i<lista.size();i++) {
				Contratoexp contrato = new Contratoexp();
				contrato.setFuncionario(lista.get(i));
				if (lista.get(i).getDataexp1().after(new Date())) {
					contrato.setDatavencendo(lista.get(i).getDataexp1());
					contrato.setDiasvencendo(lista.get(i).getDiasexp1());
					contrato.setTipovencimento("Contrato");
					listaContrato.add(contrato);
				} else {
					contrato.setDatavencendo(lista.get(i).getDataexp2());
					contrato.setDiasvencendo(lista.get(i).getDiasexp2());
					contrato.setTipovencimento("Renovação");
					listaContrato.add(contrato);
				}
			}
		}
		if (listaContrato.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(listaContrato);
	}
	
	@GetMapping("/tro/{id}/{local}/{cor}")
	public void imprimirListaPresenca(@PathVariable("id") int id, @PathVariable("local") String local, @PathVariable("cor") String cor, HttpServletResponse response) throws JRException, IOException {
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("id", id);
		parametros.put("local", local);
		parametros.put("cor", cor);
		InputStream isLogo = this.getClass().getResourceAsStream("/report/logohiper.jpg");
		InputStream isLogosst = this.getClass().getResourceAsStream("/report/logosst.png");
		BufferedImage logo = ImageIO.read(isLogo);
		BufferedImage logosst = ImageIO.read(isLogosst);
		parametros.put("logo", logo);
		parametros.put("logosst", logosst);
		// Pega o arquivo .jasper localizado em resources
		InputStream jasperStream = this.getClass().getResourceAsStream("/report/funcionarios/termomascara.jasper");
		
		// Cria o objeto JaperReport com o Stream do arquivo jasper
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		
		// Passa para o JasperPrint o relatório, os parâmetros e a fonte dos dados, no caso uma conexão ao banco de dados
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conexao.getConexao());
		
		// Configura a respota para o tipo PDF
		response.setContentType("application/pdf");
		// Define que o arquivo pode ser visualizado no navegador e também nome final do arquivo
		// para fazer download do relatório troque 'inline' por 'attachment'
		String fileName = "termomascara-" + String.valueOf(id) + ".pdf"; 
		response.setHeader("Content-Disposition", "inline; " + fileName);

		// Faz a exportação do relatório para o HttpServletResponse
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	@GetMapping("listar/{nome}/{loja}/{sexo}/{situacao}/{funcao}/{setor}") 
	public ResponseEntity<List<Funcionario>> listarByOrderNome(
			@PathVariable("nome") String nome,
			@PathVariable("loja") String loja,
			@PathVariable("sexo") String sexo,
			@PathVariable("situacao") String situacao,
			@PathVariable("funcao") String funcao,
			@PathVariable("setor") String setor) {
		String ativo =" ";
		String afastado = " ";
		String inativo = " ";
		if (nome.equalsIgnoreCase("@")){
			nome = "";
		}
		if (loja.equalsIgnoreCase("@")) {
			loja = "";
		}
		if (sexo.equalsIgnoreCase("@")) {
			sexo = "";
		}
		
		if (situacao.equalsIgnoreCase("@")) {
			ativo = "ativo";
			afastado = "afastado";
			inativo = "ativo";
		} else if (situacao.equalsIgnoreCase("ativo")) {
			ativo = "ativo";
			afastado = "ativo";
			inativo = "ativo";
		} else if (situacao.equalsIgnoreCase("afastado")) {
			ativo = "afastado";
			afastado = "afastado";
			inativo = "afastado";
		} else if (situacao.equalsIgnoreCase("inativo")) {
			ativo = "inativo";
			afastado = "inativo";
			inativo = "inativo";
		} 
		if (funcao.equalsIgnoreCase("@")) {
			funcao = "";
		}
		if (setor.equalsIgnoreCase("@")) {
			setor = "";
		}
		List<Funcionario> lista = funcionarioRepository.findByOrderNome(nome, loja, sexo, ativo, afastado, inativo, funcao, setor);
		if (lista==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(lista);
		
	}
	
	
}
