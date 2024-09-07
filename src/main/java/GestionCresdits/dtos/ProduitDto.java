package GestionCresdits.dtos;

import java.util.ArrayList;
import java.util.List;

import GestionCresdits.entities.Achat_Produit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProduitDto {

	private Long id;
	private String nom;
	private double prix;
	private List<Achat_Produit> achatProduits=new ArrayList<Achat_Produit>();
}
