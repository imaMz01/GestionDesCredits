package GestionCresdits.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import GestionCresdits.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{

}
