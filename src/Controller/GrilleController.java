package Controller;

import View.Fenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GrilleController implements ActionListener, MouseMotionListener, KeyListener {

    private final Fenetre fenetre;
    Timer actualisationGraphique;
    Model.Grille modele;
    View.Grille vue;

    int tailleMine;

    public GrilleController(Fenetre fenetre, Model.Grille modele, View.Grille vue){
        this.actualisationGraphique = new Timer(1000/60,  this);
        this.actualisationGraphique.start();

        this.fenetre = fenetre;
        this.modele = modele;
        this.vue = vue;
        this.tailleMine = 5;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == actualisationGraphique){
            this.vue.repaint();
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_E){
            this.modele.initGrille();
        }
        if(e.getKeyCode() >= 48 &&  e.getKeyCode() <= 57){
            System.out.println(e.getKeyCode()-48);
            this.modele.serialize();
            this.vue.setVisible(false);
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point position = new Point(
                e.getX()/vue.getTailleCase().x,
                e.getY()/vue.getTailleCase().y
        );

        for(int i=0; i<this.modele.getTaille().x; i++){
            for(int j=0; j<this.modele.getTaille().y; j++){
                if(this.modele.getDistance(position, new Point(i,j)) < this.tailleMine){
                    this.modele.setAt(i,j, true);
                }
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
