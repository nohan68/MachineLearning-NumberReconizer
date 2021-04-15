package Controller;

import Model.Grille;
import View.Fenetre;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Grille<Boolean> grille = new Grille<>(64, false);

        Fenetre fenetre = new Fenetre(800,800);
        fenetre.setModel(grille);

        GrilleController grilleController = new GrilleController(fenetre, grille, fenetre.getVue());
        fenetre.getVue().addMouseMotionListener(grilleController);
        fenetre.addKeyListener(grilleController);

        ArrayList<Integer> maliste = new ArrayList<>();
    }
}
