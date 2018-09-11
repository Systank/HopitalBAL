package sopra.promo404.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.promo404.hopital.model.Specialite;

public interface IRepoSpecialite extends JpaRepository<Specialite, Long>{

	@Query("select s from Specialite s")
	List<Specialite> findAllSpecialite();
}
