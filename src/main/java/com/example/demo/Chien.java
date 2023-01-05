package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "chiens")
public class Chien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nomChien;

    private String race;

    @ManyToOne
    private Personne maitre;

    public Chien() {
    }

    public Chien(String nomChien, String race) {
        this.nomChien = nomChien;
        this.race = race;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomChien() {
        return nomChien;
    }

    public void setNomChien(String nomChien) {
        this.nomChien = nomChien;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Personne getMaitre() {
        return maitre;
    }

    public void setMaitre(Personne maitre) {
        this.maitre = maitre;
    }

    @Override
    public String toString() {
        return "Chien{" +
                "id=" + id +
                ", nomChien='" + nomChien + '\'' +
                ", race='" + race + '\'' +
                ", maitre=" + maitre +
                '}';
    }
}
