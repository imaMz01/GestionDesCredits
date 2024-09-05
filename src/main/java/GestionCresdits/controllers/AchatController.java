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

import GestionCresdits.entities.Achat;
import GestionCresdits.services.AchatServiceImp;
import GestionCresdits.services.Achat_ProduitServiceImp;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Achat")
public class AchatController {

	private final AchatServiceImp ser;
	
	@GetMapping("all")
	private List<Achat> all(){
		return ser.list();
	}
	
	@GetMapping("findById/{id}")
	private Achat AchatById(@PathVariable Long id) {
		return ser.findById(id);
	}
	
	@PostMapping("addAchat")
	private Achat addAchat(@RequestBody Achat a) {
		return ser.add(a);
	}
	
	@DeleteMapping("delete/{id}")
	private List<Achat> delete(@PathVariable Long id){
		return ser.delete(id);
	}
	
	@PutMapping("update")
	private Achat update(@RequestBody Achat a) {
		return ser.update(a);
	}
	
	
}
