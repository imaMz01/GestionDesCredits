package GestionCresdits.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import GestionCresdits.entities.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long>{

}
