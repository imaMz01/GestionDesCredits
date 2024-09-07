package GestionCresdits.services;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.stereotype.Service;

import GestionCresdits.Mappers.AchatMapper;
import GestionCresdits.Mappers.PaiementMapper;
import GestionCresdits.dtos.AchatDto;
import GestionCresdits.dtos.PaiementDto;
import GestionCresdits.entities.Paiement;
import GestionCresdits.repositories.PaiementRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaiementServiceImp implements PaiementService{

	private final PaiementRepository repo;
	private final AchatServiceImp sera;

	@Override
	public PaiementDto add(PaiementDto c) {
		// TODO Auto-generated method stub
		Paiement p = PaiementMapper.mapper.paiementDtoToPaiement(c);
		if(p.getAchatt().getSoldeRestant() == 0) {
			throw new  RuntimeException("Votre crédit est déjà payé");
		}
		System.out.println(LocalDateTime.now());
		p.setDate(LocalDateTime.now());
		System.out.println(p.getDate());
		AchatDto achat =sera.updateMontantRestant(p.getAchatt().getId(), p.getMontant());
		Paiement saved= repo.save(p);
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
