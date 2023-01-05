package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AddressesSpringTests {

	@Autowired
	AddresseRepository addresseRepository;

	@Autowired
	PersonneRepository personneRepository;

	@Test
	void testAddresses() {
		Addresse marseille = new Addresse(13, "rue du Vieuxport", "13000", "Marseille");
		addresseRepository.save(marseille);
	}

	@Test
	void testManyToOne() {
		Addresse marseille = new Addresse(13, "rue du Vieuxport", "13000", "Marseille");
		addresseRepository.save(marseille);

		Personne alain = new Personne("Alain", "Delon");
		alain.setAddresse(marseille);
		personneRepository.save(alain);
	}

	@Test
	void testAjoutDeuxiemeHabitant() {
		Addresse marseille = addresseRepository.findById(1).get();

		Personne marie = new Personne("Marie", "Delon");
		marie.setAddresse(marseille);
		personneRepository.save(marie);
	}

	@Test
	void testHabitantsAddresse(){

	}

}
