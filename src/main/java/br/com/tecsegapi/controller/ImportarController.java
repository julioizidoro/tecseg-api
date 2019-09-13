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
import br.com.tecsegapi.repository.FuncaoRepository;
import br.com.tecsegapi.repository.FuncionarioRepository;
import br.com.tecsegapi.repository.LojaRepository;
import br.com.tecsegapi.repository.PlanilhaRepository;
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
	
	
	
	@SuppressWarnings("null")
	@GetMapping("")
	public ResponseEntity<String> importar() {
		List<Planilha> lista = planilhaRepository.findAll();
		if (lista!=null) {
			for (int i=0;i<lista.size();i++) {
				Funcionario f = new Funcionario();
				f = funcionarioRepository.getNome(lista.get(i).getNome_funcionario());
				System.out.print(lista.get(i).getNome_funcionario());
				if (f !=null) {
					f.setCpf(lista.get(i).getCpf());
					f.setDataadmissao(lista.get(i).getDataadmissao());
					if (lista.get(i).getSituacao().contentEquals("S")) {
						f.setSituacao("Ativo");
					}else if (lista.get(i).getSituacao().contentEquals("N")) {
						f.setSituacao("Inativo");
					}else f.setSituacao("Afastado");
					f.setRg(lista.get(i).getRg());
					f.setUf(lista.get(i).getUfrg());
					f.setDatanascimento(lista.get(i).getNascimento());
					f.setPis(lista.get(i).getPis());
					f.setCtps(lista.get(i).getCtps());
					f.setSexo(lista.get(i).getSexo());
					Setor setor = getSetor(lista.get(i).getSetor());
					if (setor == null) {
						setor = new Setor();
						setor.setNome(lista.get(i).getSetor());
						setor = setorRepository.save(setor);
					}
					f.setSetor(setor);
					funcionarioRepository.save(f);
					planilhaRepository.delete(lista.get(i));
					
				}else {
					f = new Funcionario();
					f.setNome(lista.get(i).getNome_funcionario());
					f.setRg(lista.get(i).getRg());
					f.setUf(lista.get(i).getUfrg());
					f.setDatanascimento(lista.get(i).getNascimento());
					f.setPis(lista.get(i).getPis());
					f.setCtps(lista.get(i).getCtps());
					f.setSexo(lista.get(i).getSexo());
					if (lista.get(i).getSituacao().contentEquals("S")) {
						f.setSituacao("Ativo");
					}else if (lista.get(i).getSituacao().contentEquals("N")) {
						f.setSituacao("Inativo");
					}else f.setSituacao("Afastado");
					f.setLoja(getLoja(1));
					f.setFuncao(getFuncao(lista.get(i).getCargo()));
					Setor setor = getSetor(lista.get(i).getSetor());
					if (setor == null) {
						setor = new Setor();
						setor.setNome(lista.get(i).getSetor());
						setor = setorRepository.save(setor);
					}
					f.setSetor(setor);
					funcionarioRepository.save(f);
					planilhaRepository.delete(lista.get(i));
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
}
