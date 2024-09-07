package GestionCresdits.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import GestionCresdits.entities.Achat_Produit;
import GestionCresdits.entities.Achat_Produit_Id;

@Repository
public interface Achat_ProduitRepository extends CrudRepository<Achat_Produit, Achat_Produit_Id>{

	List<Achat_Produit> findByAchatId(Long id);
}
