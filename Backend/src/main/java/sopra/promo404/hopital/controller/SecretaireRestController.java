package sopra.promo404.hopital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.hopital.model.Secretaire;
import sopra.promo404.hopital.model.Views;
import sopra.promo404.hopital.repository.IRepoSecretaire;

@Controller
@RequestMapping("/secretaire")
public class SecretaireRestController {
	
	@Autowired
	private IRepoSecretaire repoSecretaire;
	
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewSecretaire.class)
	public List<Secretaire> list() {
		return repoSecretaire.findAll();
	}



	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewSecretaireWithFileAttente.class)
	public Secretaire detail(@PathVariable Long id) {
		return repoSecretaire.findAllSecretaireByIdWithFileAttente(id);
	}

	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewSecretaire.class)
	public Secretaire add(@RequestBody Secretaire secretaire) {
		repoSecretaire.save(secretaire);

		return secretaire;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewSecretaire.class)
	public Secretaire edit(@RequestBody Secretaire secretaire, @PathVariable Long id) {
		repoSecretaire.save(secretaire);

		return (Secretaire) repoSecretaire.findById(id).get();
	}

	

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewSecretaire.class)
	public void delete(@PathVariable Long id) {
		repoSecretaire.deleteById(id);
	}
	

}
