package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Funcao;

public interface FuncaoRepository extends JpaRepository<Funcao, Integer>{
	
	Optional<List<Funcao>> findByNomeContainingOrderByNome(String Nome);

}
