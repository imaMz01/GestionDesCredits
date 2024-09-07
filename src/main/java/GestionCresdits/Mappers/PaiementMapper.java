package GestionCresdits.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import GestionCresdits.dtos.PaiementDto;
import GestionCresdits.entities.Paiement;

@Mapper
public interface PaiementMapper {

	PaiementMapper mapper=Mappers.getMapper(PaiementMapper.class);
	PaiementDto paiementToPaiementDto(Paiement p);
	Paiement paiementDtoToPaiement(PaiementDto p);
	List<PaiementDto> paiementToPaiementDto(List<Paiement> p);
	List<Paiement> paiementDtoToPaiement(List<PaiementDto> p);
}
