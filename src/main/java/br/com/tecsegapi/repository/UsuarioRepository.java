package br.com.tecsegapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecsegapi.model.Usuario;





public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByLoginAndSenhaAndSituacao(String Login, String Senha, boolean Situacao);
	Optional<List<Usuario>> findByNomeContainingOrderByNome(String Nome);
	Optional<List<Usuario>> findBySituacaoOrderByNome(boolean Situacao);
	
	
}
