package sopra.promo404.hopital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {
	@Id
	@GeneratedValue
	private Long id;
	@Column(length=100)
	private String nom;
	@Column(length=100)
	private String prénom;
	@Column(length=20)
	private String numeroSecuriteSocial;
	@Column(length=20)
	private Civilite civilite;
	
	
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
	
}
