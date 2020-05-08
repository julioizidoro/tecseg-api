package br.com.tecsegapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.exportar.Campeche;

public interface CampecheRepository extends JpaRepository<Campeche, Integer>{
	
	List<Campeche> findAll();

}
