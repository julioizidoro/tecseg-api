package br.com.tecsegapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Clinicaexame;

public interface ClinicaExameRepository extends JpaRepository<Clinicaexame, Integer>{
	
	Optional<Clinicaexame> findById(int id);
}
