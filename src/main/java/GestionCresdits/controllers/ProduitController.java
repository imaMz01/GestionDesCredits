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

import GestionCresdits.dtos.ProduitDto;
import GestionCresdits.services.ProduitServiceImp;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("Produit")
public class ProduitController {

	private final ProduitServiceImp ser;
	@GetMapping("all")
	public List<ProduitDto> all(){
		return ser.list();
	}
	
	@PostMapping("addProduit")
	public ProduitDto addProduit(@RequestBody ProduitDto c){
		return ser.add(c);
	}
	
	@GetMapping("findById/{id}")
	public ProduitDto ClientById(@PathVariable Long id) {
		return ser.findById(id);
	}
	
	@DeleteMapping("delete/{id}")
	public List<ProduitDto> delete(@PathVariable Long id){
		return ser.delete(id);
	}
	
	@PutMapping("update")
	public ProduitDto update(@RequestBody ProduitDto c) {
		return ser.update(c);
	}
	
}
