package sopra.promo404.hopital.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.hopital.model.Views;

@Entity
public class Salle {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Column(length=100)
	@JsonView(Views.ViewCommon.class)
	private String nom;
	
	@JsonView(Views.ViewSalle.class)
	@OneToMany(mappedBy = "salle", fetch=FetchType.EAGER)
	private List<Consultation> consultations = new ArrayList<>();
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="medecin_id")
	@JsonView(Views.ViewSalleWithMedecin.class)
	private Medecin medecin;
	

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
	
	
	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsulations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	
	
}
