package GestionCresdits.dtos;

import java.time.LocalDateTime;


import GestionCresdits.entities.Achat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaiementDto {

	private Long id;
	private double montant;
	private LocalDateTime date;
	private Achat achatt;
	public PaiementDto(Long id, double montant) {
		super();
		this.id = id;
		this.montant = montant;
		this.date = LocalDateTime.now();
	}
}
