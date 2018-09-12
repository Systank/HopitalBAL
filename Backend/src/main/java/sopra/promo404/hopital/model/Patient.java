package sopra.promo404.hopital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.hopital.model.Views;

@Entity
public class Patient {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(length=100)
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@Column(length=100)
	@JsonView(Views.ViewCommon.class)
	private String prénom;
	@Column(length=20)
	@JsonView(Views.ViewCommon.class)
	private String numeroSecuriteSocial;
	@JsonView(Views.ViewCommon.class)
	private Civilite civilite;
	
	@OneToMany(mappedBy="patient", fetch=FetchType.EAGER)
	@JsonView(Views.ViewPatientWithConsultation.class)
	private List<Consultation> consultations;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fileAttente_id")
	@JsonView(Views.ViewPatient.class)
	private FileAttente fileAttente;
	
	public Patient() {
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

	public String getPrénom() {
		return prénom;
	}

	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}

	public String getNumeroSecuriteSocial() {
		return numeroSecuriteSocial;
	}

	public void setNumeroSecuriteSocial(String numeroSecuriteSocial) {
		this.numeroSecuriteSocial = numeroSecuriteSocial;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}
	
}
