package com.example.demo.personnages;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Leo implements Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    float taille;
    boolean swag;
    boolean beau;
    String phrase;
    String action;
    int pv;

    public Leo() {
    }

    public Leo(float taille, boolean swag, boolean beau, String phrase, String action, int pv) {
        this.taille = taille;
        this.swag = swag;
        this.beau = beau;
        this.phrase = phrase;
        this.action = action;
        this.pv = pv;
    }

    public Long getId() {
        return id;
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

    public boolean isBeau() {
        return beau;
    }

    public void setBeau(boolean beau) {
        this.beau = beau;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
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

    @Override
    public int calculerDegats() {
        int degats = Personnage.super.calculerDegats();
        if (beau) {
            degats += 2;
        }
        return degats;
    }
}