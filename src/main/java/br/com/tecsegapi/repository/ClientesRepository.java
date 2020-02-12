package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer>{
	
	Optional<Clientes> findById(int id);
	Optional<List<Clientes>> findByNomeContainingOrderByNome(String Nome);
	List<Clientes> findAll();
	

}
