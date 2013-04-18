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
public class Empujador {
    Microcontroller microcontroller;
    Motor motor;
    SensorDigital sensorDigitalDelantero;
    SensorDigital sensorDigitalTrasero;
    
     public Empujador(Microcontroller microcontroller,Motor motor, SensorDigital sensorDigitalDelantero, SensorDigital sensorDigitalTrasero) {
        this.microcontroller = microcontroller;
        this.motor = motor;
        this.sensorDigitalDelantero = sensorDigitalDelantero;
        this.sensorDigitalTrasero = sensorDigitalTrasero;

        
    }   
/*
    public Empujador(Microcontroller microcontroller, int pinMotor, int pinSensorDelantero, int pinSensorTrasero) {
        this.microcontroller = microcontroller;
        this.pinMotor = pinMotor;
        this.pinSensorDelantero = pinSensorDelantero;
        this.pinSensorTrasero = pinSensorTrasero;
        
        motor=new Motor(microcontroller, pinMotor);
        sensorDigitalDelantero=new SensorDigitalPresion(microcontroller, pinSensorDelantero);
        sensorDigitalTrasero=new SensorDigitalPresion(microcontroller, pinSensorTrasero);
        
        
    }
*/    
    
    public void empujar() {
        motor.arrancar(MotorDirection.Forward);
        while(sensorDigitalDelantero.getValue()==true) {
            
        }
        motor.parar();
        motor.arrancar(MotorDirection.Reverse);
        while(sensorDigitalTrasero.getValue()==false) {
            
        }
        motor.parar();        
    }
    
}
