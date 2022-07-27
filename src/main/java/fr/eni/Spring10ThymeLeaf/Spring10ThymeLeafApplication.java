package fr.eni.Spring10ThymeLeaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.Spring10ThymeLeaf.bo.Voiture;
import fr.eni.Spring10ThymeLeaf.dal.VoitureDao;

@SpringBootApplication
public class Spring10ThymeLeafApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Spring10ThymeLeafApplication.class, args);
	}

	@Autowired
	private VoitureDao voitureDao;

	@Override
	public void run(String... args) throws Exception {
		Voiture captur = (new Voiture("ABC-123-DEF", "Renault", "Captur"));
		Voiture zoe = (new Voiture("GHI-123-JKL", "Renault", "Zoe"));
		Voiture model3 = (new Voiture("MNO-123-PQR", "Tesla", "Model3"));

		voitureDao.save(captur);
		voitureDao.save(zoe);
		voitureDao.save(model3);
	}

}
