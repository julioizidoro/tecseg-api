package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Treinamentoparticipante;

public interface TreinamentoParticipanteRepository extends JpaRepository<Treinamentoparticipante, Integer>{
	
	@Query("select t from Treinamentoparticipante t where t.treinamento.idtreinamento= :id order by t.funcionario.nome")
	Optional<List<Treinamentoparticipante>> findAllPadrao(
	@Param("id") int id);
	
	@Query("select t from Treinamentoparticipante t where t.treinamento.idtreinamento= :idtreinamento and t.funcionario.idfuncionario= :idfuncionario ")
	Treinamentoparticipante findParticipante(
	@Param("idtreinamento") int idtreinamento, @Param("idfuncionario") int idfuncionario);
	
	
}
