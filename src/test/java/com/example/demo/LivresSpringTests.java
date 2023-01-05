package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LivresSpringTests {

	@Autowired
	LivreRepository livreRepository;

	@Autowired
	AuteurRepository auteurRepository;

	@Test
	void testEntityLivre() {
		Livre livre = new Livre("titre bidon");
		livreRepository.save(livre);
	}

	@Test
	void testManyToOneByCreateLivreAndAuteur(){
		Auteur auteur = new Auteur("J.K", "Rowling");
		auteurRepository.save(auteur);

		Livre livre = new Livre("Harry Potter", auteur);
		livreRepository.save(livre);
	}

	@Test
	void testManytoOneFromExistingAuteur() {
		Auteur auteur = auteurRepository.findById(2).get();

		Livre livre = new Livre("Ca", auteur);
		livreRepository.save(livre);
	}

}
