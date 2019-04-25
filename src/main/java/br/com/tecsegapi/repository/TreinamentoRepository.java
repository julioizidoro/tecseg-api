package br.com.tecsegapi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Treinamento;

public interface TreinamentoRepository extends JpaRepository<Treinamento, Integer>{
	
	//Padrão
	@Query("select t from Treinamento t where t.data>= :data or t.situacao='Agendado' order by t.data")
	Optional<List<Treinamento>> findAllPadrao(
	@Param("data") Date data);
	
	//Loja - Periodo - Situacao
	@Query("select t from Treinamento t where t.data>= :datainicio and t.data<= :datafinal and t.situacao= :situacao and t.loja.idloja= :idloja order by t.data")
	Optional<List<Treinamento>> findAll(
	@Param("datainicio") Date datainicio,
	@Param("datafinal") Date datafinal,
	@Param("situacao") String situacao, 
	@Param("idloja") int idLoja);
	
	//Perido - Situacao
	@Query("select t from Treinamento t where t.data>= :datainicio and t.data<= :datafinal and t.situacao= :situacao  order by t.data")
	Optional<List<Treinamento>> findAllPeridoSituacao(
	@Param("datainicio") Date datainicio,
	@Param("datafinal") Date datafinal,
	@Param("situacao") String situacao);
	
	//Perido Loja
	@Query("select t from Treinamento t where t.data>= :datainicio and t.data<= :datafinal  and t.loja.idloja= :idloja order by t.data")
	Optional<List<Treinamento>> findAllPeridoLoja(
	@Param("datainicio") Date datainicio,
	@Param("datafinal") Date datafinal,
	@Param("idloja") int idLoja);
	
	//Perido
	@Query("select t from Treinamento t where t.data>= :datainicio and t.data<= :datafinal order by t.data")
	Optional<List<Treinamento>> findAllPerido(
	@Param("datainicio") Date datainicio,
	@Param("datafinal") Date datafinal);
	
	//Situacao - Loja
	@Query("select t from Treinamento t where t.situacao= :situacao and t.loja.idloja= :idloja order by t.data")
	Optional<List<Treinamento>> findAll(
	@Param("situacao") String situacao, 
	@Param("idloja") int idLoja);
	
	//Loja
	@Query("select t from Treinamento t where t.loja.idloja= :idloja order by t.data")
	Optional<List<Treinamento>> findAllLoja(
	@Param("idloja") int idLoja);
	
	//Situacao
	@Query("select t from Treinamento t where t.situacao= :situacao  order by t.data")
	Optional<List<Treinamento>> findAllSituacao(
	@Param("situacao") String situacao);
	
	

}