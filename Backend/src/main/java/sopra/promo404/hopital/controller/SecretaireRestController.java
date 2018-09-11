package sopra.promo404.hopital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sopra.promo404.hopital.model.Secretaire;
import sopra.promo404.hopital.repository.IRepoSecretaire;

@Controller
@RequestMapping("/secretaire")
public class SecretaireRestController {
	
	@Autowired
	private IRepoSecretaire repoSecretaire;
	
	
	@GetMapping({"","/list"})
	public String list (Model model) {
		List<Secretaire>secretaire = repoSecretaire.findAll();
		
		return null;
		
	}
	
	
	public String add (Model model) {
		return null;
		
	}
	

}
