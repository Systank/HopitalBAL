package sopra.promo404.hopital.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.promo404.hopital.model.FileAttente;

public interface IRepoFileAttente extends JpaRepository<FileAttente, Long>{

	@Query("Select distinct f from FileAttente f left join fetch f.patient where f.id =:id")
	FileAttente findFileAttenteByIdWithPatient(@Param("id")Long id);
	
	@Query("Select f from FileAttente f")
	List<FileAttente>findAllFileAttente();
}
