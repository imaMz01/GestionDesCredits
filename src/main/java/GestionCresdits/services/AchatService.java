package GestionCresdits.services;

import java.util.List;

import GestionCresdits.entities.Achat;


public interface AchatService {

	public Achat add(Achat c);
	public List<Achat> list();
	public Achat update(Achat c);
	public List<Achat> delete(Long id);
	public Achat findById(Long id);
	public Achat updateMontantRestant(Long id,double m);
}
