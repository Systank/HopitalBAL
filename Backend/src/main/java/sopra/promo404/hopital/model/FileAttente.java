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
import javax.persistence.Table;
import javax.persistence.Version;

import sopra.promo404.hopital.model.Views;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="FileAttente")
public class FileAttente {
	
	@Id
	@GeneratedValue
	@Column(name="FileAttente_id")
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@Column(name="Version")
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name="Capacite")
	@JsonView(Views.ViewCommon.class)
	private int capacite;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Secretaire_id")
	@JsonView(Views.ViewFileAttente.class)
	private Secretaire secretaire;
	@OneToMany(mappedBy="fileAttente", fetch=FetchType.EAGER)
	@JsonView(Views.ViewFileAttente.class)
	private List<Patient> patient;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Medecin_id")
	@JsonView(Views.ViewFileAttenteWithMedecin.class)
	private Medecin medecin;

}
