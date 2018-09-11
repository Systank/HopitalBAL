package sopra.promo404.hopital.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sopra.promo404.hopital.model.Secretaire;
import sopra.promo404.hopital.repository.IRepoSecretaire;

@Controller
@RequestMapping("/secretaire")
public class SecretaireRestController {
	
	@Autowired
	private IRepoSecretaire repoSecretaire;
	
	
	@GetMapping("")
	@ResponseBody
	public List<Secretaire> list() {
		return repoSecretaire.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Secretaire> detail(@PathVariable Long id) {
		return repoSecretaire.findById(id);
	}

	@PostMapping("")
	@ResponseBody
	public Secretaire add(@RequestBody Secretaire secretaire) {
		repoSecretaire.save(secretaire);

		return secretaire;
	}

	@PutMapping("/{id}")
	@ResponseBody
	public Secretaire edit(@RequestBody Secretaire secretaire, @PathVariable Long id) {
		repoSecretaire.save(secretaire);

		return (Secretaire) repoSecretaire.findById(id).get();
	}

	

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repoSecretaire.deleteById(id);
	}
	

}
