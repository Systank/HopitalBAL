package sopra.promo404.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.promo404.hopital.model.FileAttente;

public interface IRepoFileAttente extends JpaRepository<FileAttente, Long>{

}
