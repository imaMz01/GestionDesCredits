package GestionCresdits.services;

import java.util.List;


import org.springframework.stereotype.Service;

import GestionCresdits.Mappers.ProduitMapper;
import GestionCresdits.dtos.ProduitDto;
import GestionCresdits.entities.Produit;
import GestionCresdits.repositories.ProduitRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProduitServiceImp implements ProduitService{

	private final ProduitRepository repo;
//	private final ProduitMapper mapper;

	@Override
	public ProduitDto add(ProduitDto c) {
		// TODO Auto-generated method stub
		Produit p= ProduitMapper.mapper.produitDtoToProduit(c);
		Produit saved=repo.save(p);
		return ProduitMapper.mapper.produitToProduitDto(saved);
	}

	@Override
	public List<ProduitDto> list() {
		// TODO Auto-generated method stub
		List<Produit> produits= (List<Produit>) repo.findAll();
		return ProduitMapper.mapper.produitToProduitDto(produits);
		 
	}

	@Override
	public ProduitDto update(ProduitDto c) {
		// TODO Auto-generated method stub
		Produit p = ProduitMapper.mapper.produitDtoToProduit(c);
		Produit cl=repo.findById(p.getId()).orElseThrow(()->new RuntimeException("Product not found "));
		cl.setNom(p.getNom());
		cl.setPrix(p.getPrix());
		Produit saved = repo.save(cl);
		return ProduitMapper.mapper.produitToProduitDto(saved);
	}

	@Override
	public List<ProduitDto> delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return list();
	}

	@Override
	public ProduitDto findById(Long id) {
		// TODO Auto-generated method stub
		Produit p= repo.findById(id).orElseThrow(()->new RuntimeException("Product not found "));
		return ProduitMapper.mapper.produitToProduitDto(p);
	}
}
