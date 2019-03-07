package br.com.tecsegapi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Asocontrole;


public interface AsoControleRepository extends JpaRepository<Asocontrole, Integer>{
	
	@Query("select a from Asocontrole a where a.datavencimento>= :dataVencimentoStar and a.datavencimento<= :dataVencimentoEnd "
			+ " and a.finalizado=0 order by a.datavencimento")
	Optional<List<Asocontrole>> findAll(
	@Param("dataVencimentoStar") Date dataVencimentoStart,
	@Param("dataVencimentoEnd") Date dataVencimentoEnd);
	
	Optional<Asocontrole> findById(int Id);
	
	@Query("select a from Asocontrole a where a.finalizado=0 order by a.datavencimento")
	Optional<List<Asocontrole>> findAllFinalizadoo();
	
}
