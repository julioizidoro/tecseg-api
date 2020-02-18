package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Contasusuario;

public interface ContasUsuarioRepository extends JpaRepository<Contasusuario, Integer>{
	
	@Query("select c from Contasusuario c where c.contas.idcontas= :id  order by c.data DESC")
	List<Optional<Contasusuario>> findConta(@Param("id") int id);		

}
