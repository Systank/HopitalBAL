package sopra.promo404.hopital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="Secretaire")
public class Secretaire {
	
	@Id
	@GeneratedValue
	@Column(name="Secretaire_id")
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name="Nom")
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@Column(name="Prenom")
	@JsonView(Views.ViewCommon.class)
	private String prenom;
	@Column(name="Civilite")
	@JsonView(Views.ViewCommon.class)
	private Civilite civilite;
	@Column(name="enPause")
	@JsonView(Views.ViewCommon.class)
	private Boolean enPause;
	@OneToMany(mappedBy="secretaire" , fetch=FetchType.EAGER)
	@JsonView(Views.ViewSecretaire.class)
	private List<FileAttente> fileAttente;
	
	public Secretaire() {
		super();
	}

	
	public Secretaire(Long id, int version, String nom, String prenom, Civilite civilite, Boolean enPause,
			List<FileAttente> fileAttente) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		this.enPause = enPause;
		this.fileAttente = fileAttente;
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

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Boolean getEnPause() {
		return enPause;
	}

	public void setEnPause(Boolean enPause) {
		this.enPause = enPause;
	}
	
	
	
	

}
