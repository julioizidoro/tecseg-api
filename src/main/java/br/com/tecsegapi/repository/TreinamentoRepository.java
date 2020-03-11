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
	@Query("select t from Treinamento t where t.data>= :data or t.situacao='Agendado' order by t.data DESC")
	Optional<List<Treinamento>> findAllPadrao(
	@Param("data") Date data);
	
	//7 Dias
	@Query("select t from Treinamento t where t.data<= :data and t.situacao='Agendado' order by t.data DESC")
	Optional<List<Treinamento>> findAllDias(
	@Param("data") Date data);
	
	
	//Perido - Situacao
	@Query("select t from Treinamento t where t.data>= :datainicio and t.data<= :datafinal and t.situacao= :situacao  order by t.data")
	Optional<List<Treinamento>> findAllPeridoSituacao(
	@Param("datainicio") Date datainicio,
	@Param("datafinal") Date datafinal,
	@Param("situacao") String situacao);
	
	//Perido
	@Query("select t from Treinamento t where t.data>= :datainicio and t.data<= :datafinal order by t.data")
	Optional<List<Treinamento>> findAllPerido(
	@Param("datainicio") Date datainicio,
	@Param("datafinal") Date datafinal);
	
	//Situacao
	@Query("select t from Treinamento t where t.situacao= :situacao and data>= :data  order by t.data")
	Optional<List<Treinamento>> findAllSituacao(
	@Param("situacao") String situacao, @Param("data") Date data);
	
	

}