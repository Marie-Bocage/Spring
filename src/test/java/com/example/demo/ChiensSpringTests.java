package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChiensSpringTests {

	@Autowired
	ChienRepository chienRepository;

	@Autowired
	PersonneRepository personneRepository;

	@Test
	public void testEntityChien() {
		Chien pluto =  new Chien("Pluto", "Batard");
		chienRepository.save(pluto);
	}

	@Test
	public void testManyToOne() {

		Personne alain = personneRepository.findById(5).get();

		Chien dingo =  new Chien("Pluto", "Batard");
		dingo.setMaitre(alain);
		chienRepository.save(dingo);

	}

}
