package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Asotipo;



public interface AsoTipoRepository extends JpaRepository<Asotipo, Integer>{
	
	Optional<Asotipo> findById(int Id);
	Optional<List<Asotipo>> findByNomeContainingOrderByNome(String Nome);

}
