package fr.eni.Spring10ThymeLeaf.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personne {
	private String prenom;
	private String nom;
	private Integer age;
}
