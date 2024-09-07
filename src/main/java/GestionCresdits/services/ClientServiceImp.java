package GestionCresdits.services;

import java.util.List;


import org.springframework.stereotype.Service;

import GestionCresdits.Mappers.ClientMapper;
import GestionCresdits.dtos.ClientDto;
import GestionCresdits.entities.Client;
import GestionCresdits.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImp implements ClientService{

	private final ClientRepository repo;

	@Override
	public ClientDto add(ClientDto c) {
		// TODO Auto-generated method stub
		Client client=ClientMapper.mapper.clientDtoToClient(c);
		Client saved = repo.save(client);
		return ClientMapper.mapper.clientToClientDto(saved);
	}

	@Override
	public List<ClientDto> list() {
		// TODO Auto-generated method stub
		List<Client> clients = (List<Client>) repo.findAll();
		return ClientMapper.mapper.clientToClientDto(clients);
	}

	@Override
	public ClientDto update(ClientDto c) {
		// TODO Auto-generated method stub
		Client client = ClientMapper.mapper.clientDtoToClient(c);
		Client cl=repo.findById(client.getId()).orElseThrow(()->new RuntimeException("Client not found "));
		cl.setNom(client.getNom());
		cl.setAdresse(client.getAdresse());
		cl.setPrenom(client.getPrenom());
		cl.setTel(client.getTel());
		Client saved = repo.save(cl);
		return ClientMapper.mapper.clientToClientDto(saved);
	}

	@Override
	public List<ClientDto> delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return list();
	}

	@Override
	public ClientDto findById(Long id) {
		// TODO Auto-generated method stub
		Client client = repo.findById(id).orElseThrow(()->new RuntimeException("Client not found "));
		return ClientMapper.mapper.clientToClientDto(client);
	}
	
}
