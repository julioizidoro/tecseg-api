package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.tecsegapi.model.Salutarfuncionario;

public interface SalutarFuncionarioRepository extends JpaRepository<Salutarfuncionario, Integer>{
	
	@Query("select s from Salutarfuncionario s where s.salutar.idsalutar= :idsalutar " 
			+ " order by s.funcionario.nome ASC")
	Optional<List<Salutarfuncionario>> findAllSalutar(
	@Param("idsalutar") int idsalutar);		
	
	
	@Query(
			value = "delete from Salutar s where s.salutar_idsalutar= :idsalutar",
			nativeQuery = true)
	void deleteSalutar(
	@Param("idsalutar") int idsalutar);		
	
	

}
