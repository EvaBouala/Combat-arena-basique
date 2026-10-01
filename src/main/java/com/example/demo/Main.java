package com.example.demo;

import java.util.Scanner;

import com.example.demo.personnages.Challenger;
import com.example.demo.personnages.Julien;
import com.example.demo.personnages.Leo;
import com.example.demo.personnages.Personnage;

public class Main {
    public static void main(String[] args) {
        Leo leo = new Leo(180, true, true, "Regarde-moi bien !", "", 20);
        Julien julien = new Julien(179, false, "", 20);

        System.out.println("=== Début du combat ===");
        System.out.println("Leo mesure " + leo.getTaille() + " cm, swag : " + leo.isSwag() + ", beau : " + leo.isBeau());
        System.out.println("Leo : \"" + leo.getPhrase() + "\"");
        System.out.println();

        Personnage combattant1 = leo;
        Personnage combattant2 = julien;

        String[] coupsLeo = {"coup de poing", "coup de pied", "uppercut"};
        String[] coupsJulien = {"balayage", "coup de coude", "kick"};

        for (int i = 0; i < coupsLeo.length; i++) {
            System.out.println("--- Tour " + (i + 1) + " ---");

            combattant1.setAction(coupsLeo[i]);
            combattant2.subirDegats(5);
            System.out.println("Leo utilise " + combattant1.getAction() + " ! Julien perd 5 PV (PV restants : " + combattant2.getPv() + ")");

            combattant2.setAction(coupsJulien[i]);
            combattant1.subirDegats(4);
            System.out.println("Julien riposte avec " + combattant2.getAction() + " ! Leo perd 4 PV (PV restants : " + combattant1.getPv() + ")");
        }

        System.out.println();
        System.out.println("=== Réconciliation ===");
        combattant1.setAction("tend la main");
        combattant2.setAction("serre la main");
        System.out.println("Leo " + combattant1.getAction() + " à Julien.");
        System.out.println("Julien " + combattant2.getAction() + ".");
        System.out.println("Les deux se regardent, éclatent de rire, et s'embrassent. Fin du combat, amis pour toujours !");

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("=== Création d'un nouveau personnage ===");

        System.out.print("Nom du nouveau personnage : ");
        String nom = scanner.nextLine();

        System.out.print("Taille (en cm) : ");
        float taille = Float.parseFloat(scanner.nextLine());

        System.out.print("Swag (true/false) : ");
        boolean swag = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Points de vie (PV) : ");
        int pv = Integer.parseInt(scanner.nextLine());

        Personnage challenger = new Challenger(nom, taille, swag, pv);

        System.out.println();
        System.out.println(nom + " rejoint l'arène pour affronter Julien !");

        julien = new Julien(179, false, "", 20);

        String[] coupsChallenger = {"griffure", "charge", "coup de queue"};
        String[] coupsJulienBis = {"crochet", "coup de genou", "clé de bras"};

        for (int i = 0; i < coupsChallenger.length; i++) {
            System.out.println("--- Tour " + (i + 1) + " ---");

            challenger.setAction(coupsChallenger[i]);
            julien.subirDegats(5);
            System.out.println(nom + " utilise " + challenger.getAction() + " ! Julien perd 5 PV (PV restants : " + julien.getPv() + ")");

            julien.setAction(coupsJulienBis[i]);
            challenger.subirDegats(4);
            System.out.println("Julien riposte avec " + julien.getAction() + " ! " + nom + " perd 4 PV (PV restants : " + challenger.getPv() + ")");
        }

        System.out.println();
        System.out.println("=== Réconciliation ===");
        challenger.setAction("tend la main");
        julien.setAction("serre la main");
        System.out.println(nom + " " + challenger.getAction() + " à Julien.");
        System.out.println("Julien " + julien.getAction() + ".");
        System.out.println("Les deux se regardent, éclatent de rire, et s'embrassent. Fin du combat, amis pour toujours !");

        scanner.close();
    }
}