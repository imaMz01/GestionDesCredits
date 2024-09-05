package GestionCresdits.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import GestionCresdits.entities.Achat;
import GestionCresdits.repositories.AchatRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AchatServiceImp implements AchatService{

	private final AchatRepository repo;

	@Override
	public Achat add(Achat c) {
		// TODO Auto-generated method stub
		c.setSoldeRestant(c.getMontant()-c.getMontantPaye());
		return repo.save(c);
	}

	@Override
	public List<Achat> list() {
		// TODO Auto-generated method stub
		return (List<Achat>) repo.findAll();
	}

	@Override
	public Achat update(Achat c) {
		// TODO Auto-generated method stub
		Achat cl=repo.findById(c.getId()).orElseThrow(()->new RuntimeException("Client not found "));
		cl.setMontant(c.getMontant());
		cl.setMontantPaye(c.getMontantPaye());
		cl.setSoldeRestant(c.getSoldeRestant());
		return repo.save(cl);
	}

	@Override
	public List<Achat> delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return list();
	}

	@Override
	public Achat findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()->new RuntimeException("Achat not found "));
	}

	@Override
	public Achat updateMontantRestant(Long id,double m) {
		// TODO Auto-generated method stub
		Achat cl=repo.findById(id).orElseThrow(()->new RuntimeException("Achat not found "));
		cl.setSoldeRestant(m);
		return repo.save(cl);
	}
}
