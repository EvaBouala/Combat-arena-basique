package com.example.demo.controller;

import com.example.demo.personnages.Leo;
import com.example.demo.service.LeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Leo")
public class LeoController {

    private final LeoService leoService;

    @Autowired
    public LeoController(LeoService leoService) {
        this.leoService = leoService;
    }

    @PostMapping
    public Leo create(@RequestParam float taille,
                      @RequestParam boolean swag,
                      @RequestParam boolean beau,
                      @RequestParam String phrase,
                      @RequestParam String action,
                      @RequestParam int pv) {
        return leoService.create(taille, swag, beau, phrase, action, pv);
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam Long id) {
        Leo leo = leoService.get(id);
        if (leo == null) {
            return ResponseEntity.status(404).body("Aucun Leo trouvé avec l'id " + id);
        }
        return ResponseEntity.ok(leo);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam Long id,
                                    @RequestParam float taille,
                                    @RequestParam boolean swag,
                                    @RequestParam boolean beau,
                                    @RequestParam String phrase,
                                    @RequestParam String action,
                                    @RequestParam int pv) {
        Leo leo = leoService.update(id, taille, swag, beau, phrase, action, pv);
        if (leo == null) {
            return ResponseEntity.status(404).body("Aucun Leo trouvé avec l'id " + id + ", rien n'a été modifié.");
        }
        return ResponseEntity.ok(leo);
    }

    @PutMapping("/degats")
    public ResponseEntity<?> subirDegats(@RequestParam Long id) {
        Leo leo = leoService.subirDegats(id);
        if (leo == null) {
            return ResponseEntity.status(404).body("Aucun Leo trouvé avec l'id " + id);
        }
        return ResponseEntity.ok(leo);
    }
}