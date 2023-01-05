package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CategoriesSpringTests {

	@Autowired
	CategorieRepository categorieRepository;

	@Autowired
	LivreRepository livreRepository;

	@Autowired
	AuteurRepository auteurRepository;

	@Test
	void testEntityCategorie() {
		Categorie categorie = new Categorie("Horreur");
		categorieRepository.save(categorie);
	}

	@Test
	void testManyToMany() {
		Categorie categorie = new Categorie("Thriller");
		categorieRepository.save(categorie);

		Livre livre = livreRepository.findById(1).get();
		livre.addCategories(categorie);
		livreRepository.save(livre);
	}

	@Test
	void testSeveralCategories() {
		List<Categorie> categories = new ArrayList<>();
		categories.add(categorieRepository.findById(1).get());
		categories.add(categorieRepository.findById(2).get());

		Livre livre = new Livre("Harry Potter et la Chambre des Secrets",
				auteurRepository.findById(1).get(),
				categories);
		livreRepository.save(livre);
	}
}
