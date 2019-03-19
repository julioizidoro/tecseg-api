package br.com.tecsegapi.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	
	Optional<List<Funcionario>> findByNomeContainingOrderByNome(String Nome);
	List<Funcionario> findAll();
	Optional<Funcionario> findById(int Id);
	
	@Query("select f from Funcionario f where f.funcao.idfuncao= :idfuncao and f.loja.idloja= :idloja and (f.situacao= :sit1 or f.situacao= :sit2)   and  f.nome like CONCAT('%', :nome, '%') order by f.nome")
	Optional<List<Funcionario>> findAllFuncionarioFuncaoLoja( 
	@Param("idloja") int idloja, 
	@Param("idfuncao") int idfuncao,
	@Param("nome") String nome,
	@Param("sit1") String sit1,
	@Param("sit2") String sit2);
	
	
	//Consulta por Loja
	@Query("select f from Funcionario f where f.loja.idloja= :idloja and (f.situacao= :sit1 or f.situacao= :sit2) and f.nome like CONCAT('%', :nome, '%') order by f.nome")
	Optional<List<Funcionario>> findAllFuncionarioLoja(
	@Param("idloja") int idloja, 
	@Param("nome") String nome,
	@Param("sit1") String sit1,
	@Param("sit2") String sit2);
	
	@Query("select f from Funcionario f where f.funcao.idfuncao= :idfuncao and (f.situacao= :sit1 or f.situacao= :sit2)  and f.nome like CONCAT('%', :nome, '%') order by f.nome")
	Optional<List<Funcionario>> findAllFuncionarioFuncao(
	@Param("idfuncao") int idfuncao, 
	@Param("nome") String nome,
	@Param("sit1") String sit1,
	@Param("sit2") String sit2);
	

}
