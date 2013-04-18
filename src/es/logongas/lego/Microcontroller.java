/*
 * 
 * Microcontroller 18-feb-2009
 * 
 * Easy Layered Framework (ELF)
 * 
 * Copyright 2005-2009 Lorenzo González Gascón
 * http://elfframework.sourceforge.net
 * mailto: logongas@users.sourceforge.net
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA02111-1307USA
 * 
 * Disclaimer:
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 */
package es.logongas.lego;

import es.logongas.lego.ClassPathHacker;
import gnu.io.*;
import java.io.*;

/**
 *
 * @author <a href="mailto:logongas@users.sourceforge.net">Lorenzo González</a>
 */
public class Microcontroller implements SerialPortEventListener {

    static String COMMAND_DIGITAL_READ="DIGITAL_READ";
    static String COMMAND_DIGITAL_WRITE="DIGITAL_WRITE";
    static String COMMAND_ANALOG_READ="ANALOG_READ";
    static String COMMAND_LIGTH_SENSOR_READ="LIGTH_SENSOR_READ";
    static String COMMAND_PIN_DIGITAL_MODE="PIN_DIGITAL_MODE";
    static String COMMAND_PIN_ANALOG_MODE="PIN_ANALOG_MODE"; 
    static String COMMAND_MOTOR_ON="MOTOR_ON";
    static String COMMAND_MOTOR_OFF="MOTOR_OFF";
    static String COMMAND_MOTOR_ON_TIME="MOTOR_ON_TIME";
    static String COMMAND_MOTOR_ON_LIGTH="MOTOR_ON_LIGTH";
    static String COMMAND_MOTOR_ON_ANALOG="MOTOR_ON_ANALOG";
    static String COMMAND_MOTOR_ON_DIGITAL="MOTOR_ON_DIGITAL";
    
    static private int timeout = 20000;
    static private String appName = "Microcontroller";
    
    private String _portName;
    private SerialPort _serialPort;
    
    private InputStream _inputStream;
    private OutputStream _outputStream;


    static {
        {//Instalar el código para el puerto serie.
            String jreBase = System.getProperty("java.home");
            copyAndLoadFile("RXTXcomm.jar", jreBase + "\\lib\\ext");
            copyAndLoadFile("rxtxSerial.dll", jreBase + "\\bin");
            ClassPathHacker.addFile(jreBase + "\\lib\\ext\\" + "RXTXcomm.jar");
        }

    }



    /**
     * Crea una nueva instancia de la clase
     * @param portName Puerto serie donde se encuentra conectado el movil.
     */
    public Microcontroller(String portName) {

        inicialize(portName);
    }

    private void inicialize(String portName) {
        try {

            _portName = portName;

            _serialPort = (SerialPort) CommPortIdentifier.getPortIdentifier(_portName).open(appName, timeout);

            _outputStream =_serialPort.getOutputStream();
            _inputStream =_serialPort.getInputStream();
            _serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

            _serialPort.setSerialPortParams(19200,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            _serialPort.addEventListener(this);

            _serialPort.notifyOnDataAvailable(true);
            Thread.sleep(2000);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    static private void copyAndLoadFile(String name, String path) {
        File file = new File(path + "\\" + name);
        if (file.exists() == true) {
            return;
        }

        BufferedInputStream bis = new BufferedInputStream(Microcontroller.class.getResourceAsStream(name));
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

            byte[] buffer = new byte[2048];

            int n;
            do {
                n = bis.read(buffer);
                if (n > 0) {
                    bos.write(buffer, 0, n);
                }
            } while (n >= 0);

            bos.flush();
            bos.close();
            bis.close();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }



    }

    
    public int ligthSensorRead(int analogPin) {
        String command=COMMAND_LIGTH_SENSOR_READ + ";" + analogPin + ";";
        return Integer.parseInt(sendCommand(command)); 
    }
    
    public int analogRead(int analogPin) {
        String command=COMMAND_ANALOG_READ + ";" + analogPin + ";";
        return Integer.parseInt(sendCommand(command)); 
    }    

    public boolean digitalRead(int digitalPin) {
        String command=COMMAND_DIGITAL_READ + ";" + digitalPin + ";";
        String returnValue=sendCommand(command);
        if (returnValue.equals("1")) {
            return true;
        } else if (returnValue.equals("0")) {
            return false;
        } else {
            throw new RuntimeException("El valor está fuera de rango:" + returnValue);
        }
    }
    
    public void digitalWrite(int digitalPin,boolean value) {
        int iValue;
        if (value==true) {
            iValue=1;
        } else {
            iValue=0;
        }
        
        String command=COMMAND_DIGITAL_WRITE + ";" + digitalPin + ";" + iValue + ";";
        sendCommand(command);
    }
    
    public void pinMode(int digitalPin,PinMode pinMode) {
        String mode;
        switch (pinMode) {
            case INPUT:
                mode="0";
                break;
            case OUTPUT:
                mode="1";
                break; 
            default:
                throw new RuntimeException("PinMode desconocido:" + pinMode);
        }
        
        String command=COMMAND_PIN_DIGITAL_MODE + ";" + digitalPin + ";" + mode + ";";
        sendCommand(command);
    }

    /**
     * Pone en marcha un motor
     * @param numMotor Nº de motor a encender [0-3]
     * @param MotorDirection Indica hacia donde rota el motor
     * @param velocidad Velocidad del motor de 0 a 255
     */
    public void motorOn(int numMotor,MotorDirection motorDirection,int velocidad) {     
        String command=COMMAND_MOTOR_ON + ";" + numMotor + ";" + motorDirection.getValue() + ";" + velocidad + ";";
        sendCommand(command); 
    }
        
    /**
     * Para un motor
     * @param numMotor Nº de motor a encender [0-3]
     */
    public void motorOff(int numMotor) {
        String command=COMMAND_MOTOR_OFF + ";" + numMotor + ";";
        sendCommand(command); 
    }
    
    /**
     * Pone en marcha un motor durante un intervalo de tiempo.
     * @param numMotor Nº de motor a encender [0-3]
     * @param MotorDirection Indica hacia donde rota el motor
     * @param velocidad Velocidad del motor de 0 a 255
     * @param tiempo El tiempo en milisegundos que estará encendido.
     */
    public void motorOnTime(int numMotor,MotorDirection motorDirection,int velocidad,int tiempo) {     
        String command=COMMAND_MOTOR_ON_TIME + ";" + numMotor + ";" + motorDirection.getValue() + ";" + velocidad + ";" + tiempo + ";";
        sendCommand(command); 
    }    
    
    /**
     * Pone en marcha un motor hasta que un sensor de Luz de Lego tome un determinado rango de valores.
     * @param numMotor Nº de motor a encender [0-3]
     * @param MotorDirection Indica hacia donde rota el motor
     * @param velocidad Velocidad del motor de 0 a 255
     * @param pinAnalog Nº de Pin Analógico del que leer el valor
     * @param lowerThreshold Límite inferior que debe tener el sensor para que pare el motor
     * @param upperThreshold Límite superior que debe tener el sensor para que pare el motor
     */
    public void motorOnLigth(int numMotor,MotorDirection motorDirection,int velocidad,int pinAnalog,int lowerThreshold,int upperThreshold) {     
        String command=COMMAND_MOTOR_ON_LIGTH + ";" + numMotor + ";" + motorDirection.getValue() + ";" + velocidad + ";" + pinAnalog + ";" + lowerThreshold + ";" + upperThreshold + ";";
        sendCommand(command); 
    }    
    
    /**
     * Pone en marcha un motor hasta que un sensor analogico tome un determinado rango de valores.
     * @param numMotor Nº de motor a encender [0-3]
     * @param MotorDirection Indica hacia donde rota el motor
     * @param velocidad Velocidad del motor de 0 a 255
     * @param pinAnalog Nº de Pin Analógico del que leer el valor
     * @param lowerThreshold Límite inferior que debe tener el sensor para que pare el motor
     * @param upperThreshold Límite superior que debe tener el sensor para que pare el motor
     */
    public void motorOnAnalog(int numMotor,MotorDirection motorDirection,int velocidad,int pinAnalog,int lowerThreshold,int upperThreshold) {     
        String command=COMMAND_MOTOR_ON_ANALOG + ";" + numMotor + ";" + motorDirection.getValue() + ";" + velocidad + ";" + pinAnalog + ";" + lowerThreshold + ";" + upperThreshold + ";";
        sendCommand(command); 
    }    
    
    /**
     * Pone en marcha un motor hasta que un sensor digital tome un determinado valor.
     * @param numMotor Nº de motor a encender [0-3]
     * @param MotorDirection Indica hacia donde rota el motor
     * @param velocidad Velocidad del motor de 0 a 255
     * @param pinDigital Nº de Pin Digital del que leer el valor
     * @param lowerThreshold Límite inferior que debe tener el sensor para que pare el motor
     * @param upperThreshold Límite superior que debe tener el sensor para que pare el motor
     */
    public void motorOnDigital(int numMotor,MotorDirection motorDirection,int velocidad,int pinDigital,boolean value) {     
        int iValue;
        if (value==true) {
            iValue=1;
        } else {
            iValue=0;
        }
        String command=COMMAND_MOTOR_ON_DIGITAL + ";" + numMotor + ";" + motorDirection.getValue() + ";" + velocidad + ";" + pinDigital + ";" + iValue + ";" ;
        sendCommand(command); 
    }    
    
    /**
     * Manda un mensaje al microcontrolador
     * 
     * @param command Orden a enviar al microcontrolador
     * @return Respuesta del microcontrolador
     * @throws MicrocontrollerException Si hubo algún error al leer los datos del microcontrolador
     */
    public synchronized String sendCommand(String command)  {
        try {
            _outputStream.write(command.getBytes());
            _outputStream.flush();
            //System.out.println("In=" + command);
            
            String status=readLine();
            if (status.equalsIgnoreCase("OK")) {
                return readLine();
            } else if (status.equalsIgnoreCase("ERROR")) {
                throw new RuntimeException(readLine());
            } else {
                throw new RuntimeException("Respuesta inesperada del microcontrolador:"+status); 
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }


    }

    public String readLine() {
        try {
            int size=2048;
            int len=size;
            char[] buffer=new char[size];
            for(int i=0;i<size;i++) {
                int data;
                while ((data=_inputStream.read())==-1){};

                buffer[i]=(char)data;
                
                if (i>=1) {
                    if ((buffer[i]==(int)'\n') && (buffer[i-1]==(int)'\r')) {
                        len=i-1;
                        break;
                    }
                }
                if (buffer[i]==(int)'\n')  {
                    len=i;
                    break;
                }
            }
            
            String response=new StringBuffer().append(buffer, 0, len).toString();
            //System.out.println("Out=" + response);
            return response;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }        
    }

    public void serialEvent(SerialPortEvent serialPortEvent) {
        if (serialPortEvent.getEventType()==SerialPortEvent.DATA_AVAILABLE) {
            //System.out.println("Event Type=DATA_AVAILABLE");
        } else if (serialPortEvent.getEventType()==SerialPortEvent.OUTPUT_BUFFER_EMPTY) {
            System.out.println("Event Type=OUTPUT_BUFFER_EMPTY");
        } else {
            System.out.println("Event Type=" + serialPortEvent.getEventType());
        }
    }


}
