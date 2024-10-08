package GestionCresdits.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Paiement> paiements=new ArrayList<Paiement>();
	@OneToMany(mappedBy = "achat", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Achat_Produit> achatsProduit=new ArrayList<Achat_Produit>();
	public Achat(Long id, double montantPaye, Client client) {
		super();
		this.id = id;
		this.montant = 0;
		this.montantPaye = montantPaye;
		this.soldeRestant = montant - montantPaye;
		this.client = client;
	}
	
}
