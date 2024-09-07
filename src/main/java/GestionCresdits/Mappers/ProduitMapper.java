package GestionCresdits.Mappers;

import java.util.List;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import GestionCresdits.dtos.ProduitDto;
import GestionCresdits.entities.Produit;

@Mapper
public interface ProduitMapper {

	ProduitMapper mapper=Mappers.getMapper(ProduitMapper.class);
	ProduitDto produitToProduitDto(Produit p);
	Produit produitDtoToProduit(ProduitDto p);
	List<ProduitDto> produitToProduitDto(List<Produit> p);
	List<Produit> produitDtoToProduit(List<ProduitDto> p);
}
