package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer>{
	
	Optional<List<Clientes>> findByTipoOrderByNome(String tipo);
	Optional<List<Clientes>> findByTipoAndNomeContainingOrEmailContainingOrderByNome(String tipo, String Nome, String Email);
	Optional<List<Clientes>> findByTipoAndNomeContainingOrderByNome(String tipo, String Nome);
	

}
