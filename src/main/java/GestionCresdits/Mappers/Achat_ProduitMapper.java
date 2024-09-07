package GestionCresdits.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import GestionCresdits.dtos.Achat_ProduitDto;
import GestionCresdits.entities.Achat_Produit;

@Mapper
public interface Achat_ProduitMapper {

	Achat_ProduitMapper mapper=Mappers.getMapper(Achat_ProduitMapper.class);
	Achat_ProduitDto achatProduitToAchatProduitDto(Achat_Produit a);
	Achat_Produit achatProduitDtoToAchatProduit(Achat_ProduitDto a);
	List<Achat_ProduitDto> achatProduitToAchatProduitDto(List<Achat_Produit> a);
	List<Achat_Produit> achatProduitDtoToAchatProduit(List<Achat_ProduitDto> a);
}
