package com.example.demo.controller;

import com.example.demo.service.CombatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/combat")
public class CombatController {

    private final CombatService combatService;

    @Autowired
    public CombatController(CombatService combatService) {
        this.combatService = combatService;
    }

    @PostMapping
    public String combattre(@RequestParam List<String> participants) {
        return combatService.combattre(participants);
    }
}