package sopra.promo404.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.promo404.hopital.model.Consultation;

public interface IRepoConsultation extends JpaRepository<Consultation, Long >{

	@Query("select c from consultation c left outer join fetch c.specialite where c.id= :id")
	Consultation findConsultationByIdWithSpecialite(@Param("id") Long id);
	
	@Query("select c from Consultation c left outer join fetch c.patient left outer join fetch c.salle")
	List<Consultation> findAllConsultation();
}
