package GestionCresdits.services;

import java.util.List;

import GestionCresdits.entities.Produit;

public interface ProduitService {

	public Produit add(Produit c);
	public List<Produit> list();
	public Produit update(Produit c);
	public List<Produit> delete(Long id);
	public Produit findById(Long id);
}
