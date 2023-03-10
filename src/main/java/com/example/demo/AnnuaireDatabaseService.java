package com.example.demo;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnuaireDatabaseService {

    @Autowired
    PersonneRepository personneRepository;

    public void addPersonne(Personne personne){
        personneRepository.save(personne);
    }

    public List<Personne> getPersonnes(){
        return personneRepository.findAll();
    }

    public void delete(Integer id){
        personneRepository.deleteById(id);
    }

    public void update(Integer id, Personne personne){
        personneRepository.save(personne);
    }

    public Optional<Personne> getPersonneById(Integer id) {
        return personneRepository.findById(id);
    }

    public List<Personne> getPersonnesByNom(String nom) {
        return personneRepository.findAllByNom(nom);
    }

    public List<Personne> getPersonneByNomAndPrenom(String nom, String prenom) {
        return personneRepository.findAllByNomAndPrenom(nom, prenom);
    }

    public int additionner(int a, int b) {
        return a + b;
    }
}
