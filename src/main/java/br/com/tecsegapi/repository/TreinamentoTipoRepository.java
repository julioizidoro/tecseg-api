package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Treinamentotipo;

public interface TreinamentoTipoRepository extends JpaRepository<Treinamentotipo, Integer>{
	
	Optional<Treinamentotipo> findById(int id);
	Optional<List<Treinamentotipo>> findByNomeContainingOrderByNome(String Nome);
	Optional<List<Treinamentotipo>> findByTipoContainingOrderByNome(String Tipo);
	List<Treinamentotipo	> findAll();

}
