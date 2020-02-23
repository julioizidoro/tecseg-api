package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Clinicapagto;

public interface ClinicaPagtoRepository extends JpaRepository<Clinicapagto, Integer>{
	
	Optional<Clinicapagto> findById(int id);
	List<Clinicapagto> findAll();
	
	@Query("select c from Clinicapagto c where c.mesano= :mesano and c.loja.idloja= :idloja")
	Clinicapagto getClinicaPagto(@Param("mesano") String mesano, @Param("idloja") int idloja);
	
}