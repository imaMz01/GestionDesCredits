package GestionCresdits.dtos;


import GestionCresdits.entities.Achat;
import GestionCresdits.entities.Achat_Produit_Id;
import GestionCresdits.entities.Produit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Achat_ProduitDto {

	private Achat_Produit_Id id;
	private int quantite;
	private Produit produit;
	private Achat achat;
}
