package com.example.demo.personnages;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Challenger implements Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nom;
    float taille;
    boolean swag;
    String action;
    int pv;

    public Challenger() {
    }

    public Challenger(String nom, float taille, boolean swag, int pv) {
        this.nom = nom;
        this.taille = taille;
        this.swag = swag;
        this.pv = pv;
        this.action = "";
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public float getTaille() {
        return taille;
    }

    @Override
    public void setTaille(float taille) {
        this.taille = taille;
    }

    @Override
    public boolean isSwag() {
        return swag;
    }

    @Override
    public void setSwag(boolean swag) {
        this.swag = swag;
    }

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int getPv() {
        return pv;
    }

    @Override
    public void setPv(int pv) {
        this.pv = pv;
    }

    @Override
    public void subirDegats(int degats) {
        this.pv -= degats;
        if (this.pv < 0) {
            this.pv = 0;
        }
    }
}