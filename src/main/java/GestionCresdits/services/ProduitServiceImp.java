package GestionCresdits.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import GestionCresdits.entities.Produit;
import GestionCresdits.repositories.ProduitRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProduitServiceImp implements ProduitService{

	private final ProduitRepository repo;

	@Override
	public Produit add(Produit c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public List<Produit> list() {
		// TODO Auto-generated method stub
		return (List<Produit>) repo.findAll();
	}

	@Override
	public Produit update(Produit c) {
		// TODO Auto-generated method stub
		Produit old=new Produit();
		Optional<Produit> cl=repo.findById(c.getId());
		if(cl.isPresent()) {
			old=cl.get();
			old.setNom(c.getNom());
			old.setPrix(c.getPrix());
		}
		return repo.save(old);
	}

	@Override
	public List<Produit> delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return list();
	}

	@Override
	public Produit findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()->new RuntimeException("Product not found "));
	}
}
