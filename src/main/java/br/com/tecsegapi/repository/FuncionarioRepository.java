package br.com.tecsegapi.repository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	
	@Query("select f from Funcionario f where (f.situacao= :sit1 or f.situacao= :sit2)   and  f.nome like CONCAT('%', :nome, '%') order by f.nome")
	Optional<List<Funcionario>> findAllNome(@Param("nome") String nome,
			@Param("sit1") String sit1, @Param("sit2") String sit2);
	
	Optional<Funcionario> findById(int Id);
	Optional<Funcionario> findBycpf(String cpf);
	
	//Pesquiar Função Loja
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
	
	
	//Pesquiar Função
	@Query("select f from Funcionario f where f.funcao.idfuncao= :idfuncao and (f.situacao= :sit1 or f.situacao= :sit2)  and f.nome like CONCAT('%', :nome, '%') order by f.nome")
	Optional<List<Funcionario>> findAllFuncionarioFuncao(
	@Param("idfuncao") int idfuncao, 
	@Param("nome") String nome,
	@Param("sit1") String sit1,
	@Param("sit2") String sit2);
	
	@Query("select f from Funcionario f where  f.nome = :nome ")
	Funcionario getNome(@Param("nome") String nome);
	
	//Pesquiar Loja
		@Query("select f from Funcionario f where f.loja.idloja= :idloja  order by f.nome")
		Optional<List<Funcionario>> findAllLoja( 
		@Param("idloja") int idloja);
		

		//Pesquiar LojaData
				@Query("select f from Funcionario f where f.loja.idloja= :idloja and f.datasituacao>= :datainicial and f.datasituacao<= :datafinal  order by f.nome")
				Optional<List<Funcionario>> findAllLojaData( 
				@Param("idloja") int idloja, @Param("datainicial") Date datainicial, @Param("datafinal") Date datafinal);
		
				
	//Quantidade de funciionarios
	@Query(
			value = "select distinct count(idfuncionario) as total From funcionario where (loja_idloja= :idloja and situacao<>'Inativo' and datasituacao<= :datafinal)",
			nativeQuery = true)
	int calculaTotalFncionarios(@Param("datafinal") Date datafinal,
			@Param("idloja") int idloja);

	

}
