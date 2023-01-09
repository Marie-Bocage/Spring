package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Livre> findAllLivres() {
        return livreRepository.findAll();
    }

    public Optional<Livre> findLivreById(Integer id) {
        return livreRepository.findById(id);
    }

    public List<Livre> findAllLivreByMotCle(String motCle) {
        return livreRepository.findLivreByMotCle(motCle);
    }

    public List<Categorie> findAllCategories() {
        return categorieRepository.findAll();
    }

    public List<Auteur> findAllAuteur() {
        return auteurRepository.findAll();
    }
}
