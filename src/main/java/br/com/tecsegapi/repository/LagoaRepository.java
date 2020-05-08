package br.com.tecsegapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.exportar.Lagoa;

public interface LagoaRepository extends JpaRepository<Lagoa, Integer>{
	
	List<Lagoa> findAll();
	
	
}