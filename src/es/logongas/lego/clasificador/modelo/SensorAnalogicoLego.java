/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.logongas.lego.clasificador.modelo;

import es.logongas.lego.Microcontroller;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo González
 */
public class SensorAnalogicoLego implements SensorAnalogico {
    Microcontroller microcontroller;
    int pin;

    public SensorAnalogicoLego(Microcontroller microcontroller, int pin) {
        this.microcontroller = microcontroller;
        this.pin = pin;
    }


    
    public int getValue() {
        return microcontroller.ligthSensorRead(pin);
    }

    public int getPin() {
        return pin;
    }
    
}
