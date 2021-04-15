package View;

import Model.Grille;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    Point taille;

    Model.Grille modele;
    View.Grille vue;


    public Fenetre(int x , int y){
        super("Number Reconizer");
        taille = new Point(x,y);

        this.setSize(x,y+20);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setModel(Grille grille) {
        this.modele = grille;
        this.vue = new View.Grille(taille, grille);
        this.setContentPane(this.vue);
        this.setVisible(true);
    }

    public View.Grille getVue(){
        return vue;
    }
}
