/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupo11.bomberman;


import java.util.LinkedList;
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
    Map map=new Map();
    
    LinkedList<Bomb> arrayBomb =new LinkedList<Bomb>();
    
    private JTable jTable;
    private JLabel jLife;
    private JLabel jTime;
    
    public static int movement = 0;
    public  int life = 3;
    
    public  boolean pause = false;
    
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
        CreateEnemy();
        jLife.setText(Integer.toString(life));
        
        while (life>0) {
            try {

                if (pause == false) {
                    Player();
                    Enemy();
                    Bomb();
                    Show();
                    
                    
                    tiempoEspera +=100;
                    jTime.setText(Integer.toString((tiempo+=100)/1000));
                }else{
                    //pause();
                }
                
                ThreadGame.sleep(100);  //SALTOS CAD 1.0 s
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
            if(life == 0){
                LoggedUser.tgame.stop();
            }
    }
    
    
    
    public void Player(){
        for (int i = 0; i < LoggedUser.BACK_MAP.length; i++) {
            for (int j = 0; j < LoggedUser.BACK_MAP[i].length; j++) {
                if (LoggedUser.BACK_MAP[i][j].isPlayer()) {
                    switch(movement){
                        case 1:
                            // IZQUIERDA
                            movePlayer(i, j, i, j-1);
                            break;
                        case 2:
                            //  DERECHA
                            movePlayer(i, j, i, j+1);
                            break;
                        case 3:
                            //  ARRIBA
                            movePlayer(i, j, i-1, j);
                            break;
                        case 4:
                            //  ABAJO
                            movePlayer(i, j, i+1, j);
                            break;
                        case 5:
                            //  pause
                            Pause();
                            break;
                        case 6:
                            //  BOMBA
                            arrayBomb.add(new Bomb(i, j));
                            break;
                    }
                }
            }
        }
    }
    
    public void movePlayer(int aRow, int aColumn, int dRow, int dColumn){
        try{
            if (LoggedUser.BACK_MAP[dRow][dColumn].isBomb()|| LoggedUser.BACK_MAP[dRow][dColumn].isBrick()) {
                //  NO SE MUEVE
            }
            else if (LoggedUser.BACK_MAP[dRow][dColumn].isEnemy()) {
                //  NO SE MUEVE Y RECIVE DAÑO
                life--;
                jLife.setText(Integer.toString(life));
            }
            else if (LoggedUser.BACK_MAP[dRow][dColumn].isExplocion()) {
                //  SE MUEVE Y RECIVE DAÑO
                LoggedUser.BACK_MAP[aRow][aColumn].setPlayer(false);
                LoggedUser.BACK_MAP[dRow][dColumn].setPlayer(true);
            }
            else if (LoggedUser.BACK_MAP[dRow][dColumn].isBonus()) {
                //  SE MUEVE Y RECIVE BONUS
                LoggedUser.BACK_MAP[dRow][dColumn].setBonus(false);
                bonus = true;
                bomba = 3;
                
                LoggedUser.BACK_MAP[aRow][aColumn].setPlayer(false);
                LoggedUser.BACK_MAP[dRow][dColumn].setPlayer(true);
                
            }
            else if (LoggedUser.BACK_MAP[dRow][dColumn].isKey()) {
                //  GANA NIVEL
                LoggedUser.BACK_MAP[aRow][aColumn].setBonus(false);
                bonus = false;
                bomba=0;
                explosion=1;
                
                nivel++;
                
                //LoggedUser.BACK_MAP[aRow][aColumn].setPlayer(false);
                //LoggedUser.BACK_MAP[dRow][dColumn].setPlayer(true);
                life=3;
                jLife.setText(Integer.toString(life));
                CreateEnemy();
            }
            else if (aRow == dRow && aColumn == dColumn) {
                //  GANA NIVEL
                LoggedUser.BACK_MAP[aRow][aColumn].setBomb(true);
            }
            else {
                //  SE MUEVE
                LoggedUser.BACK_MAP[aRow][aColumn].setPlayer(false);
                LoggedUser.BACK_MAP[dRow][dColumn].setPlayer(true);
            }
        }catch(Exception e){
            System.out.println("FALLO MOVIMIENTO");
        }
        movement=0;
    }
    
    public void Show(){
        
        
        try {
            map.FrontMap();
            
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
    
    
    
    public void Pause(){
        if (pause == true && movement == 5) {
            pause = false;
        }
        else if (pause == false && movement == 5) {
            pause = true;
        }
        
        ShowPause();
        movement = 0;
    }
    
    public void ShowPause(){
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
    
    
    
    public void CreateEnemy(){
        Map MAP = new Map();
        MAP.CreateMap();
        
        double enemigo = Math.pow(2, nivel);
        
        for (int i = 0; i < enemigo; i++) {
            rn1=new Random();
            rn2=new Random();
            ShowEnemy();
        }
    }
    
    public void ShowEnemy(){
            int fila = rn1.nextInt(12);
            int columna = rn2.nextInt(12);
            
        try {
            
            while (LoggedUser.BACK_MAP[fila][columna].isEmpty()==true) {
                System.out.println("CREANDO ENEMIGO...");
            fila = rn1.nextInt(12);
            columna = rn2.nextInt(12);
            }
            
                LoggedUser.BACK_MAP[fila][columna].setEnemy(true);
                System.out.println("ENEMIGO CREADO");
            
        } catch (Exception e) {
            System.out.println("ENEMIGO NO CREADO");
        }
    }
    
    public void Enemy(){
        
        if (tiempoEspera==1000) {
            
            for (int i = 0; i < LoggedUser.BACK_MAP.length; i++) {
            for (int j = 0; j < LoggedUser.BACK_MAP[i].length; j++) {
                if (LoggedUser.BACK_MAP[i][j].isEnemy()) {
                    
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
    
    public void MoverEnemigo(int aRow, int aColumn, int dRow, int dColumn){
        try{
            if (LoggedUser.BACK_MAP[dRow][dColumn].isBomb()|| LoggedUser.BACK_MAP[dRow][dColumn].isBrick()) {
                //  NO SE MUEVE
            }
            else if (LoggedUser.BACK_MAP[dRow][dColumn].isPlayer()) {
                //  NO SE MUEVE E INFLINGE DAÑO
                life--;
                jLife.setText(Integer.toString(life));
            }
            else if (LoggedUser.BACK_MAP[dRow][dColumn].isExplocion()) {
                //  SE MUEVE Y DESAPAERECE
                LoggedUser.BACK_MAP[aRow][aColumn].setEnemy(false);
            }
            else if (LoggedUser.BACK_MAP[dRow][dColumn].isBonus()) {
                //  NO SE MUEVE
            }
            else if (LoggedUser.BACK_MAP[dRow][dColumn].isKey()) {
                //  NO SE MUEVE
            }
            else {
                //  SE MUEVE
                LoggedUser.BACK_MAP[aRow][aColumn].setEnemy(false);
                LoggedUser.BACK_MAP[dRow][dColumn].setEnemy(true);
            }
        }catch(Exception e){
            System.out.println("FALLO Movimiento ENEMIGO");
        }
    }
    
    
    public void Bomb(){
         int bombs = 0; 
        for (Bomb bomb : arrayBomb) {
            
          bomb.setTimeExplosion(bomb.getTimeExplosion()+100);
          
                    if (LoggedUser.BACK_MAP[bomb.getRow()][bomb.getColumn()].isBomb()){
                            LoggedUser.BACK_MAP[bomb.getRow()][bomb.getColumn()].setBomb(false);
                    }
                    else{
                        LoggedUser.BACK_MAP[bomb.getRow()][bomb.getColumn()].setBomb(true);
                    }                
          
            if (bomb.getTimeExplosion()==1000) {
                
                bomb.setTime(bomb.getTime()-1);
                    bomb.setTimeExplosion(0);
                    
                if (bomb.getTime()==0) {
                    LoggedUser.BACK_MAP[bomb.getRow()][bomb.getColumn()].setBomb(false);
                    Explosion(bomb.getRow(),bomb.getColumn());
                    return;
                }
            }
            bombs++;
        }
    }
    
    public void Explosion(int fila, int columna){
        
        try {
            LoggedUser.BACK_MAP[fila][columna].setExplocion(true);
            
            if (LoggedUser.BACK_MAP[fila][columna].isExplocion() && LoggedUser.BACK_MAP[fila][columna].isEnemy()) {
                LoggedUser.BACK_MAP[fila][columna].setEnemy(false);
            }
            else if (LoggedUser.BACK_MAP[fila][columna].isExplocion() && LoggedUser.BACK_MAP[fila][columna].isBrick()) {
                LoggedUser.BACK_MAP[fila][columna].setBrick(false);
            }
            else if (LoggedUser.BACK_MAP[fila][columna].isExplocion() && LoggedUser.BACK_MAP[fila][columna].isPlayer()) {
                life--;
                jLife.setText(Integer.toString(life));
            }
        } catch (Exception e) {
            System.out.println("ERROR EXPLOSION CENTRO");
        }
        
        try {
            LoggedUser.BACK_MAP[fila-explosion][columna].setExplocion(true);
            
            if (LoggedUser.BACK_MAP[fila-explosion][columna].isExplocion() && LoggedUser.BACK_MAP[fila-explosion][columna].isEnemy()) {
                LoggedUser.BACK_MAP[fila-explosion][columna].setEnemy(false);
            }
            else if (LoggedUser.BACK_MAP[fila-explosion][columna].isExplocion() && LoggedUser.BACK_MAP[fila-explosion][columna].isBrick()) {
                LoggedUser.BACK_MAP[fila-explosion][columna].setBrick(false);
            }
            else if (LoggedUser.BACK_MAP[fila-explosion][columna].isExplocion() && LoggedUser.BACK_MAP[fila-explosion][columna].isPlayer()) {
                life--;
                jLife.setText(Integer.toString(life));
            }
        } catch (Exception e) {
            System.out.println("ERROR EXPLOSION IZQUIERDDA");
        }
        
        try {
            LoggedUser.BACK_MAP[fila+explosion][columna].setExplocion(true);
            
            if (LoggedUser.BACK_MAP[fila+explosion][columna].isExplocion() && LoggedUser.BACK_MAP[fila+explosion][columna].isEnemy()) {
                LoggedUser.BACK_MAP[fila+explosion][columna].setEnemy(false);
            }
            else if (LoggedUser.BACK_MAP[fila+explosion][columna].isExplocion() && LoggedUser.BACK_MAP[fila+explosion][columna].isBrick()) {
                LoggedUser.BACK_MAP[fila+explosion][columna].setBrick(false);
            }
            else if (LoggedUser.BACK_MAP[fila+explosion][columna].isExplocion() && LoggedUser.BACK_MAP[fila+explosion][columna].isPlayer()) {
                life--;
                jLife.setText(Integer.toString(life));
            }
        } catch (Exception e) {
            System.out.println("ERROR EXPLOSION DERECHA");
        }
        
        try {
            LoggedUser.BACK_MAP[fila][columna-explosion].setExplocion(true);
            
            if (LoggedUser.BACK_MAP[fila][columna-explosion].isExplocion() && LoggedUser.BACK_MAP[fila][columna-explosion].isEnemy()) {
                LoggedUser.BACK_MAP[fila][columna-explosion].setEnemy(false);
            }
            else if (LoggedUser.BACK_MAP[fila][columna-explosion].isExplocion() && LoggedUser.BACK_MAP[fila][columna-explosion].isBrick()) {
                LoggedUser.BACK_MAP[fila][columna-explosion].setBrick(false);
            }
            else if (LoggedUser.BACK_MAP[fila][columna-explosion].isExplocion() && LoggedUser.BACK_MAP[fila][columna-explosion].isPlayer()) {
                life--;
                jLife.setText(Integer.toString(life));
            }
        } catch (Exception e) {
            System.out.println("ERROR EXPLOSION ARRIBA");
        }
        
        try {
            LoggedUser.BACK_MAP[fila][columna+explosion].setExplocion(true);
            
            if (LoggedUser.BACK_MAP[fila][columna+explosion].isExplocion() && LoggedUser.BACK_MAP[fila][columna+explosion].isEnemy()) {
                LoggedUser.BACK_MAP[fila][columna+explosion].setEnemy(false);
            }
            else if (LoggedUser.BACK_MAP[fila][columna+explosion].isExplocion() && LoggedUser.BACK_MAP[fila][columna+explosion].isBrick()) {
                LoggedUser.BACK_MAP[fila][columna+explosion].setBrick(false);
            }
            else if (LoggedUser.BACK_MAP[fila][columna+explosion].isExplocion() && LoggedUser.BACK_MAP[fila][columna+explosion].isPlayer()) {
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
        
        arrayBomb.removeFirst();
    }
    
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
