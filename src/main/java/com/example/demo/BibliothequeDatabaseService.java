package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliothequeDatabaseService {

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    LivreRepository livreRepository;

    @Autowired
    AuteurRepository auteurRepository;

    public void addLivre(Livre livre) {
        livreRepository.save(livre);
    }

    public void addCategorie(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    public void addAuteur(Auteur auteur) {
        auteurRepository.save(auteur);
    }
}
