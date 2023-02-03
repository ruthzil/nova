package br.com.ruthzil.dao;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.ruthzil.beans.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	
	public Usuario findByEmailAndSenha(String email, String senha);
	
	@Query(value="SELECT * FROM TB_USUARIO WHERE nome LIKE %:nome%", nativeQuery = true)
	public List<Usuario> listByNomeLike(String nome);
	

}
