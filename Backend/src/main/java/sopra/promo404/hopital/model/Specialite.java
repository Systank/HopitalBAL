package sopra.promo404.hopital.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "SPECIALITE")
public class Specialite {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	
	@JsonView(Views.ViewCommon.class)
	private String libelle;
	
	@JsonView(Views.ViewCommon.class)
	private Float tarif;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="medecin_id")
	@JsonView(Views.ViewSpecialite.class)
	private Medecin medecin;

	@OneToMany(mappedBy="specialite", fetch=FetchType.EAGER)
	@JsonView(Views.ViewSpecialite.class)
	private List<Consultation> consultations;
	
	public Specialite() {
		super();
	}
	
	public Specialite(Long id, int version, String libelle, Float tarif, Medecin medecin) {
		super();
		this.id = id;
		this.version = version;
		this.libelle = libelle;
		this.tarif = tarif;
		this.medecin = medecin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Float getTarif() {
		return tarif;
	}

	public void setTarif(Float tarif) {
		this.tarif = tarif; 
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}
	
	
}
