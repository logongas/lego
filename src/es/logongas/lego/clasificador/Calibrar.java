/*
 * Calibrar.java
 *
 * Created on 21 de marzo de 2009, 0:13
 */
package es.logongas.lego.clasificador;

import es.logongas.lego.clasificador.Config;
import es.logongas.lego.Microcontroller;
import es.logongas.lego.MotorDirection;
import info.monitorenter.gui.chart.ITrace2D;
import info.monitorenter.gui.chart.TracePoint2D;
import info.monitorenter.gui.chart.traces.Trace2DSimple;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author  Administrador
 */
public class Calibrar extends javax.swing.JDialog {

    Microcontroller mc;
    Config config;
    boolean calibrarOn = false;
    ITrace2D traceInicio;
    ITrace2D traceColor;
    ITrace2D traceSalida1;
    ITrace2D traceSalida2;

    /** Creates new form Calibrar */
    public Calibrar(java.awt.Frame parent, boolean modal, Microcontroller mc, Config config) {
        super(parent, modal);
        initComponents();
        this.mc = mc;
        this.config = config;
        jButtonCalibrarPosicionOn.setEnabled(true);
        jButtonCalibrarPosicionOff.setEnabled(false);
        jButtonMotorAvanzar.setEnabled(true);
        jButtonMotorRetroceder.setEnabled(true);
        jButtonMotorOff.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chart2D1 = new info.monitorenter.gui.chart.Chart2D();
        jButtonMotorAvanzar = new javax.swing.JButton();
        jButtonMotorOff = new javax.swing.JButton();
        jButtonCalibrarPosicionOn = new javax.swing.JButton();
        jButtonCalibrarPosicionOff = new javax.swing.JButton();
        jButtonMotorRetroceder = new javax.swing.JButton();
        jButtonCalibrarColorOn = new javax.swing.JButton();
        jButtonCalibrarColorOff = new javax.swing.JButton();
        jButtonReloadConfig = new javax.swing.JButton();
        jLabelY = new javax.swing.JLabel();

        chart2D1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chart2D1MouseMoved(evt);
            }
        });

        javax.swing.GroupLayout chart2D1Layout = new javax.swing.GroupLayout(chart2D1);
        chart2D1.setLayout(chart2D1Layout);
        chart2D1Layout.setHorizontalGroup(
            chart2D1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 753, Short.MAX_VALUE)
        );
        chart2D1Layout.setVerticalGroup(
            chart2D1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );

        jButtonMotorAvanzar.setText("Motor Avanzar");
        jButtonMotorAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMotorAvanzarActionPerformed(evt);
            }
        });

        jButtonMotorOff.setText("Motor Off");
        jButtonMotorOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMotorOffActionPerformed(evt);
            }
        });

        jButtonCalibrarPosicionOn.setText("Calibrar Posicion On");
        jButtonCalibrarPosicionOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalibrarPosicionOnActionPerformed(evt);
            }
        });

        jButtonCalibrarPosicionOff.setText("Calibrar Posicion Off");
        jButtonCalibrarPosicionOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalibrarPosicionOffActionPerformed(evt);
            }
        });

        jButtonMotorRetroceder.setText("Motor Retroceder");
        jButtonMotorRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMotorRetrocederActionPerformed(evt);
            }
        });

        jButtonCalibrarColorOn.setText("Calibrar Color On");
        jButtonCalibrarColorOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalibrarColorOnActionPerformed(evt);
            }
        });

        jButtonCalibrarColorOff.setText("Calibrar Color Off");
        jButtonCalibrarColorOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalibrarColorOffActionPerformed(evt);
            }
        });

        jButtonReloadConfig.setText("Reload Config");
        jButtonReloadConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReloadConfigActionPerformed(evt);
            }
        });

        jLabelY.setText("N/A");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart2D1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonMotorRetroceder)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonMotorAvanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jButtonMotorOff)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCalibrarPosicionOff)
                    .addComponent(jButtonCalibrarPosicionOn))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCalibrarColorOn)
                    .addComponent(jButtonCalibrarColorOff))
                .addGap(63, 63, 63)
                .addComponent(jButtonReloadConfig)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelY)
                .addContainerGap(725, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(chart2D1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonCalibrarPosicionOn)
                                    .addComponent(jButtonMotorOff)
                                    .addComponent(jButtonMotorAvanzar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonCalibrarPosicionOff)
                                    .addComponent(jButtonMotorRetroceder)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCalibrarColorOn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCalibrarColorOff))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButtonReloadConfig)))
                .addGap(11, 11, 11)
                .addComponent(jLabelY)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButtonMotorAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMotorAvanzarActionPerformed
    mc.motorOn(1, MotorDirection.Forward, 255);
    jButtonCalibrarPosicionOn.setEnabled(false);
    jButtonCalibrarPosicionOff.setEnabled(false);
    jButtonMotorAvanzar.setEnabled(false);
    jButtonMotorRetroceder.setEnabled(false);
    jButtonMotorOff.setEnabled(true);
}//GEN-LAST:event_jButtonMotorAvanzarActionPerformed

private void jButtonMotorOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMotorOffActionPerformed
    mc.motorOff(1);
    jButtonCalibrarPosicionOn.setEnabled(true);
    jButtonCalibrarPosicionOff.setEnabled(false);
    jButtonMotorAvanzar.setEnabled(true);
    jButtonMotorRetroceder.setEnabled(true);
    jButtonMotorOff.setEnabled(false);
}//GEN-LAST:event_jButtonMotorOffActionPerformed

private void jButtonCalibrarPosicionOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalibrarPosicionOnActionPerformed
    Timer timer = new Timer();
    calibrarOn = true;
    timer.schedule(new ObtenerDatosPosicion(this), 0);

    jButtonCalibrarPosicionOn.setEnabled(false);
    jButtonCalibrarPosicionOff.setEnabled(true);
    jButtonMotorAvanzar.setEnabled(false);
    jButtonMotorRetroceder.setEnabled(false);
    jButtonMotorOff.setEnabled(false);
}//GEN-LAST:event_jButtonCalibrarPosicionOnActionPerformed

private void jButtonMotorRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMotorRetrocederActionPerformed
    mc.motorOn(1, MotorDirection.Reverse, 255);
    jButtonCalibrarPosicionOn.setEnabled(false);
    jButtonCalibrarPosicionOff.setEnabled(false);
    jButtonMotorAvanzar.setEnabled(false);
    jButtonMotorRetroceder.setEnabled(false);
    jButtonMotorOff.setEnabled(true);
}//GEN-LAST:event_jButtonMotorRetrocederActionPerformed

private void jButtonCalibrarPosicionOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalibrarPosicionOffActionPerformed
    calibrarOn = false;
    chart2D1.removeAllTraces();
    chart2D1.addTrace(traceInicio);
    chart2D1.addTrace(traceColor);
    chart2D1.addTrace(traceSalida1);
    chart2D1.addTrace(traceSalida2);

    jButtonCalibrarPosicionOn.setEnabled(true);
    jButtonCalibrarPosicionOff.setEnabled(false);
    jButtonMotorAvanzar.setEnabled(true);
    jButtonMotorRetroceder.setEnabled(true);
    jButtonMotorOff.setEnabled(false);
}//GEN-LAST:event_jButtonCalibrarPosicionOffActionPerformed

private void jButtonCalibrarColorOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalibrarColorOnActionPerformed
    Timer timer = new Timer();
    calibrarOn = true;
    timer.schedule(new ObtenerDatosColor(this, config), 0);

    jButtonCalibrarPosicionOn.setEnabled(false);
    jButtonCalibrarPosicionOff.setEnabled(true);
    jButtonMotorAvanzar.setEnabled(false);
    jButtonMotorRetroceder.setEnabled(false);
    jButtonMotorOff.setEnabled(false);
}//GEN-LAST:event_jButtonCalibrarColorOnActionPerformed

private void jButtonCalibrarColorOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalibrarColorOffActionPerformed
    calibrarOn = false;
    chart2D1.removeAllTraces();
    chart2D1.addTrace(traceColor);


    jButtonCalibrarPosicionOn.setEnabled(true);
    jButtonCalibrarPosicionOff.setEnabled(false);
    jButtonMotorAvanzar.setEnabled(true);
    jButtonMotorRetroceder.setEnabled(true);
    jButtonMotorOff.setEnabled(false);
}//GEN-LAST:event_jButtonCalibrarColorOffActionPerformed

private void jButtonReloadConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReloadConfigActionPerformed
    config.read();
}//GEN-LAST:event_jButtonReloadConfigActionPerformed

private void chart2D1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chart2D1MouseMoved
    TracePoint2D tracePoint2D=chart2D1.getNearestPointManhattan(evt);
    if (tracePoint2D!=null) {//GEN-LAST:event_chart2D1MouseMoved
        //jLabelX.setText(String.valueOf(tracePoint2D.getX()));
        jLabelY.setText(String.valueOf(tracePoint2D.getY()));    
    } else {
        //jLabelX.setText("N/A");
        jLabelY.setText("N/A");        
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private info.monitorenter.gui.chart.Chart2D chart2D1;
    private javax.swing.JButton jButtonCalibrarColorOff;
    private javax.swing.JButton jButtonCalibrarColorOn;
    private javax.swing.JButton jButtonCalibrarPosicionOff;
    private javax.swing.JButton jButtonCalibrarPosicionOn;
    private javax.swing.JButton jButtonMotorAvanzar;
    private javax.swing.JButton jButtonMotorOff;
    private javax.swing.JButton jButtonMotorRetroceder;
    private javax.swing.JButton jButtonReloadConfig;
    private javax.swing.JLabel jLabelY;
    // End of variables declaration//GEN-END:variables
}

class ObtenerDatosPosicion extends TimerTask {

    Calibrar calibrar;

    ObtenerDatosPosicion(Calibrar calibrar) {
        this.calibrar = calibrar;
    }

    @Override
    public void run() {
        calibrar.traceInicio = new Trace2DSimple("Inicio");
        calibrar.traceColor = new Trace2DSimple("Color");
        calibrar.traceSalida1 = new Trace2DSimple("Salida1");
        calibrar.traceSalida2 = new Trace2DSimple("Salida2");

        calibrar.traceInicio.setColor(Color.RED);
        calibrar.traceColor.setColor(Color.BLUE);
        calibrar.traceSalida1.setColor(Color.GREEN);
        calibrar.traceSalida2.setColor(Color.BLACK);


        calibrar.mc.motorOn(1, MotorDirection.Forward, 255);
        int i = 0;
        while (calibrar.calibrarOn == true) {
            int posicionInicio = calibrar.mc.analogRead(1);
            int posicionColor = calibrar.mc.analogRead(2);
            int posicionSalida1 = calibrar.mc.analogRead(3);
            int posicionSalida2 = calibrar.mc.analogRead(4);
            calibrar.traceInicio.addPoint(i, posicionInicio);
            calibrar.traceColor.addPoint(i, posicionColor);
            calibrar.traceSalida1.addPoint(i, posicionSalida1);
            calibrar.traceSalida2.addPoint(i, posicionSalida2);

            i++;
        }
        calibrar.mc.motorOff(1);



    }
}

class ObtenerDatosColor extends TimerTask {

    Calibrar calibrar;
    Config config;

    ObtenerDatosColor(Calibrar calibrar, Config config) {
        this.calibrar = calibrar;
        this.config = config;
    }

    @Override
    public void run() {
        calibrar.traceColor = new Trace2DSimple("Color");
        calibrar.traceColor.setColor(Color.RED);



        calibrar.mc.motorOnAnalog(1, MotorDirection.Forward, 255, 2, config.getLowerLimitSensorPosicionColor(), config.getUpperLimitSensorPosicionColor());

        int i = 0;
        while (calibrar.calibrarOn == true) {
            int color = calibrar.mc.ligthSensorRead(0);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }            
            calibrar.traceColor.addPoint(i, color);
            i++;
        }




    }
}
