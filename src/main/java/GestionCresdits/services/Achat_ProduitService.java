package GestionCresdits.services;

import java.util.List;

import GestionCresdits.entities.Achat_Produit;


public interface Achat_ProduitService {

	public Achat_Produit add(Achat_Produit c);
	public List<Achat_Produit> list();
	public Achat_Produit update(Achat_Produit c);
	public List<Achat_Produit> delete(Long id);
	public Achat_Produit findById(Long id);
}
