package GestionCresdits.Mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import GestionCresdits.dtos.ClientDto;
import GestionCresdits.entities.Client;

@Mapper
public interface ClientMapper {

	ClientMapper mapper=Mappers.getMapper(ClientMapper.class);
	ClientDto clientToClientDto(Client c);
	Client clientDtoToClient(ClientDto c);
	List<ClientDto> clientToClientDto(List<Client> c);
	List<Client> clientDtoToClient(List<ClientDto> c);
}
