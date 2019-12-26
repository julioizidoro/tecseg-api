package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Salutar;

public interface SalutarRepository extends JpaRepository<Salutar, Integer>{
	
	Optional<Salutar> findById(int id);
	List<Salutar> findAll();
	
	@Query("select s from Salutar s where s.loja.idloja= :idloja " 
			+ " order by s.dataemissao ASC")
	Optional<List<Salutar>> findAllLoja(
	@Param("idloja") int idloja);		

}

