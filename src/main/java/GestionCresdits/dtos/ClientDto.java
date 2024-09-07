package GestionCresdits.dtos;

import java.util.ArrayList;
import java.util.List;

import GestionCresdits.entities.Achat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

	private Long id;
	private String nom;
	private String prenom;
	private String tel;
	private String adresse;
	private List<Achat> achats=new ArrayList<Achat>();
}
