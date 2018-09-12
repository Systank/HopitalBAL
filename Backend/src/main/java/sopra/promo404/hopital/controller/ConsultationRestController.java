package sopra.promo404.hopital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.hopital.model.Consultation;
import sopra.promo404.hopital.model.Views;
import sopra.promo404.hopital.repository.IRepoConsultation;

public class ConsultationRestController {

	@Autowired
	private IRepoConsultation consultationRepo;
	
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewConsultation.class)
	public List<Consultation> list() {
		return consultationRepo.findAllConsultation();
	}

	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewConsultationWithSpecialite.class)
	public Consultation detail(@PathVariable Long id) {
		return consultationRepo.findConsultationByIdWithSpecialite(id);
	}

	
	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewSecretaire.class)
	public Consultation add(@RequestBody Consultation consultation) {
		consultationRepo.save(consultation);

		return consultation;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewSecretaire.class)
	public Consultation edit(@RequestBody Consultation consultation, @PathVariable Long id) {
		consultationRepo.save(consultation);

		return (Consultation) consultationRepo.findById(id).get();
	}

	

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewSecretaire.class)
	public void delete(@PathVariable Long id) {
		consultationRepo.deleteById(id);
	}
}
