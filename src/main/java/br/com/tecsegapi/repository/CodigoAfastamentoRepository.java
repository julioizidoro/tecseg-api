package br.com.tecsegapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Codigoafastamento;


public interface CodigoAfastamentoRepository extends JpaRepository<Codigoafastamento, Integer>{
	
	Optional<Codigoafastamento> findById(int id);
	

}
