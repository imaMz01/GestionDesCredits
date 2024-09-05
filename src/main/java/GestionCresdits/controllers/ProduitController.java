package GestionCresdits.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GestionCresdits.entities.Produit;
import GestionCresdits.services.ProduitServiceImp;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("Produit")
public class ProduitController {

	private final ProduitServiceImp ser;
	@GetMapping("all")
	public List<Produit> all(){
		return ser.list();
	}
	
	@PostMapping("addProduit")
	public Produit addProduit(@RequestBody Produit c){
		return ser.add(c);
	}
	
	@GetMapping("findById/{id}")
	public Produit ClientById(@PathVariable Long id) {
		return ser.findById(id);
	}
	
	@DeleteMapping("delete/{id}")
	public List<Produit> delete(@PathVariable Long id){
		return ser.delete(id);
	}
	
	@PutMapping("update")
	public Produit update(@RequestBody Produit c) {
		return ser.update(c);
	}
	
}
