package br.com.tecsegapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.exportar.Riotavares;

public interface RiotavaresRepository extends JpaRepository<Riotavares, Integer>{
	
	List<Riotavares> findAll();

}
