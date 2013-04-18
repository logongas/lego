/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.logongas.lego.clasificador.modelo;

import es.logongas.lego.Microcontroller;

/**
 *
 * @author Lorenzo González
 */
public class SensorDigitalPresion implements SensorDigital {
    Microcontroller microcontroller;
    int pin;

    public SensorDigitalPresion(Microcontroller microcontroller, int pin) {
        this.microcontroller = microcontroller;
        this.pin = pin;
    }

    public boolean getValue() {
        return microcontroller.digitalRead(pin);
    }

    public int getPin() {
        return pin;
    }


    
    
}
