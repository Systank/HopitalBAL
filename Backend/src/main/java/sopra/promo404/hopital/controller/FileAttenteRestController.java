package sopra.promo404.hopital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import sopra.promo404.hopital.model.FileAttente;
import sopra.promo404.hopital.model.Views;
import sopra.promo404.hopital.repository.IRepoFileAttente;



@Controller
@RequestMapping("/fileAttente")
public class FileAttenteRestController {
	
	@Autowired
	private IRepoFileAttente repoFileAttente;
	
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewFileAttente.class)
	public List<FileAttente> list() {
		return repoFileAttente.findAllFileAttente();
	}

	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewFileAttenteWithMedecin.class)
	public FileAttente detail(@PathVariable Long id) {
		return repoFileAttente.findFileAttenteByIdWithPatient(id);
	}

	
	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewSecretaire.class)
	public FileAttente add(@RequestBody FileAttente fileAttente) {
		repoFileAttente.save(fileAttente);

		return fileAttente;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewSecretaire.class)
	public FileAttente edit(@RequestBody FileAttente fileAttente, @PathVariable Long id) {
		repoFileAttente.save(fileAttente);

		return (FileAttente) repoFileAttente.findById(id).get();
	}

	

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewSecretaire.class)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		repoFileAttente.deleteById(id);	
		
		return ResponseEntity.noContent().build();
	}

}
