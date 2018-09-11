package sopra.promo404.hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.promo404.hopital.model.Medecin;

public interface IRepoMedecin extends JpaRepository<Medecin, Long> {

}
