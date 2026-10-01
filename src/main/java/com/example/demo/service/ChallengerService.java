package com.example.demo.service;

import com.example.demo.personnages.Challenger;
import com.example.demo.repository.ChallengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengerService {

    private final ChallengerRepository challengerRepository;

    @Autowired
    public ChallengerService(ChallengerRepository challengerRepository) {
        this.challengerRepository = challengerRepository;
    }

    public Challenger create(String nom, float taille, boolean swag, String action, int pv) {
        Challenger challenger = new Challenger(nom, taille, swag, pv);
        challenger.setAction(action);
        return challengerRepository.save(challenger);
    }

    public Challenger get(Long id) {
        return challengerRepository.findById(id).orElse(null);
    }

    public Challenger update(Long id, String nom, float taille, boolean swag, String action, int pv) {
        Challenger challenger = challengerRepository.findById(id).orElse(null);
        if (challenger != null) {
            challenger.setNom(nom);
            challenger.setTaille(taille);
            challenger.setSwag(swag);
            challenger.setAction(action);
            challenger.setPv(pv);
            challengerRepository.save(challenger);
        }
        return challenger;
    }

    public Challenger subirDegats(Long id) {
        Challenger challenger = challengerRepository.findById(id).orElse(null);
        if (challenger != null) {
            challenger.subirDegats(challenger.calculerDegats());
            challengerRepository.save(challenger);
        }
        return challenger;
    }
}