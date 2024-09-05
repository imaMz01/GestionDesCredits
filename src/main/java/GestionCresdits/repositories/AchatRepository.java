package GestionCresdits.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import GestionCresdits.entities.Achat;

@Repository
public interface AchatRepository extends CrudRepository<Achat, Long>{

}
