package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Agendaexame;

public interface AgendaExameRepository extends JpaRepository<Agendaexame, Integer>{
	
	@Query("select a from Agendaexame a where a.asoagenda.idasoagenda= :idasoagenda " 
			+ " order by a.asotipo.nome ASC")
	Optional<List<Agendaexame>> findAllSAgendaExame(
	@Param("idasoagenda") int idasoagenda);		

}
