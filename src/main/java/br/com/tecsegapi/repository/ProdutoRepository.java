package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	Optional<Produto> findById(int id);
	Optional<List<Produto>> findByDescricaoContainingOrderByDescricao(String Descricao);
	List<Produto> findAll();
	
}