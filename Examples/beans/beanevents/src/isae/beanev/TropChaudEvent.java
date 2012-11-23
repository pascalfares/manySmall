/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package isae.beanev;

/**
 *
 * @author pfares
 */
public class TropChaudEvent extends java.util.EventObject {

    public TropChaudEvent(Object source) {
       super(source);
    }

    private float temperature;

    public TropChaudEvent(Object source, float t) {
       this(source);
       temperature=t;
    }

    /**
     * @return the temperature
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

}
