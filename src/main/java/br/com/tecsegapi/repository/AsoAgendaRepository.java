package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tecsegapi.model.Asoagenda;



public interface AsoAgendaRepository extends JpaRepository<Asoagenda, Integer>{
	
	@Query("select a from Asoagenda a where (a.situacao='Agendador' or a.situacao='Agendado') order by a.dataexame")
	Optional<List<Asoagenda>> findAllAsoAgenda();
	
	Optional<Asoagenda> findById(int Id);
}
