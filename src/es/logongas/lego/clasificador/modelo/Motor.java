/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.logongas.lego.clasificador.modelo;

import es.logongas.lego.Microcontroller;
import es.logongas.lego.MotorDirection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo González
 */
public class Motor {

    private ArrayList<ActionListener> actionListeners = new ArrayList<ActionListener>();
    Microcontroller microcontroller;
    int pin;
    boolean arrancado;
    MotorDirection motorDirection;

    public Motor(Microcontroller microcontroller, int pin) {
        this.microcontroller = microcontroller;
        this.pin = pin;
    }

    public void arrancar(MotorDirection motorDirection) {
        microcontroller.motorOn(pin, motorDirection, 255);
        arrancado=true;
        this.motorDirection=motorDirection;
        for(ActionListener actionListener:actionListeners) {
            actionListener.actionPerformed(new ActionEvent(this,1,motorDirection.name()));
        }
    }

    public void parar() {
        microcontroller.motorOff(pin);
        arrancado=false;
        for(ActionListener actionListener:actionListeners) {
            actionListener.actionPerformed(new ActionEvent(this,0,motorDirection.name()));
        }
    }

    public boolean isArrancado() {
        return arrancado;
    }
    
    public int getPin() {
        return pin;
    }

    public void addActionListener(ActionListener actionListener) {
        actionListeners.add(actionListener);
    }
}
