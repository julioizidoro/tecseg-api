package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Epi;

public interface EpiRepository extends JpaRepository<Epi, Integer>{
	
	Optional<Epi> findById(int id);
	
	@Query("Select e from Epi e where e.estoque.produto.descricao like CONCAT('%', :descricao, '%') order by e.estoque.produto.descricao")
	Optional<List<Epi>> findEpiDescricao(@Param("descricao") String descricao);
	
	@Query("Select e from Epi e where e.estoque.produto.idproduto = :idproduto order by e.estoque.produto.descricao")
	Optional<Epi> findProdutoId(@Param("idproduto") int idproduto);
	
	List<Epi> findAll();
	
}
