package GestionCresdits.services;

import java.util.List;


import GestionCresdits.dtos.ProduitDto;

public interface ProduitService {

	public ProduitDto add(ProduitDto c);
	public List<ProduitDto> list();
	public ProduitDto update(ProduitDto c);
	public List<ProduitDto> delete(Long id);
	public ProduitDto findById(Long id);
}
