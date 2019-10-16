/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author nKBlaZy
 */
public class Partie extends Thread implements Parametres {
    private int score;
    private Cube cube;

    public Partie() {
        cube = new Cube(this);
        score = 0;
    }
    
    private void initCube() {
        cube.nouvelleCase();
        cube.nouvelleCase();
    }

    private void afficherCube() {
        System.out.println(cube + "\n");
    }
    
    public void run() {
        initCube();
        Scanner sc = new Scanner(System.in);
        boolean nouvelleCase;
        // while (!cube.partieFinie()) {
        while (0 == 0) {
            System.out.println("Score : " + score + " Valeur maximale : " + cube.getValeurMax());
            afficherCube();
            System.out.println("Déplacer vers la Gauche (q), Droite (d), Haut (z), Bas (s), Avant (r), Arrière (f)");
            String s = sc.nextLine();
            while (!(s.equals("q") || s.equals("d")  || s.equals("z") || s.equals("s") || s.equals("r") || s.equals("f"))) {
                System.out.println("Saisie incorrecte");
                s = sc.nextLine();
            }
            int direction;
            switch (s) {
                case "q":
                    direction = GAUCHE;
                    break;
                case "d":
                    direction = DROITE;
                    break;
                case "z":
                    direction = HAUT;
                    break;
                case "s":
                    direction = BAS;
                    break;
                case "r":
                    direction = AVANT;
                    break;
                default:
                    direction = ARRIERE;
                    break;
            }
            boolean deplacement = cube.lanceurDeplacerCases(direction);
            if (deplacement) {
                nouvelleCase = cube.nouvelleCase();
                if (!nouvelleCase) cube.gameOver();
            }
            if (cube.getValeurMax() >= OBJECTIF) cube.victory();
        }
    }

    public int getScore() {
        return score;
    }
    
}
