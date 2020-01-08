package br.com.tecsegapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Numeroasos;

public interface NumeroAsosRepository  extends JpaRepository<Numeroasos, Integer>{
	
	Optional<Numeroasos> findById(int Id);
}
