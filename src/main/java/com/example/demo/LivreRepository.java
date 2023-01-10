package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LivreRepository extends JpaRepository<Livre, Integer> {

    @Query(value = "SELECT l FROM Livre l WHERE l.titre iLIKE %?1% OR " +
            "l.resume iLIKE %?1%") // Spécifique à psql qui permet d'ignorer la casse
    List<Livre> findLivreByMotCle(String motCle);
}
