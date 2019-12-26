package br.com.tecsegapi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Salutar;

public interface SalutarRepository extends JpaRepository<Salutar, Integer>{
	
	Optional<Salutar> findById(int id);
	
	@Query("select s from Salutar s where s.datainicial>= :dataincial and s.dataemissao<= :datafinal " 
			+ " order by s.dataemissao ASC")
	Optional<List<Salutar>> listar(
		@Param("datainicial") Date datainicial, @Param("datafinal") Date datafinal);
	
	@Query("select s from Salutar s where s.loja.idloja= :idloja and s.dataemissao>= :datainicial and s.dataemissao<= :datafinal" 
			+ " order by s.dataemissao ASC")
	Optional<List<Salutar>> findAllLoja(
		@Param("idloja") int idloja, @Param("datainicial") Date datainicial, @Param("datafinal") Date datafinal);		

}

