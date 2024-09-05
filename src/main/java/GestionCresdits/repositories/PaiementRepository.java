package GestionCresdits.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import GestionCresdits.entities.Paiement;

@Repository
public interface PaiementRepository extends CrudRepository<Paiement, Long>{

}
