package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class StagesSpringTests {

	@Autowired
	StageRepository stageRepository;

	@Autowired
	PersonneRepository personneRepository;

	@Test
	void testEntityStage() {
		Stage salsa = new Stage("Initiation à la Salsa",
				LocalDateTime.of(2023,06,21,18,00));
		stageRepository.save(salsa);
	}

//	@Test
//	void testManyToMany() {
//		Stage salsa = stageRepository.findById(1).get();
//
//		Personne alain = personneRepository.findById(5).get();
//		Personne marie = personneRepository.findById(6).get();
//
//		salsa.addStagiaire(alain);
//		salsa.addStagiaire(marie);
//
//		stageRepository.save(salsa);
//	}

	@Test
	void testManyToMany() {

		Personne dev1 = new Personne("dev1", "dev1");
		Personne dev2 = new Personne("dev2", "dev2");
		personneRepository.save(dev1);
		personneRepository.save(dev2);

		Stage java = new Stage("Jva pour les Nuls",
				LocalDateTime.of(2023,06,21,18,00));
		java.addStagiaire(dev1);
		java.addStagiaire(dev2);

		stageRepository.save(java);
	}

}
