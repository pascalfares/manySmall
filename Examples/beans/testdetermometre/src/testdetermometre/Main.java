/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testdetermometre;

import isae.beanev.MonTermometreBean;
import isae.beanev.TropChaudEvent;
import isae.beanev.TropChaudEventListener;

/**
 *
 * @author pfares
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MonTermometreBean mb = new MonTermometreBean();
        mb.setPeriode(1000);
        TropChaudEventListener l  = new TropChaudEventListener() {
            public void laTemperatureMonte(TropChaudEvent e) {
                System.out.println("Je lit la temperature1111 -> " +e.getTemperature());
            }
        };

        mb.addTropChaudEventListener(l);

        mb.addTropChaudEventListener(new TropChaudEventListener() {
            public void laTemperatureMonte(TropChaudEvent e) {
                System.out.println("Je lit la temperature2222-> " +e.getTemperature());
            }
        });
        
    }

}
