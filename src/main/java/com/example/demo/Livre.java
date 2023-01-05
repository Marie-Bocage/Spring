package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livres")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titre;

    @ManyToOne
    private Auteur auteur;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Categorie> categories = new ArrayList<>();

    public Livre() {
    }

    public Livre(String titre) {
        this.titre = titre;
    }

    public Livre(String titre, Auteur auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public Livre(String titre, Auteur auteur, List<Categorie> categories) {
        this.titre = titre;
        this.auteur = auteur;
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public void addCategories(Categorie categorie) {
        categories.add(categorie);
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur=" + auteur +
                ", categories=" + categories +
                '}';
    }
}
