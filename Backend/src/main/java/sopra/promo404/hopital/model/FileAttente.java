package sopra.promo404.hopital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.hopital.model.Views;

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
	@ManyToOne
	@JoinColumn(name="Secretaire_id")
	private Secretaire secretaire;
	@OneToMany(mappedBy="fileAttente")
	private List<Patient> patient;
	@ManyToOne
	@JoinColumn(name="Medecin_id")
	private Medecin medecin;

}
