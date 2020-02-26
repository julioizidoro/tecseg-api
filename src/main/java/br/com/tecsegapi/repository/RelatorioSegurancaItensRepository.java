package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Relatoriosegurancaitens;

public interface RelatorioSegurancaItensRepository extends JpaRepository<Relatoriosegurancaitens, Integer>{
	
	
	
	Optional<Relatoriosegurancaitens> findById(int id);
	
	
	@Query("select r from Relatoriosegurancaitens r where r.relatorioseguranca = :id order by r.setor.nome")
	Optional<List<Relatoriosegurancaitens>> findAllRelatoriosItens(@Param("id") int id);
	
	
}