/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.logongas.lego.clasificador.modelo;

import es.logongas.lego.Microcontroller;
import es.logongas.lego.MotorDirection;

/**
 *
 * @author Lorenzo González
 */
public class Cinta {
    Microcontroller microcontroller; 
    Motor motor;
    SensorPosicion sensorPosicionInicial;
    SensorPosicion sensorPosicionSensorColor;
    SensorPosicion sensorPosicionEmpujadorAzul;
    SensorPosicion sensorPosicionEmpujadorRojo;

    public Cinta(Microcontroller microcontroller, Motor motor, SensorPosicion sensorPosicionInicial, SensorPosicion sensorPosicionSensorColor, SensorPosicion sensorPosicionEmpujadorAzul, SensorPosicion sensorPosicionEmpujadorRojo) {
        this.microcontroller = microcontroller;
        this.motor = motor;
        this.sensorPosicionInicial = sensorPosicionInicial;
        this.sensorPosicionSensorColor = sensorPosicionSensorColor;
        this.sensorPosicionEmpujadorAzul = sensorPosicionEmpujadorAzul;
        this.sensorPosicionEmpujadorRojo = sensorPosicionEmpujadorRojo;
    }

    
    
    public void moverPosicionInicial() {
        motor.arrancar(MotorDirection.Reverse);
        while (sensorPosicionInicial.isInPosition()==false) {
            
        }
        motor.parar();
        
    }
    public void moverPosicionSensorColor() {
        motor.arrancar(MotorDirection.Forward);
        while (sensorPosicionSensorColor.isInPosition()==false) {
            
        }
        motor.parar();
    }   
    public void moverPosicionEmpujadorAzul() {
        motor.arrancar(MotorDirection.Forward);
        while (sensorPosicionEmpujadorAzul.isInPosition()==false) {
            
        }
        motor.parar();
    }   
    public void moverPosicionEmpujadorRojo() {
        motor.arrancar(MotorDirection.Forward);
        while (sensorPosicionEmpujadorRojo.isInPosition()==false) {
            
        }
        motor.parar();  
    }       
    
}
