package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Treinamentoparticipante;

public interface TreinamentoParticipanteRepository extends JpaRepository<Treinamentoparticipante, Integer>{
	
	@Query("select t from Treinamentoparticipante t where t.treinamento= :id order by t.funcionario.nome")
	Optional<List<Treinamentoparticipante>> findAllPadrao(
	@Param("id") int id);
	

}
