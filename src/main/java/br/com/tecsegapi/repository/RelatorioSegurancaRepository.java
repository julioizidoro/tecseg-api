package br.com.tecsegapi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Relatorioseguranca;

public interface RelatorioSegurancaRepository extends JpaRepository<Relatorioseguranca, Integer>{
	
	
	
	Optional<Relatorioseguranca> findById(int id);
	
	
	@Query("select r from Relatorioseguranca r where a.data> :data order by a.data")
	Optional<List<Relatorioseguranca>> findAllRelatorios(@Param("data") Date data);
	List<Relatorioseguranca> findAll();
	
	
}