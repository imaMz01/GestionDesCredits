package GestionCresdits.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import GestionCresdits.entities.Client;
import GestionCresdits.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImp implements ClientService{

	private final ClientRepository repo;

	@Override
	public Client add(Client c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public List<Client> list() {
		// TODO Auto-generated method stub
		return (List<Client>) repo.findAll();
	}

	@Override
	public Client update(Client c) {
		// TODO Auto-generated method stub
		Client cl=repo.findById(c.getId()).orElseThrow(()->new RuntimeException("Client not found "));
		cl.setNom(c.getNom());
		cl.setAdresse(c.getAdresse());
		cl.setPrenom(c.getPrenom());
		cl.setTel(c.getTel());
		
		return repo.save(cl);
	}

	@Override
	public List<Client> delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return list();
	}

	@Override
	public Client findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()->new RuntimeException("Client not found "));
	}
	
}
