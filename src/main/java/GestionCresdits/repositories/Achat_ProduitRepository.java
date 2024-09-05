package GestionCresdits.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import GestionCresdits.entities.Achat_Produit;

@Repository
public interface Achat_ProduitRepository extends CrudRepository<Achat_Produit, Long>{

}
