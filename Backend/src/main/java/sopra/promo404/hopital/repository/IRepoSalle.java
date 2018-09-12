package sopra.promo404.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.promo404.hopital.model.Salle;

public interface IRepoSalle extends JpaRepository<Salle, Long> {

	@Query("select s from Salle s left outer join fetch s.medecin m where s.id= :id")
	Salle findByIdWithMedecin(@Param("id") Long id);
	
	@Query("select s from Salle s left outer join fetch s.consultations")
	List<Salle> findAllSalle();
}
