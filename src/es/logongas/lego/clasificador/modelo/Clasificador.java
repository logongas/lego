/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.logongas.lego.clasificador.modelo;

import java.awt.Color;

/**
 *
 * @author Lorenzo González
 */
public class Clasificador {
    Cinta cinta;
    SensorColor sensorColor;
    Empujador empujadorAzul;
    Empujador empujadorRojo;

    public Clasificador(Cinta cinta, SensorColor sensorColor, Empujador empujadorAzul, Empujador empujadorRojo) {
        this.cinta = cinta;
        this.sensorColor = sensorColor;
        this.empujadorAzul = empujadorAzul;
        this.empujadorRojo = empujadorRojo;
    }
    
    public void clasificar() {
        cinta.moverPosicionInicial();
        cinta.moverPosicionSensorColor();
        Color color=sensorColor.getColor();
        if (color==null) {
            //No hacemos nada
        } else if (color==Color.YELLOW) {
            cinta.moverPosicionEmpujadorAzul();
            empujadorAzul.empujar();
            
        } else if (color==Color.BLACK) {
            cinta.moverPosicionEmpujadorRojo();
            empujadorRojo.empujar();
        } else  {
            throw new RuntimeException("Color desconocido");
        }
        cinta.moverPosicionInicial();
    }
    
}
