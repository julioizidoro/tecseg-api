package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Tipocomplementar;

public interface TipoComplementarRepository extends JpaRepository<Tipocomplementar, Integer>{
	
	Optional<List<Tipocomplementar>> findByDescricaoContainingOrderByDescricao(String Descricao);

}
