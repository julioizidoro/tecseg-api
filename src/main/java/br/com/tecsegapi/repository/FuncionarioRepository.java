package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	
	Optional<List<Funcionario>> findByNomeContainingOrderByNome(String Nome);
	Optional<Funcionario> findById(int Id);
}
