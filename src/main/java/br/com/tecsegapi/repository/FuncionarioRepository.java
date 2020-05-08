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
	
	@Query("select f from Funcionario f ")
	List<Funcionario> findTodos();
	
	Optional<Funcionario> findById(int Id);
	Funcionario findBycpf(String cpf);
	
	//Pesquiar Função Loja sexo
	@Query("select f from Funcionario f where f.funcao.idfuncao= :idfuncao and f.loja.idloja= :idloja and (f.situacao= :sit1 or f.situacao= :sit2)   and  f.nome like CONCAT('%', :nome, '%') and sexo <> :sexo order by f.nome")
	Optional<List<Funcionario>> findAllFuncionarioFuncaoLoja( 
	@Param("idloja") int idloja, 
	@Param("idfuncao") int idfuncao,
	@Param("nome") String nome,
	@Param("sit1") String sit1,
	@Param("sit2") String sit2,
	@Param("sexo") String sexo);
	
	
	//Consulta por Loja
	@Query("select f from Funcionario f where f.loja.idloja= :idloja and (f.situacao= :sit1 or f.situacao= :sit2) and f.nome like CONCAT('%', :nome, '%') and sexo <> :sexo order by f.nome")
	Optional<List<Funcionario>> findAllFuncionarioLoja(
	@Param("idloja") int idloja, 
	@Param("nome") String nome,
	@Param("sit1") String sit1,
	@Param("sit2") String sit2,
	@Param("sexo") String sexo);
	
	
	//Pesquiar Função
	@Query("select f from Funcionario f where f.funcao.idfuncao= :idfuncao and (f.situacao= :sit1 or f.situacao= :sit2)  and f.nome like CONCAT('%', :nome, '%') and sexo <> :sexo order by f.nome")
	Optional<List<Funcionario>> findAllFuncionarioFuncao(
	@Param("idfuncao") int idfuncao, 
	@Param("nome") String nome,
	@Param("sit1") String sit1,
	@Param("sit2") String sit2,
	@Param("sexo") String sexo);
	
	@Query("select f from Funcionario f where  f.nome = :nome ")
	Funcionario getNome(@Param("nome") String nome);
	
	//Pesquiar Loja
		@Query("select f from Funcionario f where f.loja.idloja= :idloja and sexo <> :sexo order by f.nome")
		Optional<List<Funcionario>> findAllLoja( 
		@Param("idloja") int idloja,
		@Param("sexo") String sexo);
		

		//Pesquiar LojaData
				@Query("select f from Funcionario f where f.loja.idloja= :idloja and f.datasituacao<= :datafinal  order by f.nome")
				Optional<List<Funcionario>> findAllLojaData( 
				@Param("idloja") int idloja, @Param("datafinal") Date datafinal);
		
				
	//Quantidade de funciionarios
	@Query(
			value = "select distinct count(idfuncionario) as total From funcionario where (loja_idloja= :idloja and situacao<>'Inativo' and datasituacao<= :datafinal)",
			nativeQuery = true)
	int calculaTotalFncionarios(@Param("datafinal") Date datafinal,
			@Param("idloja") int idloja);

	@Query(
			value = "SELECT * FROM funcionario WHERE ((month(datanascimento))=:mes1 and (day(datanascimento))>= :dia1 and situacao='Ativo') or ((month(datanascimento))= :mes2 and (day(datanascimento))<= :dia2 and situacao='Ativo') "
					+ "  order by month(datanascimento), day(datanascimento), nome",
			nativeQuery = true)
	Optional<List<Funcionario>> getAniversariantes(@Param("mes1") int mes1, @Param("dia1") int dia1, @Param("mes2") int mes2, @Param("dia2") int dia2);

	//Cotnrato de experiencia
	@Query("select f from Funcionario f where (f.dataexp1 >= :idata and f.dataexp1 <= :fdata) or (f.dataexp2 >= :idata and f.dataexp2 <= :fdata)  order by f.nome")
	List<Funcionario> findContrato( 
	@Param("idata") Date idata,
	@Param("fdata") Date fdata);
	
	
	//Pesquiar order nome
	@Query("select f from Funcionario f where  f.nome like CONCAT('%', :nome, '%')    "
			+ " and f.loja.nome like CONCAT('%', :loja, '%') " 
			+ " and f.funcao.nome like CONCAT('%', :funcao, '%') "
			+ " and f.setor.nome like CONCAT('%', :setor, '%') "
			+ " and f.sexo like CONCAT('%', :sexo, '%') and (f.situacao like CONCAT(:situacaoativo) or f.situacao like CONCAT(:situacaoafastado) or  "
			+ " f.situacao like CONCAT(:situacaoinativo)) "
			+ "order by f.setor.nome")
 List<Funcionario> findByOrderNome(
			@Param("nome") String nome,
			@Param("loja") String loja,
			@Param("sexo") String sexo,
			@Param("situacaoativo") String situacaoativo,
			@Param("situacaoafastado") String situacaoafastado,
        	@Param("situacaoinativo") String situacaoinativo,
			@Param("funcao") String funcao,
			@Param("setor") String setor
	);
	
	
}
