package sopra.promo404.hopital.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Consultation {
	@Id
	@GeneratedValue
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dateVisiteArrivee;
	@Temporal(TemporalType.DATE)
	private Date dateVisiteFin;
	
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
	
	
}
