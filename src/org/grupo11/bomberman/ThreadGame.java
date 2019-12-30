/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupo11.bomberman;


import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import org.grupo11.model.Bomb;
/**
 *
 * @author Juan José Ramos
 */
public class ThreadGame extends Thread{
    //Mapa mapa=new Mapa();
    
    ArrayList<Bomb> arrayBomb =new ArrayList<Bomb>();
    
    private JTable jTable;
    private JLabel jLife;
    private JLabel jTime;
    
    public static int movement = 0;
    public  int life = 3;
    
    public  boolean pausa = false;
    
    public  boolean bonus = false;
    public  int bomba;
    public int explosion=1;
    
    public  int tiempo = 0;
    public  int tiempoEspera = 0;
    public  int nivel=1;
    
    Random rn1;
    Random rn2;
    
    public ThreadGame(){}

    public ThreadGame(JTable jTable, JLabel jLife, JLabel jTime) {
        this.jTable = jTable;
        this.jLife = jLife;
        this.jTime = jTime;
    }
    
    public ThreadGame(String msg){
        super(msg);
    }
    
    
    @Override
    public void run(){
        //CrearEnemigo();
        jLife.setText(Integer.toString(life));
        
        while (life>0) {
            try {

                if (pausa == false) {
                    //Jugador();
                    //Enemigo();
                    //Bomba();
                    //Mostrar();
                    
                    
                    tiempoEspera +=100;
                    jTime.setText(Integer.toString((tiempo+=100)/1000));
                }else{
                    //Pausa();
                }
                
                ThreadGame.sleep(100);  //SALTOS CAD 1.0 s
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
            if(life == 0){
                //LoggedUser.hilo.stop();
            }
    }
    
    
    /*
    public void Jugador(){
        for (int i = 0; i < LoggedUser.BACK_MAP.length; i++) {
            for (int j = 0; j < LoggedUser.BACK_MAP[i].length; j++) {
                if (LoggedUser.BACK_MAP[i][j].isJugador()) {
                    switch(movement){
                        case 1:
                            // IZQUIERDA
                            MoverJugador(i, j, i, j-1);
                            break;
                        case 2:
                            //  DERECHA
                            MoverJugador(i, j, i, j+1);
                            break;
                        case 3:
                            //  ARRIBA
                            MoverJugador(i, j, i-1, j);
                            break;
                        case 4:
                            //  ABAJO
                            MoverJugador(i, j, i+1, j);
                            break;
                        case 5:
                            //  PAUSA
                            Pausa();
                            break;
                        case 6:
                            //  BOMBA
                            LBomba.add(new Bomba(i, j));
                            break;
                    }
                }
            }
        }
    }
    
    public void MoverJugador(int afila, int acolum, int dfila, int dcolum){
        try{
            if (LoggedUser.BACK_MAP[dfila][dcolum].isBomba() || LoggedUser.BACK_MAP[dfila][dcolum].isLadrillo()) {
                //  NO SE MUEVE
            }
            else if (LoggedUser.BACK_MAP[dfila][dcolum].isEnemigo()) {
                //  NO SE MUEVE Y RECIVE DAÑO
                life--;
                jLife.setText(Integer.toString(life));
            }
            else if (LoggedUser.BACK_MAP[dfila][dcolum].isExplocion()) {
                //  SE MUEVE Y RECIVE DAÑO
                LoggedUser.BACK_MAP[afila][acolum].setJugador(false);
                LoggedUser.BACK_MAP[dfila][dcolum].setJugador(true);
            }
            else if (LoggedUser.BACK_MAP[dfila][dcolum].isBonus()) {
                //  SE MUEVE Y RECIVE BONUS
                LoggedUser.BACK_MAP[dfila][dcolum].setBonus(false);
                bonus = true;
                bomba = 3;
                
                LoggedUser.BACK_MAP[afila][acolum].setJugador(false);
                LoggedUser.BACK_MAP[dfila][dcolum].setJugador(true);
                
            }
            else if (LoggedUser.BACK_MAP[dfila][dcolum].isKey()) {
                //  GANA NIVEL
                LoggedUser.BACK_MAP[afila][acolum].setBonus(false);
                bonus = false;
                bomba=0;
                explosion=1;
                
                nivel++;
                
                //LoggedUser.BACK_MAP[afila][acolum].setJugador(false);
                //LoggedUser.BACK_MAP[dfila][dcolum].setJugador(true);
                life=3;
                jLife.setText(Integer.toString(life));
                CrearEnemigo();
            }
            else if (afila == dfila && acolum == dcolum) {
                //  GANA NIVEL
                LoggedUser.BACK_MAP[afila][acolum].setBomba(true);
            }
            else {
                //  SE MUEVE
                LoggedUser.BACK_MAP[afila][acolum].setJugador(false);
                LoggedUser.BACK_MAP[dfila][dcolum].setJugador(true);
            }
        }catch(Exception e){
            System.out.println("FALLO movement");
        }
        movement=0;
    }
    
    public void Mostrar(){
        try {
            mapa.FrontMap();
            
            getjTable().setModel(new javax.swing.table.DefaultTableModel(
                LoggedUser.FRONT_MAPA,
                new String [] {
                    "","","","","","","","","","","",""
                }
            ));
        } catch (Exception e) {
            System.out.println("FALLO MODELO");
        }
    }
    
    
    
    public void Pausa(){
        if (pausa == true && movement == 5) {
            pausa = false;
        }
        else if (pausa == false && movement == 5) {
            pausa = true;
        }
        
        MostrarPausa();
        movement = 0;
    }
    
    public void MostrarPausa(){
        try {
            getjTable().setModel(new javax.swing.table.DefaultTableModel(
                LoggedUser.Pausa,
                new String [] {
                    "","","","","","","","","","","",""
                }
            ));
        } catch (Exception e) {
            System.out.println("FALLO MODELO");
        }
    }
    
    
    
    public void CrearEnemigo(){
        Mapa MAPA=new Mapa();
        MAPA.CrearMapa();
        
        double enemigo = Math.pow(2, nivel);
        
        for (int i = 0; i < enemigo; i++) {
            rn1=new Random();
            rn2=new Random();
            MostrarEnenmigo();
        }
    }
    
    public void MostrarEnenmigo(){
            
            int fila = rn1.nextInt(12);
            int columna = rn2.nextInt(12);
            
        try {
            
            while (LoggedUser.BACK_MAP[fila][columna].isVacio()==true) {
                System.out.println("CREANDO ENEMIGO...");
            fila = rn1.nextInt(12);
            columna = rn2.nextInt(12);
            }
            
                LoggedUser.BACK_MAP[fila][columna].setEnemigo(true);
                System.out.println("ENEMIGO CREADO");
            
        } catch (Exception e) {
            System.out.println("ENEMIGO NO CREADO");
        }
    }
    
    public void Enemigo(){
        
        if (tiempoEspera==1000) {
            
            for (int i = 0; i < LoggedUser.BACK_MAP.length; i++) {
            for (int j = 0; j < LoggedUser.BACK_MAP[i].length; j++) {
                if (LoggedUser.BACK_MAP[i][j].isEnemigo()) {
                    
                    rn1 = new Random();
                    int MoverE = 1+rn1.nextInt(5);
                    
                    switch(MoverE){
                        case 1:
                            // IZQUIERDA
                            MoverEnemigo(i, j, i, j-1);
                            break;
                        case 2:
                            //  DERECHA
                            MoverEnemigo(i, j, i, j+1);
                            break;
                        case 3:
                            //  ARRIBA
                            MoverEnemigo(i, j, i-1, j);
                            break;
                        case 4:
                            //  ABAJO
                            MoverEnemigo(i, j, i+1, j);
                            break;
                        }
                    }
                }
            }
            tiempoEspera = 0;
        }
        
        
    }
    
    public void MoverEnemigo(int afila, int acolum, int dfila, int dcolum){
        try{
            if (LoggedUser.BACK_MAP[dfila][dcolum].isBomba() || LoggedUser.BACK_MAP[dfila][dcolum].isLadrillo()) {
                //  NO SE MUEVE
            }
            else if (LoggedUser.BACK_MAP[dfila][dcolum].isJugador()) {
                //  NO SE MUEVE E INFLINGE DAÑO
                life--;
                jLife.setText(Integer.toString(life));
            }
            else if (LoggedUser.BACK_MAP[dfila][dcolum].isExplocion()) {
                //  SE MUEVE Y DESAPAERECE
                LoggedUser.BACK_MAP[afila][acolum].setEnemigo(false);
            }
            else if (LoggedUser.BACK_MAP[dfila][dcolum].isBonus()) {
                //  NO SE MUEVE
            }
            else if (LoggedUser.BACK_MAP[dfila][dcolum].isKey()) {
                //  NO SE MUEVE
            }
            else {
                //  SE MUEVE
                LoggedUser.BACK_MAP[afila][acolum].setEnemigo(false);
                LoggedUser.BACK_MAP[dfila][dcolum].setEnemigo(true);
            }
        }catch(Exception e){
            System.out.println("FALLO movement ENEMIGO");
        }
    }
    
    
    public void Bomba(){
        int ContadorB = 0; 
        for (Bomba bomb : LBomba) {
            
          bomb.setTEBomba(bomb.getTEBomba()+100);
          
                    if (LoggedUser.BACK_MAP[bomb.getFila()][bomb.getColumna()].isBomba()){
                            LoggedUser.BACK_MAP[bomb.getFila()][bomb.getColumna()].setBomba(false);
                    }
                    else{
                        LoggedUser.BACK_MAP[bomb.getFila()][bomb.getColumna()].setBomba(true);
                    }                
          
            if (bomb.getTEBomba()==1000) {
                
                bomb.setTiempo(bomb.getTiempo()-1);
                    bomb.setTEBomba(0);
                    
                if (bomb.getTiempo()==0) {
                    LoggedUser.BACK_MAP[bomb.getFila()][bomb.getColumna()].setBomba(false);
                    Explosion(bomb.getFila(),bomb.getColumna());
                    return;
                }
            }
            ContadorB++;
        }
    }
    
    public void Explosion(int fila, int columna){
        
        try {
            LoggedUser.BACK_MAP[fila][columna].setExplocion(true);
            
            if (LoggedUser.BACK_MAP[fila][columna].isExplocion() && LoggedUser.BACK_MAP[fila][columna].isEnemigo()) {
                LoggedUser.BACK_MAP[fila][columna].setEnemigo(false);
            }
            else if (LoggedUser.BACK_MAP[fila][columna].isExplocion() && LoggedUser.BACK_MAP[fila][columna].isLadrillo()) {
                LoggedUser.BACK_MAP[fila][columna].setLadrillo(false);
            }
            else if (LoggedUser.BACK_MAP[fila][columna].isExplocion() && LoggedUser.BACK_MAP[fila][columna].isJugador()) {
                life--;
                jLife.setText(Integer.toString(life));
            }
        } catch (Exception e) {
            System.out.println("ERROR EXPLOSION CENTRO");
        }
        
        try {
            LoggedUser.BACK_MAP[fila-explosion][columna].setExplocion(true);
            
            if (LoggedUser.BACK_MAP[fila-explosion][columna].isExplocion() && LoggedUser.BACK_MAP[fila-explosion][columna].isEnemigo()) {
                LoggedUser.BACK_MAP[fila-explosion][columna].setEnemigo(false);
            }
            else if (LoggedUser.BACK_MAP[fila-explosion][columna].isExplocion() && LoggedUser.BACK_MAP[fila-explosion][columna].isLadrillo()) {
                LoggedUser.BACK_MAP[fila-explosion][columna].setLadrillo(false);
            }
            else if (LoggedUser.BACK_MAP[fila-explosion][columna].isExplocion() && LoggedUser.BACK_MAP[fila-explosion][columna].isJugador()) {
                life--;
                jLife.setText(Integer.toString(life));
            }
        } catch (Exception e) {
            System.out.println("ERROR EXPLOSION IZQUIERDDA");
        }
        
        try {
            LoggedUser.BACK_MAP[fila+explosion][columna].setExplocion(true);
            
            if (LoggedUser.BACK_MAP[fila+explosion][columna].isExplocion() && LoggedUser.BACK_MAP[fila+explosion][columna].isEnemigo()) {
                LoggedUser.BACK_MAP[fila+explosion][columna].setEnemigo(false);
            }
            else if (LoggedUser.BACK_MAP[fila+explosion][columna].isExplocion() && LoggedUser.BACK_MAP[fila+explosion][columna].isLadrillo()) {
                LoggedUser.BACK_MAP[fila+explosion][columna].setLadrillo(false);
            }
            else if (LoggedUser.BACK_MAP[fila+explosion][columna].isExplocion() && LoggedUser.BACK_MAP[fila+explosion][columna].isJugador()) {
                life--;
                jLife.setText(Integer.toString(life));
            }
        } catch (Exception e) {
            System.out.println("ERROR EXPLOSION DERECHA");
        }
        
        try {
            LoggedUser.BACK_MAP[fila][columna-explosion].setExplocion(true);
            
            if (LoggedUser.BACK_MAP[fila][columna-explosion].isExplocion() && LoggedUser.BACK_MAP[fila][columna-explosion].isEnemigo()) {
                LoggedUser.BACK_MAP[fila][columna-explosion].setEnemigo(false);
            }
            else if (LoggedUser.BACK_MAP[fila][columna-explosion].isExplocion() && LoggedUser.BACK_MAP[fila][columna-explosion].isLadrillo()) {
                LoggedUser.BACK_MAP[fila][columna-explosion].setLadrillo(false);
            }
            else if (LoggedUser.BACK_MAP[fila][columna-explosion].isExplocion() && LoggedUser.BACK_MAP[fila][columna-explosion].isJugador()) {
                life--;
                jLife.setText(Integer.toString(life));
            }
        } catch (Exception e) {
            System.out.println("ERROR EXPLOSION ARRIBA");
        }
        
        try {
            LoggedUser.BACK_MAP[fila][columna+explosion].setExplocion(true);
            
            if (LoggedUser.BACK_MAP[fila][columna+explosion].isExplocion() && LoggedUser.BACK_MAP[fila][columna+explosion].isEnemigo()) {
                LoggedUser.BACK_MAP[fila][columna+explosion].setEnemigo(false);
            }
            else if (LoggedUser.BACK_MAP[fila][columna+explosion].isExplocion() && LoggedUser.BACK_MAP[fila][columna+explosion].isLadrillo()) {
                LoggedUser.BACK_MAP[fila][columna+explosion].setLadrillo(false);
            }
            else if (LoggedUser.BACK_MAP[fila][columna+explosion].isExplocion() && LoggedUser.BACK_MAP[fila][columna+explosion].isJugador()) {
                life--;
                jLife.setText(Integer.toString(life));
            }
        } catch (Exception e) {
            System.out.println("ERROR EXPLOSION ABAJO");
        }
        
        for (int i = 0; i < LoggedUser.BACK_MAP.length; i++) {
            for (int j = 0; j < LoggedUser.BACK_MAP[i].length; j++) {
                if (LoggedUser.BACK_MAP[i][j].isExplocion()) {
                    LoggedUser.BACK_MAP[i][j].setExplocion(false);
                }
            }
        }
        
        LBomba.removeFirst();
    }
    */
    /**
     * @return the jTable
     */
    public JTable getjTable() {
        return jTable;
    }

    /**
     * @param jTable the jTable to set
     */
    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    /**
     * @return the jLife
     */
    public JLabel getjLife() {
        return jLife;
    }

    /**
     * @param jLife the jLife to set
     */
    public void setjLife(JLabel jLife) {
        this.jLife = jLife;
    }

    /**
     * @return the jTime
     */
    public JLabel getjTime() {
        return jTime;
    }

    /**
     * @param jTime the jTime to set
     */
    public void setjTime(JLabel jTime) {
        this.jTime = jTime;
    }
}
