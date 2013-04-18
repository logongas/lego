/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.logongas.lego.clasificador.modelo;

import java.awt.Color;
import es.logongas.lego.Microcontroller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo González
 */
public class SensorColor extends SensorAnalogicoLego {
    private ArrayList<ActionListener> actionListeners = new ArrayList<ActionListener>();
    
    private int lowerLimitSensorColor1;
    private int upperLimitSensorColor1;
    private int lowerLimitSensorColor2;
    private int upperLimitSensorColor2;
    private Color color1=Color.YELLOW;
    private Color color2=Color.BLACK;

    public SensorColor(Microcontroller microcontroller, int pin,int lowerLimitSensorColor1, int upperLimitSensorColor1, int lowerLimitSensorColor2, int upperLimitSensorColor2) {
        super(microcontroller, pin);
        this.lowerLimitSensorColor1 = lowerLimitSensorColor1;
        this.upperLimitSensorColor1 = upperLimitSensorColor1;
        this.lowerLimitSensorColor2 = lowerLimitSensorColor2;
        this.upperLimitSensorColor2 = upperLimitSensorColor2;
    }
    

    
    
    public Color getColor() {
        int value=getCalculatedValue();
        if ((value>=lowerLimitSensorColor1) && (value<=upperLimitSensorColor1)) {
            return color1;
        }
        if ((value>=lowerLimitSensorColor2) && (value<=upperLimitSensorColor2)) {
            return color2;
        }        
        
        return null;
    }
    
    private int getCalculatedValue() {
        for(ActionListener actionListener:actionListeners) {
            actionListener.actionPerformed(new ActionEvent(this,1,null));
        }
        
        int numDesechar=5;
        for(int i=0;i<numDesechar;i++) {
            //No hacemos nada con estos valores
            int value=getValue();
        }
        
        int numCalcular=5;
        int value=0;
        for(int i=0;i<numDesechar;i++) {
            value=value+getValue();
        }
        int media=value/numCalcular;
        
        for(ActionListener actionListener:actionListeners) {
            actionListener.actionPerformed(new ActionEvent(this,0,null));
        }
        return media;
    }
 

    public void addActionListener(ActionListener actionListener) {
        actionListeners.add(actionListener);
    }       
}
