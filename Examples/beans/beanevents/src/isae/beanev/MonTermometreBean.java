/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * <manifest>
 *     <attribute name="Main-Class" value="${main.class}"/>
 *     <attribute name="Class-Path" value="${jar.classpath}"/>
 *     <attribute name="Java-Bean" value="true"/> ajouter cette ligne dans
 *                                                build-impk.xml
 * </manifest>
 */
package isae.beanev;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author pfares
 */
public class MonTermometreBean implements Serializable {

    public MonTermometreBean() {
        //Un simulateur de termometre
        //r une classe en ligne
        Runnable r = new Runnable() {

            public void run() {
                for (;;) {
                    try {
                        Thread.currentThread().sleep(periode);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(MonTermometreBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // f entre -100 et +100
                    float f = (float) ((Math.random()*200) - 100);
                    float prev = temperature;
                    temperature = f;
                    if (f > prev) {
                        TropChaudEvent e = new TropChaudEvent(MonTermometreBean.this, f);
                        fireEventTropChaud(e);
                    }

                }
            }
        };
        Thread th = new Thread(r);
        th.start();
    }

    private void fireEventTropChaud(TropChaudEvent e) {
        for (int i = 0; i < tropChaudListeners.size(); i++) {
            TropChaudEventListener l =
                    (TropChaudEventListener) tropChaudListeners.elementAt(i);
            l.laTemperatureMonte(e);
        }
    }
    private float temperature = (float) 0.0;
    private long periode = 10000; /* 10000 millisecondes */


    /**
     * @return the temperature
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * @return the periode
     */
    public long getPeriode() {
        return periode;
    }

    /**
     * @param periode the periode to set
     */
    public void setPeriode(long periode) {
        this.periode = periode;
    }
    private transient Vector tropChaudListeners = new Vector();

    public void addTropChaudEventListener(TropChaudEventListener l) {
        tropChaudListeners.add(l);
    }

    public void removeTropChaudEventListener(TropChaudEventListener l) {
        tropChaudListeners.removeElement(l);
    }
}
