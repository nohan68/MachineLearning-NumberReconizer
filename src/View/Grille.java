package View;

import javax.swing.*;
import java.awt.*;

public class Grille extends JPanel {

    Point taille;
    Model.Grille modele;

    public Grille(Point taille, Model.Grille modele){
        super();
        this.modele = modele;
        this.taille = taille;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,this.taille.x, this.taille.y);

        this.dessinerGrille(g2d);
        this.dessinerCases(g2d);

        // VSync
        Toolkit.getDefaultToolkit().sync();
    }

    public Point getTailleCase(){
        return new Point(
                (taille.x / modele.getTaille().x),
                (taille.y / modele.getTaille().y)
        );
    }

    void dessinerGrille(Graphics2D g2d){
        g2d.setColor(Color.LIGHT_GRAY);
        for(int i=0; i<=taille.x/getTailleCase().x-1; i++){
            g2d.drawLine(
                    i*getTailleCase().x,
                    0,
                    i*getTailleCase().x,
                    taille.y
            );
        }
        for(int j=0; j<=taille.y/getTailleCase().y; j++){
            g2d.drawLine(
                    0,
                    j*getTailleCase().y,
                    taille.x,
                    j*getTailleCase().y
            );
        }
    }

    void dessinerCases(Graphics2D g2d){
        g2d.setColor(Color.orange);
        for(int i=0; i<this.modele.getTaille().x; i++){
            for(int j=0; j<this.modele.getTaille().y; j++){
                if(this.modele.getType() instanceof Boolean) {
                    if ((boolean) this.modele.getAt(i, j)) {
                        g2d.fillRect(
                                i * getTailleCase().x,
                                j * getTailleCase().y,
                                getTailleCase().x,
                                getTailleCase().y
                        );
                    }
                }
            }
        }
    }
}
