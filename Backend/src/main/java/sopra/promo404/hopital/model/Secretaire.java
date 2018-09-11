package sopra.promo404.hopital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="Secretaire")
public class Secretaire {
	
	@Id
	@GeneratedValue
	@Column(name="Secretaire_id")
	private Long id;
	@Version
	private int version;
	@Column(name="Nom")
	private String nom;
	@Column(name="Prenom")
	private String prenom;
	@Column(name="Civilite")
	private Civilite civilite;
	@Column(name="enPause")
	private Boolean enPause;
	@Column(name="FileAttente")
	@OneToMany(mappedBy="Secretaire")
	private FileAttente fileAttente;
	
	public Secretaire() {
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
