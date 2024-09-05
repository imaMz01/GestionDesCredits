package GestionCresdits.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Achat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double montant;
	private double montantPaye;
	private double soldeRestant;
	@ManyToOne
	private Client client;
	@OneToMany(mappedBy = "achatt")
	private List<Paiement> paiements=new ArrayList<Paiement>();
	@OneToMany(mappedBy = "achat")
	private List<Achat_Produit> achatsProduit=new ArrayList<Achat_Produit>();
}
