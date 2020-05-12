package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Funcao;

public interface FuncaoRepository extends JpaRepository<Funcao, Integer>{
	
	Optional<List<Funcao>> findByNomeContainingOrderByNome(String Nome);
	
	@Query("select f from Funcao f where f.nome= :nome")
	Funcao getNome(@Param("nome") String nome);
	
	@Query("select f from Funcao f where f.cbo= :cbo")
	Funcao getCBO(@Param("cbo") String cbo);

}
