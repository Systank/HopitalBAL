package sopra.promo404.hopital.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.hopital.model.Views;

@Entity
@Table(name = "MEDECIN")
public class Medecin {

	@Id
	@GeneratedValue
	@Column(name = "medecin_id")
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
	private String prenom;
	@JsonView(Views.ViewCommon.class)
	private Boolean carteVitale;
	@JsonView(Views.ViewCommon.class)
	private Boolean cmu;
	
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private Convention conventione;
	
	@OneToMany(mappedBy="medecin")
	@JsonView(Views.ViewMedecinWithSpecialite.class)
	private List<Specialite> specialites = new ArrayList<>();
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="salle_id")
	@JsonView(Views.ViewMedecin.class)
	private Salle salle;
	
	
	public Medecin() {
		super();
	}

	public Medecin(Long id, int version, String nom, String prenom, Boolean carteVitale, Boolean cmu,
			Convention conventione, List<Specialite> specialites) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.prenom = prenom;
		this.carteVitale = carteVitale;
		this.cmu = cmu;
		this.conventione = conventione;
		this.specialites = specialites;
	}

	public List<Specialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(List<Specialite> specialites) {
		this.specialites = specialites;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Boolean getCarteVitale() {
		return carteVitale;
	}

	public void setCarteVitale(Boolean carteVitale) {
		this.carteVitale = carteVitale;
	}

	public Boolean getCmu() {
		return cmu;
	}

	public void setCmu(Boolean cmu) {
		this.cmu = cmu;
	}

	public Convention getConventione() {
		return conventione;
	}

	public void setConventione(Convention conventione) {
		this.conventione = conventione;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	
}
