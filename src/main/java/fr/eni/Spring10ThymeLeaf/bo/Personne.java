package fr.eni.Spring10ThymeLeaf.bo;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personne {
	@NotBlank(message="You shall have a name")
	private String prenom;
	@NotBlank
	private String nom;
	private Integer age;
}
