package sopra.promo404.hopital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="FileAttente")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class FileAttente {
	
	@Id
	@GeneratedValue
	@Column(name="FileAttente_id")
	private Long id;
	@Version
	@Column(name="Version")
	private int version;
	@Column(name="Capacite")
	private int capacite;
	@Column(name="Secretaire")
	@ManyToOne
	@JoinColumn(name="Secretaire_id")
	private Secretaire secretaire;
	@Column(name="Patient")
	@OneToMany(mappedBy="FileAttente")
	private Patient patient;
	@Column(name="Medecin")
	@ManyToOne
	@JoinColumn(name="Medecin_id")
	private Medecin medecin;

}
