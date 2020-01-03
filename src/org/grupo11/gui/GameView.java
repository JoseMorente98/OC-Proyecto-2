/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupo11.gui;

//import org.grupo11.bomberman.Juego;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import org.grupo11.bomberman.LoggedUser;
import org.grupo11.bomberman.Map;
import org.grupo11.bomberman.ThreadGame;

/**
 *
 * @author Jose Morente
 */
public class GameView extends javax.swing.JFrame {

    /**
     * PROPIEDADES JUEGO
     */
    KeyListener kl;

    /**
     * Creates new form Bomberman
     */
    public GameView() {
        //userText.setText(LoggedUser.Nsesion);
        initComponents();
        /*LoggedUser.tgame.life = 3;
        try {
            LoggedUser.tgame = new ThreadGame(jTable1, life, time);
        } catch (Exception e) {
        }
        */
        
        //LoggedUser.tgame.start();
        LoggedUser.tgame.life = 3;
        LoggedUser.tgame = new ThreadGame(jTable1,life,time);

        kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                System.out.print("entro");
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                //IZQUIEDA
                    ThreadGame.movement = 1;
                    System.out.println("IZQUIEDA");
                }
            if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                //DERCHA
                    ThreadGame.movement = 2;
                    System.out.println("DERCHA");
                }
            if (ke.getKeyCode() == KeyEvent.VK_UP) {
                //ARRIBA
                    ThreadGame.movement = 3;
                    System.out.println("ARRIBA");
                }
            if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                //ABAJO
                    ThreadGame.movement = 4;
                    System.out.println("ABAJO");
                }
            if (ke.getKeyCode() == KeyEvent.VK_P) {
                //ABAJO
                    ThreadGame.movement = 5;
                    System.out.println("PAUSA");
                }
            if (ke.getKeyCode() == KeyEvent.VK_A) {
                //BOMBA (A)
                    ThreadGame.movement = 6;
                    System.out.println("BOMBA");
                }
            
            }
            
        };
        this.addKeyListener(kl);
        
        //Mostrar();
        LoggedUser.tgame.start();
                

    }
    
    public void initGame() {
        LoggedUser.tgame.life = 3;
        LoggedUser.tgame = new ThreadGame(jTable1, life, time);
        kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                System.out.println(ke);
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                System.out.print("entro");
                System.out.println(ke);
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                System.out.print(ke);
            if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                //IZQUIEDA
                    ThreadGame.movement = 1;
                    System.out.println("IZQUIEDA");
                }
            if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                //DERCHA
                    ThreadGame.movement = 2;
                    System.out.println("DERCHA");
                }
            if (ke.getKeyCode() == KeyEvent.VK_UP) {
                //ARRIBA
                    ThreadGame.movement = 3;
                    System.out.println("ARRIBA");
                }
            if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                //ABAJO
                    ThreadGame.movement = 4;
                    System.out.println("ABAJO");
                }
            if (ke.getKeyCode() == KeyEvent.VK_P) {
                //ABAJO
                    ThreadGame.movement = 5;
                    System.out.println("PAUSA");
                }
            if (ke.getKeyCode() == KeyEvent.VK_A) {
                //BOMBA (A)
                    ThreadGame.movement = 6;
                    System.out.println("BOMBA");
                }
            
            }
            
        };
        jTable1.addKeyListener(kl);
        //Mostrar();
        LoggedUser.tgame.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        userText = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        life = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        usrText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1240, 740));
        setResizable(false);
        setSize(new java.awt.Dimension(1240, 740));
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Life");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(970, 540, 40, 30);

        userText.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        userText.setForeground(new java.awt.Color(255, 255, 255));
        userText.setText("User");
        getContentPane().add(userText);
        userText.setBounds(970, 500, 50, 30);

        time.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("--");
        getContentPane().add(time);
        time.setBounds(1030, 570, 80, 30);

        start.setText("jButton1");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        getContentPane().add(start);
        start.setBounds(980, 610, 79, 25);

        life.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        life.setForeground(new java.awt.Color(255, 255, 255));
        life.setText("--");
        getContentPane().add(life);
        life.setBounds(1030, 540, 80, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Time");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(970, 570, 80, 30);

        usrText.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        usrText.setForeground(new java.awt.Color(255, 255, 255));
        usrText.setText("--");
        getContentPane().add(usrText);
        usrText.setBounds(1030, 500, 80, 30);

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
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
        jTable1.setFocusable(false);
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setMaximumSize(new java.awt.Dimension(0, 0));
        jTable1.setMinimumSize(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(50);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 720, 720);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/grupo11/recursos/Juego.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 720);

        jMenuBar1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N

        jMenu1.setText("Juego");
        jMenu1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jMenuItem1.setText("Nuevo Juego");
        jMenuItem1.setToolTipText("");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jMenuItem4.setText("Cargar Archivo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");
        jMenu2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jMenuItem2.setText("Documentación");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jMenuItem3.setText("Acerca De");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String auxiliar = "";
        String text = "";
        String rute = "";

        JFileChooser JfC = new JFileChooser();
        JfC.setAcceptAllFileFilterUsed(false);
        //JfC.setFileFilter(new FileNameExtensionFilter("Archivos con extension *." + Filtro_Archivo, Filtro_Archivo));
        JfC.setCurrentDirectory(new File("Desktop"));
        JfC.showOpenDialog(null);
        File Archivo = JfC.getSelectedFile();
        if (Archivo != null) {
            rute = "" + Archivo;
            FileReader FR;
            try {
                FR = new FileReader(Archivo);

                try (BufferedReader Buffer = new BufferedReader(FR)) {
                    while ((auxiliar = Buffer.readLine()) != null) {
                        text += auxiliar + "\n";
                    }
//                    System.out.println(texto);
                } catch (IOException e) {
                    System.out.println("ERROR");
                }

                LoggedUser.MUNDO = text;

                Map mapa = new Map();
                mapa.CreateMap();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.initGame();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        
       
        Game game = new Game();
        game.setVisible(true);

    }//GEN-LAST:event_startActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        //INICIAR JUEGO
                this.initGame();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Metal look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Metal (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameView().setVisible(true);
            }
        });

    }

    /*
	|--------------------------------------------------------------------------
	| Game Related
	|--------------------------------------------------------------------------
     */
 /*  public void newGame() {
        _game.getBoard().newJuego();
    }

    public void changeLevel(int i) {
            _game.getBoard().changeLevel(i);
    }

    public void pauseGame() {
            _game.getBoard().gamePause();
    }

    public void resumeGame() {
            _game.getBoard().gameResume();
    }

    public boolean isRunning() {
            return _game.isRunning();
    }
     */
    //MOSTRAR TIEMPO
    public void setTime(int time) {
        this.jLabel3.setText(String.valueOf(time));
    }

    //MOSTRAR VIDAS
    public void setLives(int lives) {
        this.userText.setText(String.valueOf(lives));
    }

    //MOSTRAR PUNTOS
    public void setPoints(int points) {
        this.userText.setText(String.valueOf(points));
    }

    /*public boolean validCode(String str) {
            return _game.getBoard().getLevel().validCode(str) != -1;
    }

    public void changeLevelByCode(String str) {
            _game.getBoard().changeLevelByCode(str);
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel life;
    private javax.swing.JButton start;
    private javax.swing.JLabel time;
    private javax.swing.JLabel userText;
    private javax.swing.JLabel usrText;
    // End of variables declaration//GEN-END:variables
}
