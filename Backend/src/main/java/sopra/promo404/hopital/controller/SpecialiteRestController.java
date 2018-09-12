package sopra.promo404.hopital.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

import sopra.promo404.hopital.model.Specialite;
import sopra.promo404.hopital.model.Views;
import sopra.promo404.hopital.repository.IRepoSpecialite;


@RestController
@RequestMapping("/specialite")
public class SpecialiteRestController {
	@Autowired
	private IRepoSpecialite specialiteRepo;

	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewSpecialite.class)
	public List<Specialite> list() {
		return specialiteRepo.findAllSpecialite();
	}


	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewSpecialite.class)
	public Specialite add(@RequestBody Specialite specialite) {
		specialiteRepo.save(specialite);

		return specialite;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewSpecialite.class)
	public Specialite edit(@RequestBody Specialite specialite, @PathVariable Long id) {
		specialiteRepo.save(specialite);

		return (Specialite) specialiteRepo.findById(id).get();
	}


	@DeleteMapping("/{id}")
	@JsonView(Views.ViewSpecialite.class)
	public void delete(@PathVariable Long id) {
		specialiteRepo.deleteById(id);
	}

}
