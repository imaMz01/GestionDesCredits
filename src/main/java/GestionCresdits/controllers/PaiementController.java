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

import GestionCresdits.dtos.PaiementDto;
import GestionCresdits.services.PaiementServiceImp;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("Paiement")
public class PaiementController {

	private final PaiementServiceImp ser;
	
	@GetMapping("all")
	public List<PaiementDto> all(){
		return ser.list();
	}
	
	@GetMapping("PaiementById/{id}")
	public PaiementDto paiementById(@PathVariable Long id) {
		return ser.findById(id);
	}
	
	@PostMapping("addPaiement")
	public PaiementDto addPaiement(@RequestBody PaiementDto p) {
		return ser.add(p);
	}
	
	@PutMapping("update")
	public PaiementDto updatePaiement(@RequestBody PaiementDto p) {
		return ser.update(p);
	}
	
	@DeleteMapping("delete/{id}")
	public List<PaiementDto> delete(@PathVariable Long id){
		return ser.delete(id);
	}
}
