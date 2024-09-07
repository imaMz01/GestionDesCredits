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

import GestionCresdits.dtos.AchatDto;
import GestionCresdits.services.AchatServiceImp;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Achat")
public class AchatController {

	private final AchatServiceImp ser;
	
	@GetMapping("all")
	private List<AchatDto> all(){
		return ser.list();
	}
	
	@GetMapping("findById/{id}")
	private AchatDto AchatById(@PathVariable Long id) {
		return ser.findById(id);
	}
	
	@PostMapping("addAchat")
	private AchatDto addAchat(@RequestBody AchatDto a) {
		return ser.add(a);
	}
	
	@DeleteMapping("delete/{id}")
	private List<AchatDto> delete(@PathVariable Long id){
		return ser.delete(id);
	}
	
	@PutMapping("update")
	private AchatDto update(@RequestBody AchatDto a) {
		return ser.update(a);
	}
	
	
}
