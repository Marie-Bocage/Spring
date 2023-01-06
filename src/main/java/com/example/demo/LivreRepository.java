package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Integer> {

    @Query(value = "SELECT l FROM Livre l WHERE l.titre LIKE %?1% OR " +
            "l.resume LIKE %?1%")
    List<Livre> findLivreByMotCle(String motCle);
}
