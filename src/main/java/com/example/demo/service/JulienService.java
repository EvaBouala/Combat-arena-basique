package com.example.demo.service;

import com.example.demo.personnages.Julien;
import com.example.demo.repository.JulienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JulienService {

    private final JulienRepository julienRepository;

    @Autowired
    public JulienService(JulienRepository julienRepository) {
        this.julienRepository = julienRepository;
    }

    public Julien create(float taille, boolean swag, String action, int pv) {
        Julien julien = new Julien(taille, swag, action, pv);
        return julienRepository.save(julien);
    }

    public Julien get(Long id) {
        return julienRepository.findById(id).orElse(null);
    }

    public Julien update(Long id, float taille, boolean swag, String action, int pv) {
        Julien julien = julienRepository.findById(id).orElse(null);
        if (julien != null) {
            julien.setTaille(taille);
            julien.setSwag(swag);
            julien.setAction(action);
            julien.setPv(pv);
            julienRepository.save(julien);
        }
        return julien;
    }

    public Julien subirDegats(Long id) {
        Julien julien = julienRepository.findById(id).orElse(null);
        if (julien != null) {
            julien.subirDegats(julien.calculerDegats());
            julienRepository.save(julien);
        }
        return julien;
    }
}