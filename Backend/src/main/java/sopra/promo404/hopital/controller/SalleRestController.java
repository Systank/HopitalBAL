package sopra.promo404.hopital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.hopital.exception.PatientValidationException;
import sopra.promo404.hopital.model.Salle;
import sopra.promo404.hopital.model.Views;
import sopra.promo404.hopital.repository.IRepoSalle;

@RestController
@RequestMapping("/salle")
public class SalleRestController {
	
	@Autowired
	private IRepoSalle salleRepo;
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewSalle.class)
	public List<Salle> list() {
		return salleRepo.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	@JsonView()
	public Salle detail(@PathVariable Long id) {
		return salleRepo.findByIdWithMedecin(id);
	}

	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewSalle.class)
	public Salle add(@Valid @RequestBody Salle salle, BindingResult result) {
		if (result.hasErrors()) {
			throw new PatientValidationException("Nom oublié");
		}

		salleRepo.save(salle);

		return salle;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewSalle.class)
	public Salle edit(@RequestBody Salle salle, @PathVariable Long id) {
		salleRepo.save(salle);

		return salleRepo.findById(id).get();
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewSalle.class)
	public void delete(@PathVariable Long id) {
		salleRepo.deleteById(id);
	}
}
