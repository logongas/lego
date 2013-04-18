/*
 * Config 22-mar-2009
 * 
 * Easy Layered Framework (ELF)
 * 
 * Copyright 2004-2008 Lorenzo González Gascón
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
package es.logongas.lego.clasificador;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author  <a href="mailto:logongas@users.sourceforge.net">Lorenzo González</a>
 */
public class Config {
    String fileName;
    
    private int lowerLimitSensorPosicionInicio;
    private int upperLimitSensorPosicionInicio;
    private int lowerLimitSensorPosicionColor;
    private int upperLimitSensorPosicionColor;
    private int lowerLimitSensorPosicionSalida1;
    private int upperLimitSensorPosicionSalida1;
    private int lowerLimitSensorPosicionSalida2;
    private int upperLimitSensorPosicionSalida2;
    private int lowerLimitSensorColor1;
    private int upperLimitSensorColor1;
    private int lowerLimitSensorColor2;
    private int upperLimitSensorColor2;

    public Config(String fileName) {
        this.fileName=fileName;
    }
    
    public int getLowerLimitSensorPosicionInicio() {
        return lowerLimitSensorPosicionInicio;
    }

    public void setLowerLimitSensorPosicionInicio(int lowerLimitSensorPosicionInicio) {
        this.lowerLimitSensorPosicionInicio = lowerLimitSensorPosicionInicio;
    }

    public int getUpperLimitSensorPosicionInicio() {
        return upperLimitSensorPosicionInicio;
    }

    public void setUpperLimitSensorPosicionInicio(int upperLimitSensorPosicionInicio) {
        this.upperLimitSensorPosicionInicio = upperLimitSensorPosicionInicio;
    }

    public int getLowerLimitSensorPosicionColor() {
        return lowerLimitSensorPosicionColor;
    }

    public void setLowerLimitSensorPosicionColor(int lowerLimitSensorPosicionColor) {
        this.lowerLimitSensorPosicionColor = lowerLimitSensorPosicionColor;
    }

    public int getUpperLimitSensorPosicionColor() {
        return upperLimitSensorPosicionColor;
    }

    public void setUpperLimitSensorPosicionColor(int upperLimitSensorPosicionColor) {
        this.upperLimitSensorPosicionColor = upperLimitSensorPosicionColor;
    }

    public int getLowerLimitSensorPosicionSalida1() {
        return lowerLimitSensorPosicionSalida1;
    }

    public void setLowerLimitSensorPosicionSalida1(int lowerLimitSensorPosicionSalida1) {
        this.lowerLimitSensorPosicionSalida1 = lowerLimitSensorPosicionSalida1;
    }

    public int getUpperLimitSensorPosicionSalida1() {
        return upperLimitSensorPosicionSalida1;
    }

    public void setUpperLimitSensorPosicionSalida1(int upperLimitSensorPosicionSalida1) {
        this.upperLimitSensorPosicionSalida1 = upperLimitSensorPosicionSalida1;
    }

    public int getLowerLimitSensorPosicionSalida2() {
        return lowerLimitSensorPosicionSalida2;
    }

    public void setLowerLimitSensorPosicionSalida2(int lowerLimitSensorPosicionSalida2) {
        this.lowerLimitSensorPosicionSalida2 = lowerLimitSensorPosicionSalida2;
    }

    public int getUpperLimitSensorPosicionSalida2() {
        return upperLimitSensorPosicionSalida2;
    }

    public void setUpperLimitSensorPosicionSalida2(int upperLimitSensorPosicionSalida2) {
        this.upperLimitSensorPosicionSalida2 = upperLimitSensorPosicionSalida2;
    }

    public int getLowerLimitSensorColor1() {
        return lowerLimitSensorColor1;
    }

    public void setLowerLimitSensorColor1(int lowerLimitSensorColor1) {
        this.lowerLimitSensorColor1 = lowerLimitSensorColor1;
    }

    public int getUpperLimitSensorColor1() {
        return upperLimitSensorColor1;
    }

    public void setUpperLimitSensorColor1(int upperLimitSensorColor1) {
        this.upperLimitSensorColor1 = upperLimitSensorColor1;
    }

    public int getLowerLimitSensorColor2() {
        return lowerLimitSensorColor2;
    }

    public void setLowerLimitSensorColor2(int lowerLimitSensorColor2) {
        this.lowerLimitSensorColor2 = lowerLimitSensorColor2;
    }

    public int getUpperLimitSensorColor2() {
        return upperLimitSensorColor2;
    }

    public void setUpperLimitSensorColor2(int upperLimitSensorColor2) {
        this.upperLimitSensorColor2 = upperLimitSensorColor2;
    }

    public void save() {
        try {
            Properties properties = new Properties();

            properties.setProperty("lowerLimitSensorPosicionInicio", String.valueOf(lowerLimitSensorPosicionInicio));
            properties.setProperty("upperLimitSensorPosicionInicio", String.valueOf(upperLimitSensorPosicionInicio));
            properties.setProperty("lowerLimitSensorPosicionColor", String.valueOf(lowerLimitSensorPosicionColor));
            properties.setProperty("upperLimitSensorPosicionColor", String.valueOf(upperLimitSensorPosicionColor));
            properties.setProperty("lowerLimitSensorPosicionSalida1", String.valueOf(lowerLimitSensorPosicionSalida1));
            properties.setProperty("upperLimitSensorPosicionSalida1", String.valueOf(upperLimitSensorPosicionSalida1));
            properties.setProperty("lowerLimitSensorPosicionSalida2", String.valueOf(lowerLimitSensorPosicionSalida2));
            properties.setProperty("upperLimitSensorPosicionSalida2", String.valueOf(upperLimitSensorPosicionSalida2));
            properties.setProperty("lowerLimitSensorColor1", String.valueOf(lowerLimitSensorColor1));
            properties.setProperty("upperLimitSensorColor1", String.valueOf(upperLimitSensorColor1));
            properties.setProperty("lowerLimitSensorColor2", String.valueOf(lowerLimitSensorColor2));
            properties.setProperty("upperLimitSensorColor2", String.valueOf(upperLimitSensorColor2));

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
            properties.store(bos, null);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void read() {
        try {
            Properties properties = new Properties();
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
            properties.load(bis);

            lowerLimitSensorPosicionInicio = Integer.parseInt(properties.getProperty("lowerLimitSensorPosicionInicio"));
            upperLimitSensorPosicionInicio = Integer.parseInt(properties.getProperty("upperLimitSensorPosicionInicio"));
            lowerLimitSensorPosicionColor = Integer.parseInt(properties.getProperty("lowerLimitSensorPosicionColor"));
            upperLimitSensorPosicionColor = Integer.parseInt(properties.getProperty("upperLimitSensorPosicionColor"));
            lowerLimitSensorPosicionSalida1 = Integer.parseInt(properties.getProperty("lowerLimitSensorPosicionSalida1"));
            upperLimitSensorPosicionSalida1 = Integer.parseInt(properties.getProperty("upperLimitSensorPosicionSalida1"));
            lowerLimitSensorPosicionSalida2 = Integer.parseInt(properties.getProperty("lowerLimitSensorPosicionSalida2"));
            upperLimitSensorPosicionSalida2 = Integer.parseInt(properties.getProperty("upperLimitSensorPosicionSalida2"));
            lowerLimitSensorColor1 = Integer.parseInt(properties.getProperty("lowerLimitSensorColor1"));
            upperLimitSensorColor1 = Integer.parseInt(properties.getProperty("upperLimitSensorColor1"));
            lowerLimitSensorColor2 = Integer.parseInt(properties.getProperty("lowerLimitSensorColor2"));
            upperLimitSensorColor2 = Integer.parseInt(properties.getProperty("upperLimitSensorColor2"));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


    }
}
