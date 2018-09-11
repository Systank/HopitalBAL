package sopra.promo404.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.promo404.hopital.model.Medecin;

public interface IRepoMedecin extends JpaRepository<Medecin, Long> {

	@Query("select distinct m from Medecin m left join fetch m.specialites s where m.id= :id")
	Medecin findMedecinByIdWithSpecialite(@Param("id") Long id);
	
	@Query("select m from Medecin m")
	List<Medecin> findAllMedecin();
}
