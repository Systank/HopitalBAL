package sopra.promo404.hopital;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sopra.promo404.hopital.model.Patient;
import sopra.promo404.hopital.repository.IRepositoryPatient;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HopitalApplicationTests {
	
	@Autowired
	private IRepositoryPatient patientRepo;

	@Test
	public void contextLoads() {
		
		Patient patient1 = new Patient();
		
		patient1.setNom("JOURDAN");
		patientRepo.save(patient1);
		
	}

}
