package br.com.tecsegapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Clinica;

public interface ClinicaRepository extends JpaRepository<Clinica, Integer>{
	
	Optional<Clinica> findById(int Id);
}
