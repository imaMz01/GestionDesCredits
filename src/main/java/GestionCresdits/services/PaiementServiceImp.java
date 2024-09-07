package GestionCresdits.services;

import java.util.List;


import org.springframework.stereotype.Service;

import GestionCresdits.Mappers.PaiementMapper;
import GestionCresdits.dtos.PaiementDto;
import GestionCresdits.entities.Paiement;
import GestionCresdits.repositories.PaiementRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaiementServiceImp implements PaiementService{

	private final PaiementRepository repo;

	@Override
	public PaiementDto add(PaiementDto c) {
		// TODO Auto-generated method stub
		Paiement saved= repo.save(PaiementMapper.mapper.paiementDtoToPaiement(c));
		return PaiementMapper.mapper.paiementToPaiementDto(saved);
	}

	@Override
	public List<PaiementDto> list() {
		// TODO Auto-generated method stub
		List<Paiement> paiement = (List<Paiement>) repo.findAll();
		return PaiementMapper.mapper.paiementToPaiementDto(paiement);
	}

	@Override
	public PaiementDto update(PaiementDto c) {
		// TODO Auto-generated method stub
		Paiement p= PaiementMapper.mapper.paiementDtoToPaiement(c);
		Paiement cl=repo.findById(p.getId()).orElseThrow(()->new RuntimeException("Paiement not found "));
		cl.setAchatt(p.getAchatt());
		cl.setDate(p.getDate());
		cl.setMontant(p.getMontant());
		Paiement saved = repo.save(cl);
		return PaiementMapper.mapper.paiementToPaiementDto(saved);
	}

	@Override
	public List<PaiementDto> delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return list();
	}

	@Override
	public PaiementDto findById(Long id) {
		// TODO Auto-generated method stub
		Paiement p = repo.findById(id).orElseThrow(()->new RuntimeException("Paiement not found "));
		return PaiementMapper.mapper.paiementToPaiementDto(p);
	}
	
	
	
}
