package GestionCresdits.services;

import java.util.List;

import GestionCresdits.dtos.Achat_ProduitDto;
import GestionCresdits.entities.Achat_Produit_Id;


public interface Achat_ProduitService {

	public Achat_ProduitDto add(Achat_ProduitDto c);
	public List<Achat_ProduitDto> list();
	public Achat_ProduitDto update(Achat_ProduitDto c);
	public List<Achat_ProduitDto> delete(Achat_Produit_Id id);
	public List<Achat_ProduitDto> findByAchat(Long id);
}
