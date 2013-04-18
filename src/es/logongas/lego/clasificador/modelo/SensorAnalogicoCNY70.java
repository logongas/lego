/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.logongas.lego.clasificador.modelo;

import es.logongas.lego.Microcontroller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo González
 */
public class SensorAnalogicoCNY70 implements SensorAnalogico {
   
    Microcontroller microcontroller;
    int pin;

    public SensorAnalogicoCNY70(Microcontroller microcontroller, int pin) {
        this.microcontroller = microcontroller;
        this.pin = pin;
    }

    public int getValue() {         
        int value=microcontroller.analogRead(pin);
        return value;
    }

    public int getPin() {
        return pin;
    }  
    

   
}
