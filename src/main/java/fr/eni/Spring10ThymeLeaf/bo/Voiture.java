package fr.eni.Spring10ThymeLeaf.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Voiture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVoiture;
	@NotBlank(message = "Obligatoire")
	private String immatriculation;
	@NotBlank
	private String marque;
	private String modele;
	
	public Voiture(@NotBlank(message = "Obligatoire") String immatriculation, @NotBlank String marque, String modele) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
	}

	@Override
	public String toString() {
		return "Voiture [immatriculation=" + immatriculation + ", marque=" + marque + ", modele=" + modele + "]";
	}
	
	
	
}
