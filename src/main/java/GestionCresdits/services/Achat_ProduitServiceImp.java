package GestionCresdits.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import GestionCresdits.entities.Achat;
import GestionCresdits.entities.Achat_Produit;
import GestionCresdits.entities.Achat_Produit_Id;
import GestionCresdits.entities.Produit;
import GestionCresdits.repositories.Achat_ProduitRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Achat_ProduitServiceImp implements Achat_ProduitService{

	private final Achat_ProduitRepository repo;
	private final ProduitServiceImp serp;
	private final AchatServiceImp sera;

	@Override
	public Achat_Produit add(Achat_Produit c) {
		// TODO Auto-generated method stub
//		Produit p=serp.findById(c.getId().getProduitId());
//		Achat a=sera.findById(c.getId().getAchatId());
//		Achat_Produit_Id id=new Achat_Produit_Id(c.getId().getProduitId(), c.getId().getAchatId());
//		c.setId(id);
		return repo.save(c);
	}

	@Override
	public List<Achat_Produit> list() {
		// TODO Auto-generated method stub
		return (List<Achat_Produit>) repo.findAll();
	}

	@Override
	public Achat_Produit update(Achat_Produit c) {
		// TODO Auto-generated method stub
		Achat_Produit old=new Achat_Produit();
//		Optional<Achat_Produit> cl=repo.findById(c.getId());
//		if(cl.isPresent()) {
//			old=cl.get();
//			old.setAchat(c.getAchat());
//			old.setProduit(c.getProduit());
//			old.setQuantite(c.getQuantite());
//		}
		return repo.save(old);
	}

	@Override
	public List<Achat_Produit> delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return list();
	}

	@Override
	public Achat_Produit findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
	
	
}
