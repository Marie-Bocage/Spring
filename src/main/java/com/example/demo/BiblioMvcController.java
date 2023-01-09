package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
public class BiblioMvcController {

    @Autowired
    BibliothequeDatabaseService bibliothequeDatabaseService;

    @GetMapping("livres")
    public String afficheLivres (Model model) {
        List<Livre> livres = bibliothequeDatabaseService.findAllLivres();

        model.addAttribute("livres", livres);
        return "livres.html";
    }

    @GetMapping("livre")
    public String afficheDetailsLivre(@RequestParam Integer id, Model model) {
        Optional<Livre> optional = bibliothequeDatabaseService.findLivreById(id);
        model.addAttribute("optional", optional);

        return "livreById.html";
    }

    @GetMapping("categories")
    public String afficheCategorie(Model model) {
        List<Categorie> categories = bibliothequeDatabaseService.findAllCategories();

        model.addAttribute("categories", categories);

        return "categorie.html";
    }

    @PostMapping("categories")
    public String ajouterCategorie(Categorie categorie, Model model) {
        bibliothequeDatabaseService.addCategorie(categorie);

        List<Categorie> categories = bibliothequeDatabaseService.findAllCategories();

        model.addAttribute("categories", categories);
        return "categorie.html";
    }
}
