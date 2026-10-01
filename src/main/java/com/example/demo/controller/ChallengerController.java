package com.example.demo.controller;

import com.example.demo.personnages.Challenger;
import com.example.demo.service.ChallengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Challenger")
public class ChallengerController {

    private final ChallengerService challengerService;

    @Autowired
    public ChallengerController(ChallengerService challengerService) {
        this.challengerService = challengerService;
    }

    @PostMapping
    public Challenger create(@RequestParam String nom,
                             @RequestParam float taille,
                             @RequestParam boolean swag,
                             @RequestParam String action,
                             @RequestParam int pv) {
        return challengerService.create(nom, taille, swag, action, pv);
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam Long id) {
        Challenger challenger = challengerService.get(id);
        if (challenger == null) {
            return ResponseEntity.status(404).body("Aucun Challenger trouvé avec l'id " + id);
        }
        return ResponseEntity.ok(challenger);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam Long id,
                                    @RequestParam String nom,
                                    @RequestParam float taille,
                                    @RequestParam boolean swag,
                                    @RequestParam String action,
                                    @RequestParam int pv) {
        Challenger challenger = challengerService.update(id, nom, taille, swag, action, pv);
        if (challenger == null) {
            return ResponseEntity.status(404).body("Aucun Challenger trouvé avec l'id " + id + ", rien n'a été modifié.");
        }
        return ResponseEntity.ok(challenger);
    }

    @PutMapping("/degats")
    public ResponseEntity<?> subirDegats(@RequestParam Long id) {
        Challenger challenger = challengerService.subirDegats(id);
        if (challenger == null) {
            return ResponseEntity.status(404).body("Aucun Challenger trouvé avec l'id " + id);
        }
        return ResponseEntity.ok(challenger);
    }
}