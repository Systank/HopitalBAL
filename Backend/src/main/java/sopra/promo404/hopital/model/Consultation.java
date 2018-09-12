package sopra.promo404.hopital.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.hopital.model.Views;

@Entity
public class Consultation {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Temporal(TemporalType.DATE)
	@JsonView(Views.ViewCommon.class)
	private Date dateVisiteArrivee;
	@Temporal(TemporalType.DATE)
	@JsonView(Views.ViewCommon.class)
	private Date dateVisiteFin;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="salle_id")
	@JsonView(Views.ViewConsultation.class)
	private Salle salle;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="patient_id")
	@JsonView(Views.ViewConsultation.class)
	private Patient patient;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="specialite_id")
	@JsonView(Views.ViewConsultationWithSpecialite.class)
	private Specialite specialite;
	
	public Consultation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateVisiteArrivee() {
		return dateVisiteArrivee;
	}

	public void setDateVisiteArrivee(Date dateVisiteArrivee) {
		this.dateVisiteArrivee = dateVisiteArrivee;
	}

	public Date getDateVisiteFin() {
		return dateVisiteFin;
	}

	public void setDateVisiteFin(Date dateVisiteFin) {
		this.dateVisiteFin = dateVisiteFin;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	
	
}
