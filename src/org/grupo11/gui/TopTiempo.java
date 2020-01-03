/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupo11.gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.grupo11.bomberman.LoggedUser;
import org.grupo11.model.Results;
import org.grupo11.model.User;

/**
 *
 * @author Javier C
 */
public class TopTiempo extends javax.swing.JFrame {

    /**
     * Creates new form ListUsers
     */
    DefaultTableModel mos;
    String data[][] = {};
    String cabeza[] = {"Usuario", "Tiempo"};

    public TopTiempo() {
        initComponents();
        mos = new DefaultTableModel(data, cabeza);
        jTable1.setModel(mos);
        inicial();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 740));
        setSize(new java.awt.Dimension(1280, 740));
        getContentPane().setLayout(null);

        jTable1.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 210, 700, 400);

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 130)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOP 10 Tiempos");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 50, 920, 160);

        jButton1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jButton1.setText("<< Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 620, 200, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/grupo11/recursos/Listas.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        Administrador administrador = new Administrador();
        administrador.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TopTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TopTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TopTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TopTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TopTiempo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void inicial() {
        try {

            Collections.sort(LoggedUser.puntos, new Comparator<Results>() {
                @Override
                public int compare(Results o1, Results o2) {
                    return new Integer(o1.getTime()).compareTo(new Integer(o2.getTime()));
                }
            });
            printArrayListResults();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo ha ocurrido mal");
        }
    }

    private void printArrayListResults() {
        int conteo = 0;
        String acumulador = "";
        if (LoggedUser.puntos.size() != 0) {
            for (Results result : LoggedUser.puntos) {
                String usuario[] = {result.getUser(), String.valueOf(result.getTime())};
                if (conteo < 11) {
                    acumulador = acumulador + "*****Jugador: " + result.getUser() + "   ***** Tiempo: " + result.getTime() + "\n";
                    mos.addRow(usuario);
                }

            }
        }

        File f;
        f = new File("C:\\ProyectoOrga\\tiempo.rep");
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(acumulador);//escribimos en el archivo 
            //wr.append(" - y aqui continua"); //concatenamos en el archivo sin borrar lo existente
            //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
            //de no hacerlo no se escribirá nada en el archivo
            wr.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("error");
        };
    }
}
