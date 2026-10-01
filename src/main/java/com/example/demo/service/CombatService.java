package com.example.demo.service;

import com.example.demo.personnages.Challenger;
import com.example.demo.personnages.Julien;
import com.example.demo.personnages.Leo;
import com.example.demo.personnages.Personnage;
import com.example.demo.repository.ChallengerRepository;
import com.example.demo.repository.JulienRepository;
import com.example.demo.repository.LeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CombatService {

    private static final String[] COUPS = {
            "coup de poing", "coup de pied", "uppercut", "balayage",
            "coup de coude", "griffure", "charge", "coup de queue"
    };

    private final JulienRepository julienRepository;
    private final LeoRepository leoRepository;
    private final ChallengerRepository challengerRepository;

    @Autowired
    public CombatService(JulienRepository julienRepository, LeoRepository leoRepository, ChallengerRepository challengerRepository) {
        this.julienRepository = julienRepository;
        this.leoRepository = leoRepository;
        this.challengerRepository = challengerRepository;
    }

    public String combattre(List<String> participants) {
        List<Personnage> combattants = new ArrayList<>();
        List<String> noms = new ArrayList<>();

        for (String p : participants) {
            String[] parts = p.split(":");
            if (parts.length != 2) {
                continue;
            }
            String type = parts[0];
            Long id = Long.parseLong(parts[1]);

            if (type.equalsIgnoreCase("Julien")) {
                Julien j = julienRepository.findById(id).orElse(null);
                if (j != null) {
                    combattants.add(j);
                    noms.add("Julien");
                }
            } else if (type.equalsIgnoreCase("Leo")) {
                Leo l = leoRepository.findById(id).orElse(null);
                if (l != null) {
                    combattants.add(l);
                    noms.add("Leo");
                }
            } else if (type.equalsIgnoreCase("Challenger")) {
                Challenger c = challengerRepository.findById(id).orElse(null);
                if (c != null) {
                    combattants.add(c);
                    noms.add(c.getNom());
                }
            }
        }

        if (combattants.size() < 2 || combattants.size() > 3) {
            return "Il faut entre 2 et 3 personnages valides pour un combat.";
        }

        Random random = new Random();
        StringBuilder log = new StringBuilder();
        log.append("Début du combat !!!: ").append(String.join(" vs ", noms)).append(" :)\n\n");

        int tours = 3;
        for (int tour = 1; tour <= tours; tour++) {
            log.append("Tour ").append(tour).append(" XD\n");
            for (int i = 0; i < combattants.size(); i++) {
                Personnage attaquant = combattants.get(i);
                int cibleIndex = (i + 1) % combattants.size();
                Personnage cible = combattants.get(cibleIndex);

                String coup = COUPS[random.nextInt(COUPS.length)];
                attaquant.setAction(coup);
                int degats = attaquant.calculerDegats();
                cible.subirDegats(degats);

                log.append(noms.get(i)).append(" utilise ").append(coup)
                        .append(" ! ").append(noms.get(cibleIndex)).append(" perd ").append(degats)
                        .append(" PV (PV restants : ").append(cible.getPv()).append(")\n");
            }
            log.append("\n");
        }

        for (Personnage p : combattants) {
            if (p instanceof Julien j) {
                julienRepository.save(j);
            } else if (p instanceof Leo l) {
                leoRepository.save(l);
            } else if (p instanceof Challenger c) {
                challengerRepository.save(c);
            }
        }

        log.append("Réconciliation :3\n");
        for (String nom : noms) {
            log.append(nom).append(" tend la main.\n");
        }
        log.append(String.join(", ", noms)).append(" se regardent, et s'embrassent. Meilleur scénario pour taquiner ses amis qui ont, contre toute attente, appréciés celui-ci !\n");

        return log.toString();
    }
}