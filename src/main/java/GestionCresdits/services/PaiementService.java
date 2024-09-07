package GestionCresdits.services;

import java.util.List;

import GestionCresdits.dtos.PaiementDto;

public interface PaiementService {

	public PaiementDto add(PaiementDto c);
	public List<PaiementDto> list();
	public PaiementDto update(PaiementDto c);
	public List<PaiementDto> delete(Long id);
	public PaiementDto findById(Long id);
}
