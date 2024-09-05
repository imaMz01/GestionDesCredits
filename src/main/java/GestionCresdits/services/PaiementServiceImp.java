package GestionCresdits.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import GestionCresdits.entities.Achat;
import GestionCresdits.entities.Paiement;
import GestionCresdits.repositories.PaiementRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaiementServiceImp implements PaiementService{

	private final PaiementRepository repo;

	@Override
	public Paiement add(Paiement c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public List<Paiement> list() {
		// TODO Auto-generated method stub
		return (List<Paiement>) repo.findAll();
	}

	@Override
	public Paiement update(Paiement c) {
		// TODO Auto-generated method stub
		Paiement cl=repo.findById(c.getId()).orElseThrow(()->new RuntimeException("Paiement not found "));
		cl.setAchatt(c.getAchatt());
		cl.setDate(c.getDate());
		cl.setMontant(c.getMontant());
		return repo.save(cl);
	}

	@Override
	public List<Paiement> delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return list();
	}

	@Override
	public Paiement findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()->new RuntimeException("Paiement not found "));
	}
	
	
	
}
