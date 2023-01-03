package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnuaireDatabaseService {

    @Autowired
    PersonneRepository personneRepository;

    public void addPersonne(Personne personne){
        personneRepository.save(personne);
    }
}
