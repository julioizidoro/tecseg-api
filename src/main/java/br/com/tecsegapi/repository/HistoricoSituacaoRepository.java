package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tecsegapi.model.Historicosituacao;


public interface HistoricoSituacaoRepository extends JpaRepository<Historicosituacao, Integer>{
	
	@Query("select h from Historicosituacao h where h.funcionario.situacao='Afastado' order by h.funcionario.nome")
	Optional<List<Historicosituacao>> findAfastados();

}
