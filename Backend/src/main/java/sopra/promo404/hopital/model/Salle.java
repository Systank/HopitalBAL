package sopra.promo404.hopital.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Salle {
	@Id
	@GeneratedValue
	private Long id;
	@Column(length=100)
	private String nom;
	@OneToMany(mappedBy = "salle", fetch=FetchType.EAGER)
	private List<Consultation> consulations = new ArrayList<>();
	

	public Salle() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public List<Consultation> getConsulations() {
		return consulations;
	}

	public void setConsulations(List<Consultation> consulations) {
		this.consulations = consulations;
	}
	
	
}
