package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

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

	@Test
	void testAJoutEmprunt() {
		Livre livre = livreRepository.findById(1).get();

		livre.setDateEmprunt(LocalDateTime.of(2023, 01,06,10,00));
		livre.setDateRetour(LocalDateTime.of(2023, 02,06,10,00));
		livreRepository.save(livre);
	}

}
