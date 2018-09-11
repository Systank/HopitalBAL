package sopra.promo404.hopital.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.promo404.hopital.model.Patient;



public interface IRepoPatient extends JpaRepository<Patient, Long> {
	
	@Query("select p from Patient p left join fetch p.consultation f where p.id = :id")
	Patient findByIdWithConsultations(@Param("id") Long id);

}
