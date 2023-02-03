package br.com.ruthzil.controller;


import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.ruthzil.beans.Usuario;
import br.com.ruthzil.dao.UsuarioDAO;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> listarUsuarios(@RequestParam(required=false) String nome, 
			@RequestParam(required=false) String email) {
		
		System.out.println(nome);
		System.out.println(email);
		
		if(nome == null || nome.isEmpty()) {
			List<Usuario> coll = (List<Usuario>)dao.findAll();
			
			if(coll.size() == 0) {
				return ResponseEntity.status(404).build();
			}
			
			return ResponseEntity.ok(coll);	
		}
		else {
			List<Usuario> coll = (List<Usuario>)dao.listByNomeLike(nome);
			
			if(coll.size() == 0) {
				return ResponseEntity.status(404).build();
			}
			
			return ResponseEntity.ok(coll);
		}
		
	}
	
	
	@GetMapping("/usuario/{codigo}")
	public ResponseEntity<Usuario> obterUsuario(@PathVariable int codigo) {
		
		Usuario result = dao.findById(codigo).orElse(null);
		
		if(result == null) {
			return ResponseEntity.status(404).build();
		}
		
		return ResponseEntity.ok(result);
	}
	

	@PostMapping("/usuario")
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
		
		String senha = usuario.getSenha();
		usuario.setSenha(TesteMD5.calcMD5(senha));
		
		try {
			dao.save(usuario);
			return ResponseEntity.ok(usuario);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> efetuarLogin(@RequestBody Usuario usuario) {
		
		String senha = usuario.getSenha();
		usuario.setSenha(TesteMD5.calcMD5(senha));
		
		Usuario result = dao.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		
		if(result == null) {
			return ResponseEntity.status(404).build();
		}
		
		return ResponseEntity.ok(result);
	
	}
	
	
	@DeleteMapping("/usuario/{codigo}")
	public ResponseEntity<Usuario> removerUsuario(@PathVariable int codigo){
		try {
			Usuario result = dao.findById(codigo).orElse(null);
			
			if(result == null) {
				return ResponseEntity.status(404).build();
			}
			
			dao.delete(result);
			
			return ResponseEntity.ok(result);
			
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}
	
	
	
}
