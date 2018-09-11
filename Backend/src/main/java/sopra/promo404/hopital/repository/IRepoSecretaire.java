package sopra.promo404.hopital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.promo404.hopital.model.FileAttente;
import sopra.promo404.hopital.model.Secretaire;

public interface IRepoSecretaire extends JpaRepository<Secretaire, Long>{
	
	@Query("Select s from Secretaire s")
	List<Secretaire>findAllSecretaire();
	
	@Query("Select distinct s from Secretaire s left join fetch s.fileAttente where s.id =:id")
	Secretaire findAllSecretaireByIdWithFileAttente(@Param("id")Long id);

}
