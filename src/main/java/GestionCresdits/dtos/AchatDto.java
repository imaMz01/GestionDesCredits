package GestionCresdits.dtos;


import GestionCresdits.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AchatDto {

	private Long id;
	private double montant;
	private double montantPaye;
	private double soldeRestant;
	private Client client;
}
