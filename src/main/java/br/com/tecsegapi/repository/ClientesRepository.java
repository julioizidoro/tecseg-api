package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer>{
	
	Optional<List<Clientes>> findByTipoOrderByNome(String tipo);
	Optional<List<Clientes>> findByTipoAndNomeContainingOrEmailContainingOrderByNome(String tipo, String Nome, String Email);
	Optional<List<Clientes>> findByTipoAndNomeContainingOrderByNome(String tipo, String Nome);
	
	@Query(
			value = "SELECT * FROM clientes WHERE ((month(datanascimento))=:mes1 and (day(datanascimento))>= :dia1) or ((month(datanascimento))= :mes2 and (day(datanascimento))<= :dia2) order by month(datanascimento), day(datanascimento), nome ",
			nativeQuery = true)
	Optional<List<Clientes>> getAniversariantes(@Param("mes1") int mes1, @Param("dia1") int dia1, @Param("mes2") int mes2, @Param("dia2") int dia2);

}

 
