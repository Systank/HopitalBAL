package sopra.promo404.hopital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.hopital.model.Patient;
import sopra.promo404.hopital.repository.IRepoPatient;

@RestController
@RequestMapping("/patient")
public class PatientRestController {

	@Autowired
	private IRepoPatient patientRepo;

	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewMatiere.class)
	public List<Patient> list() {
		return patientRepo.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	@JsonView()
	public Patient detail(@PathVariable Long id) {
		return patientRepo.findByIdWithFormateurs(id);
	}

	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewMatiere.class)
	public Patient add(@Valid @RequestBody Patient patient, BindingResult result) {
		if (result.hasErrors()) {
			throw new PatientValidationException("Nom oublié");
		}

		patientRepo.save(patient);

		return patient;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewMatiere.class)
	public Patient edit(@RequestBody Patient patient, @PathVariable Long id) {
		patientRepo.save(patient);

		return patientRepo.findById(id).get();
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewMatiere.class)
	public void delete(@PathVariable Long id) {
		patientRepo.deleteById(id);
	}

}
