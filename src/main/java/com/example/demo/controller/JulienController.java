package com.example.demo.controller;

import com.example.demo.personnages.Julien;
import com.example.demo.service.JulienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Julien")
public class JulienController {

    private final JulienService julienService;

    @Autowired
    public JulienController(JulienService julienService) {
        this.julienService = julienService;
    }

    @PostMapping
    public Julien create(@RequestParam float taille,
                         @RequestParam boolean swag,
                         @RequestParam String action,
                         @RequestParam int pv) {
        return julienService.create(taille, swag, action, pv);
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam Long id) {
        Julien julien = julienService.get(id);
        if (julien == null) {
            return ResponseEntity.status(404).body("Aucun Julien trouvé avec l'id " + id);
        }
        return ResponseEntity.ok(julien);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam Long id,
                                    @RequestParam float taille,
                                    @RequestParam boolean swag,
                                    @RequestParam String action,
                                    @RequestParam int pv) {
        Julien julien = julienService.update(id, taille, swag, action, pv);
        if (julien == null) {
            return ResponseEntity.status(404).body("Aucun Julien trouvé avec l'id " + id + ", rien n'a été modifié.");
        }
        return ResponseEntity.ok(julien);
    }

    @PutMapping("/degats")
    public ResponseEntity<?> subirDegats(@RequestParam Long id) {
        Julien julien = julienService.subirDegats(id);
        if (julien == null) {
            return ResponseEntity.status(404).body("Aucun Julien trouvé avec l'id " + id);
        }
        return ResponseEntity.ok(julien);
    }
}