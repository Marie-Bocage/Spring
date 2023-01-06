package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class BibliothequeController {

    @Autowired
    BibliothequeDatabaseService bibliothequeDatabaseService;

    @PostMapping("categorie")
    public void createCategorie(@RequestBody Categorie categorie) {
        bibliothequeDatabaseService.addCategorie(categorie);
    }

    @PostMapping("auteur")
    public void createAuteur(@RequestBody Auteur auteur) {
        bibliothequeDatabaseService.addAuteur(auteur);
    }

    @PostMapping("livre")
    public void createLivre(@RequestBody Livre livre) {
        bibliothequeDatabaseService.addLivre(livre);
    }

    @GetMapping("livre")
    public List<Livre> getAllLivres() {
        return bibliothequeDatabaseService.findAllLivres();
    }

    @GetMapping("livre/{id}")
    public ResponseEntity getDisponibiliteLivre(@PathVariable Integer id) {
        Optional<Livre> optional = bibliothequeDatabaseService.findLivreById(id);

        if(optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            if(optional.get().getDateEmprunt() != null) {
                return ResponseEntity.badRequest().body("Livre non disponible.");
            }
            return ResponseEntity.ok(optional.get());
        }
    }

    @GetMapping("livremotcle")
    public ResponseEntity getAllLivreByMotCle(@RequestParam String motCle) {
        List<Livre> livres = bibliothequeDatabaseService.findAllLivreByMotCle(motCle);
        if(livres.isEmpty()) {
            return ResponseEntity.badRequest().body("Aucun livre ne correspond à la recherche.");
        }
        return ResponseEntity.ok(livres);
    }
}
