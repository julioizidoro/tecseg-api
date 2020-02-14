package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Produtogrupo;

public interface ProdutoGrupoRepository extends JpaRepository<Produtogrupo, Integer>{
	
	Optional<Produtogrupo> findById(int id);
	Optional<List<Produtogrupo>> findByDescricaoContainingOrderByDescricao(String Descricao);
	List<Produtogrupo> findAll();
	
}
