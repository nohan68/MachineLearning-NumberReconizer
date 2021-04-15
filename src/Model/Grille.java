package Model;

import java.awt.*;
import java.util.Arrays;

public class Grille<T> {

    private T[][] cases;



    private T valeurInit;

    public Grille(int taille){
        cases = (T[][]) new Object[taille][taille];
    }

    public Grille(int taille, T valeurInit){
        this(taille);
        this.valeurInit = valeurInit;
        this.initGrille(valeurInit);
    }

    protected void initGrille(T valeurInit){
        for (T[] aCase : cases) {
            Arrays.fill(aCase, valeurInit);
        }
    }

    public void initGrille(){
        initGrille(this.valeurInit);
    }

    public T getAt(int x, int y){
        return this.cases[y][x];
    }

    public void setAt(int x, int y, T valeur){
        this.cases[y][x] = valeur;
    }

    public Point getTaille(){
        return new Point(cases.length, cases[0].length);
    }


    public int getDistance(Point A, Point B){
        return (int) Math.round(Math.sqrt(
                Math.pow(B.x-A.x,2) + Math.pow(B.y - A.y,2)
        ));
    }

    public Object getType() {
        return this.valeurInit;
    }

    public int[] serialize(){
        int[] valeurs = new int[(int) Math.round(Math.pow(getTaille().x,2))];
        int i=0;
        for(int x=0; x<getTaille().x; x++){
            for(int y=0; y<getTaille().y; y++){
                valeurs[i] = (Boolean) this.getAt(x,y) ? 1 : 0;
                System.out.println(valeurs[i]);
                i++;
            }
        }
        return valeurs;
    }
}
