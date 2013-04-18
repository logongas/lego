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
public class SensorPosicion extends SensorAnalogicoCNY70 {
    private ArrayList<ActionListener> actionListeners = new ArrayList<ActionListener>();     
    int lowerLimit;
    int upperLimit;

    public SensorPosicion(Microcontroller microcontroller, int pin,int lowerLimit, int upperLimit) {
        super(microcontroller, pin);
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public boolean isInPosition() {
        boolean inPosition;
        int value=this.getValue();
         
        if ((value>=lowerLimit) && (value<=upperLimit)) {
            inPosition=true;
        } else {
            inPosition=false;
        }
        for(ActionListener actionListener:actionListeners) {
            actionListener.actionPerformed(new ActionEvent(this,(inPosition==true?1:0),null));
        }         
        
        return inPosition;
    }
    
    public void addActionListener(ActionListener actionListener) {
        actionListeners.add(actionListener);
    }     
}
