package br.com.tecsegapi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Epicontrole;

public interface EpiControleRepository extends JpaRepository<Epicontrole, Integer>{
	
	Optional<Epicontrole> findById(int id);
	
	@Query("Select e from Epicontrole e where e.dataentrega>= :data or e.situacao= 'uso' order by e.epi.estoque.produto.descricao")
	Optional<List<Epicontrole>> findEpiControleData(@Param("data") Date data);
	
	@Query("Select e from Epicontrole e where e.idlocal= :idlocal and e.tipolocal= :tipolocal order by e.epi.estoque.produto.descricao")
	Optional<List<Epicontrole>> findEpiControleLocal(@Param("idlocal") int idlocal, @Param("tipolocal") String tipolocal);
	
	//Query("Select e from Epicontrole e where idepicontrole>0")
	//Optional<List<Epicontrole>> findSql(@Param("sql") String sql);
	
}