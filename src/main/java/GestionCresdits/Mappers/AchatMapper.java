package GestionCresdits.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import GestionCresdits.dtos.AchatDto;
import GestionCresdits.entities.Achat;

@Mapper
public interface AchatMapper {

	AchatMapper mapper=Mappers.getMapper(AchatMapper.class);
	AchatDto achatToAchatDto(Achat a);
	Achat achatDtoToAchat(AchatDto a);
	List<AchatDto> achatToAchatDto(List<Achat> a);
	List<Achat> achatDtoToAchat(List<AchatDto> a);
}
