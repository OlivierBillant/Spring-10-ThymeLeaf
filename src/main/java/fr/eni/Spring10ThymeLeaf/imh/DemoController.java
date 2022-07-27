package fr.eni.Spring10ThymeLeaf.imh;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.Spring10ThymeLeaf.bo.Personne;

@Controller
@RequestMapping("/ihm")
public class DemoController {

	@GetMapping("/hello")
	public String display(Model model) {
		model.addAttribute("message", "Bonjour toi!");
		return "hello";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		ArrayList<Personne> liste = new ArrayList<>();
		liste.add(new Personne("Clement", "Duval", 34)); 
		liste.add(new Personne("Antoine", "Guillou", 32)); 
		liste.add(new Personne("Phileas", "Peron", 14)); 
		model.addAttribute("list", liste);
		return "list";
	}
	
	/**
	 * Initialisation du formulaire
	 * @param personne : il crée une un objet de type Personne qui est directement<br>
	 * mis en attribut du modele. Cette attribut s'appelle personne (le nom de la classe avec une minuscule
	 * @param model : le modele ATTENTION TOUJOURS LE METTRE EN DERNIER ARGUMENT
	 * @return le nom de la vue (le fichier html qui se trouve dans template)
	 */
	@GetMapping("/form")
	public String form(Personne personne, Model model) {
		return "form";
	}
	
	/**
	 * Validation du formulaire
	 * @param personne la personne qui a été crée par le formulaire qui est @Validee
	 * @param errors le container d'erreurs qui est alimenté par les validations
	 * @param model le model (TOUJOURS DERNIER ARGUMENT)
	 * @return vers le form (la vue form.html) ou rerection vers l'url /IHM/hello
	 */
	@PostMapping("/form")
	public String validForm(@Valid Personne personne, BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "form";
		}
		System.out.println(personne);
		return "redirect:/ihm/hello";
	}
}
