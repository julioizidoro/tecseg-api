package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Loja;
import br.com.tecsegapi.model.Setor;

public interface SetorRepository extends JpaRepository<Setor, Integer>{
	
	Optional<List<Loja>> findByNomeContainingOrderByNome(String Nome);
	Setor findById(int id);
	
	@Query("select s from Setor s where s.nome= :nome")
	Setor getSetor(@Param("nome") String nome);
}
