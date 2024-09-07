package GestionCresdits.services;

import java.util.List;

import GestionCresdits.dtos.ClientDto;

public interface ClientService {

	public ClientDto add(ClientDto c);
	public List<ClientDto> list();
	public ClientDto update(ClientDto c);
	public List<ClientDto> delete(Long id);
	public ClientDto findById(Long id);
}
