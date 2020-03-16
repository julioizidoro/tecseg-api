package br.com.tecsegapi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Treinamentoparticipante;

public interface TreinamentoParticipanteRepository extends JpaRepository<Treinamentoparticipante, Integer>{
	
	@Query("select t from Treinamentoparticipante t where t.treinamento.idtreinamento= :id order by t.funcionario.nome")
	Optional<List<Treinamentoparticipante>> findAllPadrao(
	@Param("id") int id);
	
	@Query("select t from Treinamentoparticipante t where t.treinamento.idtreinamento= :idtreinamento and t.funcionario.idfuncionario= :idfuncionario ")
	Treinamentoparticipante findParticipante(
	@Param("idtreinamento") int idtreinamento, @Param("idfuncionario") int idfuncionario);
	
	//Todos
	@Query("select t from Treinamentoparticipante t where t.treinamento.datavencimento<= :data and t.funcionario.situacao='Ativo' "
			+ " and t.compareceu=1 order by t.treinamento.datavencimento")
	Optional<List<Treinamentoparticipante>> findVencidos(
	@Param("data") Date data);
	
	
	//Loja
	@Query("select t from Treinamentoparticipante t where t.treinamento.datavencimento<= :data and t.funcionario.situacao='Ativo' "
			+ " and t.compareceu=1 and t.funcionario.loja.idloja= :idloja order by t.treinamento.datavencimento")
	Optional<List<Treinamentoparticipante>> findVencidosLoja(
	@Param("data") Date data,
	@Param("idloja") int idloja);
	
	
	//Funcção
	@Query("select t from Treinamentoparticipante t where t.treinamento.datavencimento<= :data and t.funcionario.situacao='Ativo' "
			+ " and t.compareceu=1 and t.funcionario.funcao.idfuncao= :idfuncao order by t.treinamento.datavencimento")
	Optional<List<Treinamentoparticipante>> findVencidosFuncao(
	@Param("data") Date data,
	@Param("idfuncao") int idfuncao);
	
	
	//Funcao Loja
	//Funcção
	@Query("select t from Treinamentoparticipante t where t.treinamento.datavencimento<= :data and t.funcionario.situacao='Ativo' "
			+ " and t.compareceu=1 and t.funcionario.loja.idloja= :idloja and t.funcionario.funcao.idfuncao= :idfuncao order by t.treinamento.datavencimento")
	Optional<List<Treinamentoparticipante>> findVencidosFuncaoLoja(
	@Param("data") Date data,
	@Param("idloja") int idloja,
	@Param("idfuncao") int idfuncao);
}
