package com.example.demo.service;

import com.example.demo.personnages.Leo;
import com.example.demo.repository.LeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeoService {

    private final LeoRepository leoRepository;

    @Autowired
    public LeoService(LeoRepository leoRepository) {
        this.leoRepository = leoRepository;
    }

    public Leo create(float taille, boolean swag, boolean beau, String phrase, String action, int pv) {
        Leo leo = new Leo(taille, swag, beau, phrase, action, pv);
        return leoRepository.save(leo);
    }

    public Leo get(Long id) {
        return leoRepository.findById(id).orElse(null);
    }

    public Leo update(Long id, float taille, boolean swag, boolean beau, String phrase, String action, int pv) {
        Leo leo = leoRepository.findById(id).orElse(null);
        if (leo != null) {
            leo.setTaille(taille);
            leo.setSwag(swag);
            leo.setBeau(beau);
            leo.setPhrase(phrase);
            leo.setAction(action);
            leo.setPv(pv);
            leoRepository.save(leo);
        }
        return leo;
    }

    public Leo subirDegats(Long id) {
        Leo leo = leoRepository.findById(id).orElse(null);
        if (leo != null) {
            leo.subirDegats(leo.calculerDegats());
            leoRepository.save(leo);
        }
        return leo;
    }
}