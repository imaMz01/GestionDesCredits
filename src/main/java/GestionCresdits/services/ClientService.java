package GestionCresdits.services;

import java.util.List;

import GestionCresdits.entities.Client;

public interface ClientService {

	public Client add(Client c);
	public List<Client> list();
	public Client update(Client c);
	public List<Client> delete(Long id);
	public Client findById(Long id);
}
