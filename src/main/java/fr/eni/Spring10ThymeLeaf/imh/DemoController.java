package fr.eni.Spring10ThymeLeaf.imh;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import antlr.collections.List;
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
	
}
