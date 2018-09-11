package sopra.promo404.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.promo404.hopital.model.Consultation;

public interface IRepoConsultation extends JpaRepository<Consultation, Long >{

}
