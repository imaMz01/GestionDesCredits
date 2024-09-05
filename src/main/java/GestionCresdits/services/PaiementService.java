package GestionCresdits.services;

import java.util.List;

import GestionCresdits.entities.Paiement;

public interface PaiementService {

	public Paiement add(Paiement c);
	public List<Paiement> list();
	public Paiement update(Paiement c);
	public List<Paiement> delete(Long id);
	public Paiement findById(Long id);
}
