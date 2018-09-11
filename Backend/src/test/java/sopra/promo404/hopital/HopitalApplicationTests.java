package sopra.promo404.hopital;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sopra.promo404.hopital.model.Civilite;
import sopra.promo404.hopital.model.Patient;
import sopra.promo404.hopital.repository.IRepoPatient;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HopitalApplicationTests {
	
	@Autowired
	private IRepoPatient patientRepo;

	@Test
	public void contextLoads() {
		
		Patient patient1 = new Patient();
		
		patient1.setNom("JOURDAN");
		patient1.setCivilite(Civilite.MLLE);
		patientRepo.save(patient1);
		
	}

}
