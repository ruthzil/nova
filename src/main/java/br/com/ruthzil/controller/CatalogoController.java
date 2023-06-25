package br.com.ruthzil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ruthzil.beans.Catalogo;
import br.com.ruthzil.dao.CatalogoDAO;

@RestController
@CrossOrigin("*")
public class CatalogoController {

	@Autowired
	private CatalogoDAO dao;

	@GetMapping("/catalogo")
	public ResponseEntity<List<Catalogo>> listarCatalogo() {

		

	
			List<Catalogo> coll = (List<Catalogo>) dao.findAll();
			return ResponseEntity.ok(coll);
			
			
		
		

	}

	@PostMapping("/catalogo")
	public ResponseEntity<Catalogo> criarCatalogo(@RequestBody Catalogo catalogo) {
		
		System.out.println(catalogo);
		

		try {
			dao.save(catalogo);
			return ResponseEntity.ok(catalogo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}

	@DeleteMapping("/catalogo/{codigo}")
	public ResponseEntity<Catalogo> removerCatalogo(@PathVariable int codigo) {
		try {
			Catalogo result = dao.findById(codigo).orElse(null);

			if (result == null) {
				return ResponseEntity.status(404).build();
			}

			dao.delete(result);

			return ResponseEntity.ok(result);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}

}