package GestionCresdits.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Achat_Produit{

	@EmbeddedId
	private Achat_Produit_Id id;
	private int quantite;
	@MapsId("produit_id")
	@ManyToOne
	@JoinColumn(
	            name="produit_id",
	            referencedColumnName = "id"
	 )
	private Produit produit;
	@MapsId("achat_id")
	@ManyToOne
	@JoinColumn(
            name="achat_id",
            referencedColumnName = "id"
	)
	private Achat achat;
}
