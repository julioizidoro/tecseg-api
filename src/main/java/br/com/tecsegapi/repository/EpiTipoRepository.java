package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Epitipo;

public interface EpiTipoRepository extends JpaRepository<Epitipo, Integer>{
	
	Optional<Epitipo> findById(int id);
	Optional<List<Epitipo>> findByDescricaoContainingOrderByDescricao(String Descricao);
	List<Epitipo> findAll();
	
}
