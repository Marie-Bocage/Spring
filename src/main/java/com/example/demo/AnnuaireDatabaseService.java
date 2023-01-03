package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
