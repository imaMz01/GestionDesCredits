package GestionCresdits.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Achat_Produit_Id {

	@Column(name = "produit_id")
	private Long produitId;
	@Column(name = "achat_Id")
	private Long achatId;
}
