package fr.eni.Spring10ThymeLeaf.imh;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.Spring10ThymeLeaf.bo.Personne;
import fr.eni.Spring10ThymeLeaf.bo.Voiture;
import fr.eni.Spring10ThymeLeaf.dal.VoitureDao;

@Controller
@RequestMapping("/ihm/voiture")
public class VoitureController {
@Autowired
private VoitureDao voitureDao;

	@GetMapping("/hello")
	public String display(Model model) {
		model.addAttribute("message", "Hello there!");
		return "hello";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
//		ArrayList<Voiture> liste = new ArrayList<>();
//		liste.add(new Voiture("ABC-123-DEF", "Renault", "Captur")); 
//		liste.add(new Voiture("GHI-123-JKL", "Renault", "Zoe")); 
//		liste.add(new Voiture("MNO-123-PQR", "Tesla", "Model3")); 
		Voiture captur = (new Voiture("ABC-123-DEF", "Renault", "Captur")); 
		Voiture zoe = (new Voiture("GHI-123-JKL", "Renault", "Zoe")); 
		Voiture model3 = (new Voiture("MNO-123-PQR", "Tesla", "Model3")); 
	
		voitureDao.save(captur);
		voitureDao.save(zoe);
		voitureDao.save(model3);
		ArrayList<Voiture> listeVoiture = (ArrayList<Voiture>) voitureDao.findAll();

		model.addAttribute("listeVoiture", listeVoiture);
		return "listeVoiture";
	}
	
	/**
	 * Initialisation du formulaire
	 * @param personne : il crée une un objet de type Personne qui est directement<br>
	 * mis en attribut du modele. Cette attribut s'appelle personne (le nom de la classe avec une minuscule
	 * @param model : le modele ATTENTION TOUJOURS LE METTRE EN DERNIER ARGUMENT
	 * @return le nom de la vue (le fichier html qui se trouve dans template)
	 */
	@GetMapping("/form")
	public String form(Voiture voiture, Model model) {
		return "formVoiture";
	}
	
	/**
	 * Validation du formulaire
	 * @param personne la personne qui a été crée par le formulaire qui est @Validee
	 * @param errors le container d'erreurs qui est alimenté par les validations
	 * @param model le model (TOUJOURS DERNIER ARGUMENT)
	 * @return vers le form (la vue form.html) ou rerection vers l'url /IHM/hello
	 */
	@PostMapping("/form")
	public String validForm(@Valid Voiture voiture, BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "formVoiture";
		}
		voitureDao.save(voiture);
		System.out.println(voiture);
		return "redirect:/ihm/voiture/list";
	}
}
