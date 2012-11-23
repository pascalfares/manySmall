/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author orifi
 */
public class Droite {
    private int x1,y1,x2,y2;
    private Color couleur;

    public Droite(int x1, int y1, int x2, int y2,Color c) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        couleur =c;
    }

    Color getColor(){
        return couleur;
    }

    public void dessiner(Graphics g){
        g.setColor(couleur);
        g.drawLine(x1, y1, x2, y2);
    }

    public void setOtherPoint(int x, int y){
        x2=x;
        y2=y;
    }
}
