package br.com.tecsegapi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Asocontrole;


public interface AsoControleRepository extends JpaRepository<Asocontrole, Integer>{
	
	
	
	Optional<Asocontrole> findById(int Id);
	
	@Query("select a from Asocontrole a where a.finalizado=0 and  a.datavencimento<= :data order by a.datavencimento")
	Optional<List<Asocontrole>> findAll(
	@Param("data") Date data);
	
	//Somente Data Vencimento
	@Query("select a from Asocontrole a where a.datavencimento>= :dataVencimentoStar and a.datavencimento<= :dataVencimentoEnd "
			+ " and a.finalizado=0 and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.datavencimento")
	Optional<List<Asocontrole>> findAllDataVencimento(
	@Param("dataVencimentoStar") Date dataVencimentoStart,
	@Param("dataVencimentoEnd") Date dataVencimentoEnd,
	@Param("nome") String nome);
	
	//Data Vencimento e funcao
		@Query("select a from Asocontrole a where a.datavencimento>= :dataVencimentoStar and a.datavencimento<= :dataVencimentoEnd "
				+ " and a.finalizado=0 and a.funcionario.funcao.idfuncao= :idfuncao and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.datavencimento")
		Optional<List<Asocontrole>> findAllDataVencimentoFuncao(
		@Param("dataVencimentoStar") Date dataVencimentoStart,
		@Param("dataVencimentoEnd") Date dataVencimentoEnd,
		@Param("nome") String nome,
		@Param("idfuncao") int idfuncao);
		
		//Data Vencimento e loja
		@Query("select a from Asocontrole a where a.datavencimento>= :dataVencimentoStar and a.datavencimento<= :dataVencimentoEnd "
				+ " and a.finalizado=0 and a.funcionario.loja.idloja= :idloja and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.datavencimento")
		Optional<List<Asocontrole>> findAllDataVencimentoLoja(
		@Param("dataVencimentoStar") Date dataVencimentoStart,
		@Param("dataVencimentoEnd") Date dataVencimentoEnd,
		@Param("nome") String nome,
		@Param("idloja") int idloja);
		
		//Data Vencimento e Tipo
		@Query("select a from Asocontrole a where a.datavencimento>= :dataVencimentoStar and a.datavencimento<= :dataVencimentoEnd "
				+ " and a.finalizado=0 and a.asotipo.idasotipo= :idasotipo and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.datavencimento")
		Optional<List<Asocontrole>> findAllDataVencimentoTipo(
		@Param("dataVencimentoStar") Date dataVencimentoStart,
		@Param("dataVencimentoEnd") Date dataVencimentoEnd,
		@Param("nome") String nome,
		@Param("idasotipo") int idtipo);

		//Funcao e Tipo
		@Query("select a from Asocontrole a where a.funcionario.funcao.idfuncao= :idfuncao " 
				+ " and a.finalizado=0 and a.asotipo.idasotipo= :idasotipo and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.datavencimento")
		Optional<List<Asocontrole>> findAllFuncaoTipo(
		@Param("idfuncao") int idfuncao,
		@Param("nome") String nome,
		@Param("idasotipo") int idtipo);
		
		//Funcao e Loja
		@Query("select a from Asocontrole a where a.funcionario.funcao.idfuncao= :idfuncao " 
				+ " and a.finalizado=0 and a.funcionario.loja.idloja= :idloja and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.datavencimento")
		Optional<List<Asocontrole>> findAllFuncaoLoja(
		@Param("idfuncao") int idfuncao,
		@Param("nome") String nome,
		@Param("idloja") int idloja);
		
		//Loja e Tipo
		@Query("select a from Asocontrole a where a.funcionario.loja.idloja= :idloja " 
				+ " and a.finalizado=0 and a.asotipo.idasotipo= :idasotipo and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.datavencimento")
		Optional<List<Asocontrole>> findAllLojaTipo(
		@Param("idasotipo") int idasotipo,
		@Param("nome") String nome,
		@Param("idloja") int idloja);		
	
		
		//Somnte Loja
		@Query("select a from Asocontrole a where a.funcionario.loja.idloja= :idloja " 
				+ " and a.finalizado=0 and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.datavencimento")
		Optional<List<Asocontrole>> findAllLoja(
		@Param("idloja") int idloja,
		@Param("nome") String nome);		
		
		//Somnte fucao
		@Query("select a from Asocontrole a where a.funcionario.funcao.idfuncao= :idfuncao " 
				+ " and a.finalizado=0 and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.datavencimento")
		Optional<List<Asocontrole>> findAllFuncao(
		@Param("idfuncao") int idfuncao,
		@Param("nome") String nome);	
		
		//Somnte Tipo
		@Query("select a from Asocontrole a where a.asotipo.idasotipo= :idasotipo " 
				+ " and a.finalizado=0 and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.datavencimento")
		Optional<List<Asocontrole>> findAllTipo(
		@Param("idasotipo") int idasotipo,
		@Param("nome") String nome);	
		
		@Query("select a from Asocontrole a where a.finalizado=0 and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.datavencimento")
		Optional<List<Asocontrole>> findAllNome(
		@Param("nome") String nome);	
		
		
		//todos os parametros
		@Query("select a from Asocontrole a where a.datavencimento>= :dataVencimentoStar and a.datavencimento<= :dataVencimentoEnd "
				+ " and a.finalizado=0 and a.funcionario.loja.idloja= :idloja and "
				+ "a.funcionario.funcao.idfuncao= :idfuncao  and "
				+ "a.asotipo.idasotipo= :idtipo and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.datavencimento")
		Optional<List<Asocontrole>> findAll(
		@Param("dataVencimentoStar") Date dataVencimentoStart,
		@Param("dataVencimentoEnd") Date dataVencimentoEnd,
		@Param("nome") String nome,
		@Param("idloja") int idloja,
		@Param("idfuncao") int idfuncao,
		@Param("idtipo") int idtipo);
		
		//Baixa anterior 
		@Query("select a from Asocontrole a where a.asotipo.tipo='aso' " 
				+ " and a.finalizado=0 and a.funcionario.idfuncionario= :idfuncionario ")
		Optional<Asocontrole> findLast(
		@Param("idfuncionario") int idfuncionario);	
	
		//Consulta pelo id do funcionario
		@Query("select a from Asocontrole a where a.funcionario.idfuncionario= :idfuncionario order by a.dataexame")
		Optional<List<Asocontrole>> findFuncionario(
		@Param("idfuncionario") int idfuncionario);

	
}
