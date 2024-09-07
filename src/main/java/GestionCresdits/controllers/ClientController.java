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

import GestionCresdits.dtos.ClientDto;
import GestionCresdits.services.ClientServiceImp;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Client")
public class ClientController {

	private final ClientServiceImp ser;
	
	@GetMapping("all")
	public List<ClientDto> all(){
		return ser.list();
	}
	
	@PostMapping("addClient")
	public ClientDto addClient(@RequestBody ClientDto c){
		return ser.add(c);
	}
	
	@GetMapping("findById/{id}")
	public ClientDto ClientById(@PathVariable Long id) {
		return ser.findById(id);
	}
	
	@DeleteMapping("delete/{id}")
	public List<ClientDto> delete(@PathVariable Long id){
		return ser.delete(id);
	}
	
	@PutMapping("update")
	public ClientDto update(@RequestBody ClientDto c) {
		return ser.update(c);
	}
	
}
