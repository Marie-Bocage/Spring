package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuteursSpringTests {

	@Autowired
	AuteurRepository auteurRepository;



	@Test
	void testEntityAuteur() {
		Auteur auteur = new Auteur("Stephen", "King");
		auteurRepository.save(auteur);
	}





}
