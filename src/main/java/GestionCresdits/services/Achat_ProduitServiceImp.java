package GestionCresdits.services;

import java.util.List;

import org.springframework.stereotype.Service;

import GestionCresdits.Mappers.AchatMapper;
import GestionCresdits.Mappers.Achat_ProduitMapper;
import GestionCresdits.Mappers.ProduitMapper;
import GestionCresdits.dtos.Achat_ProduitDto;
import GestionCresdits.entities.Achat;
import GestionCresdits.entities.Achat_Produit;
import GestionCresdits.entities.Achat_Produit_Id;
import GestionCresdits.entities.Produit;
import GestionCresdits.repositories.Achat_ProduitRepository;
import GestionCresdits.repositories.ProduitRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Achat_ProduitServiceImp implements Achat_ProduitService{

	private final Achat_ProduitRepository repo;
	private final ProduitRepository serp;
	private final AchatServiceImp sera;
	
	@Override
	public Achat_ProduitDto add(Achat_ProduitDto c) {
		// TODO Auto-generated method stub
//		Produit p=serp.findById(c.getId().getProduitId());
//		Achat a=sera.findById(c.getId().getAchatId());
		Achat_Produit achatProduit = Achat_ProduitMapper.mapper.achatProduitDtoToAchatProduit(c);
		Achat_Produit_Id id=new Achat_Produit_Id(achatProduit.getProduit().getId(), achatProduit.getAchat().getId());
		achatProduit.setId(id);
		Achat_Produit saved = repo.save(achatProduit);
		sera.updateMontant(saved.getAchat().getId(), saved.getQuantite()*saved.getProduit().getPrix());
		return Achat_ProduitMapper.mapper.achatProduitToAchatProduitDto(saved);
	}

	@Override
	public List<Achat_ProduitDto> list() {
		// TODO Auto-generated method stub
		List<Achat_Produit> achatsProduits = (List<Achat_Produit>) repo.findAll();
		return Achat_ProduitMapper.mapper.achatProduitToAchatProduitDto(achatsProduits);
	}

	@Override
	public Achat_ProduitDto update(Achat_ProduitDto c) {
		// TODO Auto-generated method stub
		Achat_Produit achatProduit = Achat_ProduitMapper.mapper.achatProduitDtoToAchatProduit(c);
		Achat_Produit cl = repo.findById(achatProduit.getId()).orElseThrow(() -> new RuntimeException("Achat_Produit not found"));
		Achat a = AchatMapper.mapper.achatDtoToAchat(sera.findById(cl.getId().getAchatId()));
		Produit p= serp.findById(cl.getId().getProduitId()).get();
		cl.setAchat(a);
		cl.setProduit(p);
		cl.setQuantite(c.getQuantite());
		Achat_Produit saved = repo.save(cl);
		return Achat_ProduitMapper.mapper.achatProduitToAchatProduitDto(saved);
	}
	
	public Achat_ProduitDto findById(Achat_Produit_Id id) {
		Achat_Produit achatProduit = repo.findById(id).get();
		return Achat_ProduitMapper.mapper.achatProduitToAchatProduitDto(achatProduit);
	}

	@Override
	public List<Achat_ProduitDto> delete(Achat_Produit_Id id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return list();
	}

	@Override
	public List<Achat_ProduitDto> findByAchat(Long id) {
		// TODO Auto-generated method stub
		List<Achat_Produit> achatsProduits = repo.findByAchatId(id);
		return Achat_ProduitMapper.mapper.achatProduitToAchatProduitDto(achatsProduits);
	}

	
	
}
