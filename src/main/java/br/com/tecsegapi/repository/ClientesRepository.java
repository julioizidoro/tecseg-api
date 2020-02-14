package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer>{
	
	Optional<List<Clientes>> findByTipojuridicoOrderByNome(String Tipojuridico);
	Optional<List<Clientes>> findByTipojuridicoAndNomeContainingOrEmailContainingOrderByNome(String tipojuridico, String Nome, String Email);
	Optional<List<Clientes>> findByTipojuridicoAndNomeContainingOrderByNome(String tipojuridico, String Nome);
	

}
