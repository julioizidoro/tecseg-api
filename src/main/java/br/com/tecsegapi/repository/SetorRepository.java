package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Loja;
import br.com.tecsegapi.model.Setor;

public interface SetorRepository extends JpaRepository<Setor, Integer>{
	
	Optional<List<Loja>> findByNomeContainingOrderByNome(String Nome);
}
