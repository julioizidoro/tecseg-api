package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Asoagenda;


public interface AsoAgendaRepository extends JpaRepository<Asoagenda, Integer>{
	
	@Query("select a from Asoagenda a where (a.situacao='Agendar' or a.situacao='Agendado') order by a.dataexame")
	Optional<List<Asoagenda>> findAllAsoAgenda();
	
	Optional<Asoagenda> findById(int Id);
	
	// Somente Loja
	@Query("select a from Asoagenda a where a.funcionario.loja.idloja= :idloja "
			+ " and a.funcionario.nome like CONCAT('%', :nome, '%')  and (a.situacao='Agendar' or a.situacao='Agendado') order by a.dataexame")
	Optional<List<Asoagenda>> findAllLoja(@Param("idloja") int idloja, @Param("nome") String nome);
	
	// Somente situação
	@Query("select a from Asoagenda a where a.situacao= :situacao "
			+ " and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.dataexame")
		Optional<List<Asoagenda>> findAllSituacao(@Param("situacao") String situacao, @Param("nome") String nome);
	
	// Somente nome
		@Query("select a from Asoagenda a where a.funcionario.nome like CONCAT('%', :nome, '%') and (a.situacao='Agendar' or a.situacao='Agendado') order by a.dataexame")
			Optional<List<Asoagenda>> findAllNome(@Param("nome") String nome);
		
		// tudo
		@Query("select a from Asoagenda a where a.funcionario.loja.idloja= :idloja and a.situacao= :situacao"
				+ " and a.funcionario.nome like CONCAT('%', :nome, '%') order by a.dataexame")
		Optional<List<Asoagenda>> findAll(@Param("idloja") int idloja, @Param("nome") String nome, @Param("situacao") String situacao);
	
	

}
