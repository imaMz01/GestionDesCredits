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

import GestionCresdits.dtos.Achat_ProduitDto;
import GestionCresdits.entities.Achat_Produit_Id;
import GestionCresdits.services.Achat_ProduitServiceImp;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/AchatProduit")
public class AchatProduitController {

	private final Achat_ProduitServiceImp ser;
	
	@GetMapping("all")
	public List<Achat_ProduitDto> all(){
		return ser.list();
	}
	
	@GetMapping("achatProduitByIdAchat/{id}")
	public List<Achat_ProduitDto> achatProduitByIdAchat(@PathVariable Long id) {
		return ser.findByAchat(id);
	}
	
	@GetMapping("achatProduitById/{ida}/{ip}")
	public Achat_ProduitDto achatProduitByIdAchat(@PathVariable Long ida,@PathVariable Long ip) {
		return ser.findById(new Achat_Produit_Id(ip, ida));
	}
	
	@PostMapping("addAchatproduit")
	public Achat_ProduitDto add(@RequestBody Achat_ProduitDto a) {
		return ser.add(a);
	}
	
	@PutMapping("update")
	public Achat_ProduitDto update(@RequestBody Achat_ProduitDto a) {

//		System.out.println(a.toString());
		return ser.update(a);
	}
	
	@DeleteMapping("delete/{id}")
	public List<Achat_ProduitDto> delete(@PathVariable Achat_Produit_Id id) {
		return ser.delete(id);
	}
}
