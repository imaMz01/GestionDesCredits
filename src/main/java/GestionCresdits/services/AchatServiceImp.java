package GestionCresdits.services;

import java.util.List;


import org.springframework.stereotype.Service;

import GestionCresdits.Mappers.AchatMapper;
import GestionCresdits.dtos.AchatDto;
import GestionCresdits.entities.Achat;
import GestionCresdits.repositories.AchatRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AchatServiceImp implements AchatService{

	private final AchatRepository repo;

	@Override
	public AchatDto add(AchatDto c) {
		// TODO Auto-generated method stub
		Achat achat = AchatMapper.mapper.achatDtoToAchat(c);
		achat.setSoldeRestant(achat.getMontant()-achat.getMontantPaye());
		Achat saved = repo.save(achat);
		return AchatMapper.mapper.achatToAchatDto(saved);
	}

	@Override
	public List<AchatDto> list() {
		// TODO Auto-generated method stub
		List<Achat> achats = (List<Achat>) repo.findAll();
		return AchatMapper.mapper.achatToAchatDto(achats);
	}

	@Override
	public AchatDto update(AchatDto c) {
		// TODO Auto-generated method stub
		Achat achat = AchatMapper.mapper.achatDtoToAchat(c);
		Achat cl=repo.findById(achat.getId()).orElseThrow(()->new RuntimeException("Achat not found "));
		cl.setMontant(achat.getMontant());
		cl.setMontantPaye(achat.getMontantPaye());
		cl.setSoldeRestant(achat.getSoldeRestant());
		Achat saved = repo.save(cl);
		return AchatMapper.mapper.achatToAchatDto(saved);
	}

	@Override
	public List<AchatDto> delete(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return list();
	}

	@Override
	public AchatDto findById(Long id) {
		// TODO Auto-generated method stub
		Achat achat = repo.findById(id).orElseThrow(()->new RuntimeException("Achat not found "));
		return AchatMapper.mapper.achatToAchatDto(achat);
	}

	@Override
	public AchatDto updateMontantRestant(Long id,double m) {
		// TODO Auto-generated method stub
		Achat cl=repo.findById(id).orElseThrow(()->new RuntimeException("Achat not found "));
		cl.setMontantPaye(cl.getMontantPaye()+m);
		cl.setSoldeRestant(cl.getMontant()-cl.getMontantPaye());
		Achat saved = repo.save(cl);
		return AchatMapper.mapper.achatToAchatDto(saved);
	}

	@Override
	public AchatDto updateMontant(Long id, double m) {
		// TODO Auto-generated method stub
		Achat cl=repo.findById(id).orElseThrow(()->new RuntimeException("Achat not found "));
		cl.setMontant(cl.getMontant()+m);
		cl.setSoldeRestant(cl.getMontant()-cl.getMontantPaye());
		Achat saved = repo.save(cl);
		return AchatMapper.mapper.achatToAchatDto(saved);
	}
}
