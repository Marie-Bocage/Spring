package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {

    public List<Personne> findAllByNom(String nom);
    public List<Personne> findAllByNomAndPrenom(String nom, String prenom);
}
