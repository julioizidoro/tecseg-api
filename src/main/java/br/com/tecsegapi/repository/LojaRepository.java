package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Loja;



public interface LojaRepository extends JpaRepository<Loja, Integer>{
	
	Optional<List<Loja>> findByNomeContainingOrderByNome(String Nome);
	
	Loja findById(int idLoja);
	
	
	

}
