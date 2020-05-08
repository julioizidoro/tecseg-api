package br.com.tecsegapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecsegapi.model.Funcao;
import br.com.tecsegapi.model.Funcionario;
import br.com.tecsegapi.model.Loja;
import br.com.tecsegapi.model.Planilha;
import br.com.tecsegapi.model.Setor;
import br.com.tecsegapi.model.exportar.Campeche;
import br.com.tecsegapi.model.exportar.Lagoa;
import br.com.tecsegapi.model.exportar.Riotavares;
import br.com.tecsegapi.repository.CampecheRepository;
import br.com.tecsegapi.repository.FuncaoRepository;
import br.com.tecsegapi.repository.FuncionarioRepository;
import br.com.tecsegapi.repository.LagoaRepository;
import br.com.tecsegapi.repository.LojaRepository;
import br.com.tecsegapi.repository.PlanilhaRepository;
import br.com.tecsegapi.repository.RiotavaresRepository;
import br.com.tecsegapi.repository.SetorRepository;

@CrossOrigin
@RestController
@RequestMapping("/importar")
public class ImportarController {
	
	@Autowired
	PlanilhaRepository planilhaRepository;
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private LojaRepository lojaRepository;
	
	
	@Autowired
	private FuncaoRepository funcaoRepository;
	
	@Autowired
	private SetorRepository setorRepository;
	
	@Autowired
	private CampecheRepository campecheRepository;
	
	@Autowired
	private LagoaRepository lagoaRepository;
	
	@Autowired
	private RiotavaresRepository riotavaresRepository;
	
	
	
	@GetMapping("")
	public ResponseEntity<String> importar() {
		List<Lagoa> lista = lagoaRepository.findAll();
		if (lista!=null) {
			for (int i=0;i<lista.size();i++) {
				Funcionario f = new Funcionario();
				f = funcionarioRepository.findBycpf(lista.get(i).getCpf());
				if (f !=null) {
					f.setMatricula(lista.get(i).getMatricula());
					f.setNome(lista.get(i).getNome());
					f.setNacionalidade(lista.get(i).getPais());
					f.setRg(lista.get(i).getRg());
					f.setCtps(lista.get(i).getCtps());
					f.setSerie(lista.get(i).getSerieCTPS());
					f.setFone(lista.get(i).getCelular());
					f.setDatanascimento(lista.get(i).getNascimento());
					f.setSexo(lista.get(i).getSexo());
					f.setDataadmissao(lista.get(i).getAdmissão());
					f.setPis(lista.get(i).getPis());
					Loja loja = lojaRepository.findById(3);
					f.setLoja(loja);
					Funcao funcao = funcaoRepository.getNome(lista.get(i).getCargo());
					if (funcao!=null) {
						f.setFuncao(funcao);
					}
					Setor setor = setorRepository.getSetor(lista.get(i).getSetor());
					if (setor != null) {
						f.setSetor(setor);
					}
					funcionarioRepository.save(f);
					
				}
			}
		}
		return ResponseEntity.ok("Terminou");
	}
	
	@GetMapping("/demitidos")
	public ResponseEntity<String> demitidos() {
		List<Planilha> lista = planilhaRepository.findAll();
		if (lista!=null) {
			for (int i=0;i<lista.size();i++) {
				Funcionario f = new Funcionario();
				f = funcionarioRepository.getNome(lista.get(i).getNome_funcionario());
				if (f !=null) {
					f.setSituacao("Inativo");
					funcionarioRepository.save(f);
					planilhaRepository.delete(lista.get(i));
				}
			}
		}
		return ResponseEntity.ok("Terminou");
	}
	
	
	public Loja getLoja(int idLoja) {
		return lojaRepository.findById(idLoja);
	}
	
	public Funcao getFuncao(String nome) {
		return funcaoRepository.getNome(nome);			
	}
	
	public Setor getSetor(String nome ) {
		return setorRepository.getSetor(nome);
	}
	
	
	@GetMapping("/campeche/mask")
	public ResponseEntity<String> aplicarMascaraCapeche() {
		List<Campeche> lista = campecheRepository.findAll();
		for(Campeche c :  lista) {
			if (c.getCpf().length()==11) {
				String cpf = c.getCpf();
				String novo = cpf.substring(0,3) + "." + cpf.substring(3,6) + "." + cpf.substring(6,9) + "-" + cpf.substring(9,11);
				c.setCpf(novo);
			}
			if (c.getCelular()!=null) {
				String celular = c.getCelular();
				if (celular.length()==12) {
					String novo = "(" + celular.substring(0,2) + ")" + celular.substring(3,8) + "-" + celular.substring(8,12);
					c.setCelular(novo);
				}
			}
			if (c.getPis()!=null) {
				if (c.getPis().length()==11) {
					String pis = c.getPis();
					String novo = pis.substring(0,3) + "." + pis.substring(3,8) + "." + pis.substring(8,10) + '.' + pis.substring(10,11);
					c.setPis(novo);
				}
			}
			if (c.getCbo()!=null) {
				if (c.getCbo().length()==6) {
					String cbo = c.getCbo();
					String novo = cbo.substring(0,4) + "-" + cbo.substring(4,6);
					c.setCbo(novo);
				}
			}
			campecheRepository.save(c);
		}
		return ResponseEntity.ok("Terminou");
	}
	
	@GetMapping("/lagoa/mask")
	public ResponseEntity<String> aplicarMascaraLagoa() {
		List<Lagoa> lista = lagoaRepository.findAll();
		for(Lagoa c :  lista) {
			if (c.getCpf().length()==11) {
				String cpf = c.getCpf();
				String novo = cpf.substring(0,3) + "." + cpf.substring(3,6) + "." + cpf.substring(6,9) + "-" + cpf.substring(9,11);
				c.setCpf(novo);
			}
			if (c.getCelular()!=null) {
				String celular = c.getCelular();
				if (celular.length()==12) {
					String novo = "(" + celular.substring(0,2) + ")" + celular.substring(3,8) + "-" + celular.substring(8,12);
					c.setCelular(novo);
				}
			}
			if (c.getPis()!=null) {
				if (c.getPis().length()==11) {
					String pis = c.getPis();
					String novo = pis.substring(0,3) + "." + pis.substring(3,8) + "." + pis.substring(8,10) + '.' + pis.substring(10,11);
					c.setPis(novo);
				}
			}
			if (c.getCbo()!=null) {
				if (c.getCbo().length()==6) {
					String cbo = c.getCbo();
					String novo = cbo.substring(0,4) + "-" + cbo.substring(4,6);
					c.setCbo(novo);
				}
			}
			lagoaRepository.save(c);
		}
		return ResponseEntity.ok("Terminou");
	}
	
	@GetMapping("/riotavares/mask")
	public ResponseEntity<String> aplicarMascaraRioTavares() {
		List<Riotavares> lista = riotavaresRepository.findAll();
		for(Riotavares c :  lista) {
			if (c.getCpf().length()==11) {
				String cpf = c.getCpf();
				String novo = cpf.substring(0,3) + "." + cpf.substring(3,6) + "." + cpf.substring(6,9) + "-" + cpf.substring(9,11);
				c.setCpf(novo);
			}
			if (c.getCelular()!=null) {
				String celular = c.getCelular();
				if (celular.length()==12) {
					String novo = "(" + celular.substring(0,2) + ")" + celular.substring(3,8) + "-" + celular.substring(8,12);
					c.setCelular(novo);
				}
			}
			if (c.getPis()!=null) {
				if (c.getPis().length()==11) {
					String pis = c.getPis();
					String novo = pis.substring(0,3) + "." + pis.substring(3,8) + "." + pis.substring(8,10) + '.' + pis.substring(10,11);
					c.setPis(novo);
				}
			}
			if (c.getCbo()!=null) {
				if (c.getCbo().length()==6) {
					String cbo = c.getCbo();
					String novo = cbo.substring(0,4) + "-" + cbo.substring(4,6);
					c.setCbo(novo);
				}
			}
			riotavaresRepository.save(c);
		}
		return ResponseEntity.ok("Terminou");
	}
	
	
	@GetMapping("/funcionario/mask")
	public ResponseEntity<String> aplicarMascaraFuncionario() {
		List<Funcionario> lista = funcionarioRepository.findAllNome(" ", "Ativo", "Afastado").get();
		boolean alterou = false;
		for(Funcionario c :  lista) {
			if (c.getCpf()!=null) {
				if (c.getCpf().length()==11) {
					String cpf = c.getCpf();
					String novo = cpf.substring(0,3) + "." + cpf.substring(3,6) + "." + cpf.substring(6,9) + "-" + cpf.substring(9,11);
					c.setCpf(novo);
					alterou=true;
				}
			}
			if (c.getPis()!=null) {
				if (c.getPis().length()==11) {
					String pis = c.getPis();
					String novo = pis.substring(0,3) + "." + pis.substring(3,8) + "." + pis.substring(8,10) + '.' + pis.substring(10,11);
					c.setPis(novo);
					alterou=true;
				}
			}
			if (alterou) {
				this.funcionarioRepository.save(c);
			}
		}
		return ResponseEntity.ok("Terminou");
	}
}
