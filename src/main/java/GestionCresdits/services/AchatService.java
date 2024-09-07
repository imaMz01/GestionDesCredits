package GestionCresdits.services;

import java.util.List;

import GestionCresdits.dtos.AchatDto;


public interface AchatService {

	public AchatDto add(AchatDto c);
	public List<AchatDto> list();
	public AchatDto update(AchatDto c);
	public List<AchatDto> delete(Long id);
	public AchatDto findById(Long id);
	public AchatDto updateMontantRestant(Long id,double m);
}
