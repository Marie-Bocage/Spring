package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

//	@Autowired
//	AnnuaireDatabaseService annuaireDatabaseService;

	@Test
	void testFindAllPersonnesByNom() {
		AnnuaireDatabaseService annuaireDatabaseService =  new AnnuaireDatabaseService();
		List<Personne> familleDelon = annuaireDatabaseService.getPersonnesByNom("Delon");
		assertEquals(4,familleDelon.size());

	}

	@Test
	void testAdditionner() {
		// Fais un test unitaire dans ce cas (plus rapide car pas besoin de démarrer le serveur)
		AnnuaireDatabaseService annuaireDatabaseService =  new AnnuaireDatabaseService();
		int resultat = annuaireDatabaseService.additionner(2,3);
		assertEquals(5, resultat);

	}

}
