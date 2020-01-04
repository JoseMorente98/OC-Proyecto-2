
import java.util.Timer;
import java.util.TimerTask;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Juan José Ramos
 */
public class Map {


    
    public Map() {
      
    }
        
    public void CreateMap(){
        LoggedUser.BACK_MAP = new Element[12][12];
        
        String [] linea = LoggedUser.MUNDO.split("\n");
        char [] objeto;
        
        for (int i = 0; i < linea.length; i++) {
            objeto = linea[i].toCharArray();
            for (int j = 0; j < objeto.length; j++) {
                BoolObjeto(i, j, objeto[j]);
            }
        }
        
        FrontMap();
    }
    
    public void BoolObjeto(int fila, int columna, char objeto){
        
        
        Element objs=new Element(false, false, false, false, false, false, false, false);
        
        switch(objeto){
            case 'X':
                objs.setBrick(true);
                break;
            case 'J':
                objs.setPlayer(true);
                break;
            case 'E':
                objs.setEnemy(true);
                break;
            case 'L':
                objs.setKey(true);
                break;
            case ' ':
                objs.setSpace(true);
                break;
            case 'B':
                objs.setBonus(true);
                break;
        }
        
        LoggedUser.BACK_MAP[fila][columna] = objs;
               
    }
    
    public void FrontMap(){
        //System.out.print("ENTRO AL FRONT MAP");
        LoggedUser.FRONT_MAPA = new String[12][12];
        //for (int x = 0; x < 500; x++) {
            for (int i = 0; i < 12; i++) {
                //System.out.println(i);
                for (int j = 0; j < 12; j++) {
                    if (LoggedUser.BACK_MAP[i][j].isPlayer()) {
                        LoggedUser.FRONT_MAPA[i][j] = "J";
                    }
                    else if (LoggedUser.BACK_MAP[i][j].isEnemy()) {
                        LoggedUser.FRONT_MAPA[i][j] = "E";
                    }
                    else if (LoggedUser.BACK_MAP[i][j].isBonus()) {
                        LoggedUser.FRONT_MAPA[i][j] = "B";
                        /*port.setPin((short) 2, (short) 1); 
                        port.setPin((short) 3, (short) 1);
                        port.setPin((short) 3, (short) 0);*/
                       //reloj(3,0,200);

                    }
                    else if (LoggedUser.BACK_MAP[i][j].isBrick()) {
                        LoggedUser.FRONT_MAPA[i][j] = "X";
                        /*port.setPin((short) 2, (short) 1);
                        port.setPin((short) 3, (short) 1);
                        port.setPin((short) 3, (short) 0);*/
                        //reloj(3,0,200);

                    }
                    else if (LoggedUser.BACK_MAP[i][j].isBomb()) {
                        LoggedUser.FRONT_MAPA[i][j] = "O";
                        /*port.setPin((short) 2, (short) 1); 
                        port.setPin((short) 3, (short) 1);
                        port.setPin((short) 3, (short) 0);*/
                       //reloj(3,0,200);

                    }

                    else if (LoggedUser.BACK_MAP[i][j].isExplocion() && LoggedUser.BACK_MAP[i][j].isPlayer()) {
                        LoggedUser.FRONT_MAPA[i][j] = "J";
                        /*port.setPin((short) 2, (short) 1); 
                        port.setPin((short) 3, (short) 1);
                        port.setPin((short) 3, (short) 0);*/
                       //reloj(3,0,200);

                    }
                    else if (LoggedUser.BACK_MAP[i][j].isExplocion() && LoggedUser.BACK_MAP[i][j].isBonus()) {
                        LoggedUser.FRONT_MAPA[i][j] = "B";
                        /*port.setPin((short) 2, (short) 1); 
                        port.setPin((short) 3, (short) 1);
                        port.setPin((short) 3, (short) 0);*/
                       //reloj(3,0,200);

                    }
                    else if (LoggedUser.BACK_MAP[i][j].isExplocion()) {
                        LoggedUser.FRONT_MAPA[i][j] = "Ñ";
                        /*port.setPin((short) 2, (short) 1); 
                        port.setPin((short) 3, (short) 1);
                        port.setPin((short) 3, (short) 0);*/
                       //reloj(3,0,200);

                    }
                    else if (LoggedUser.BACK_MAP[i][j].isKey()) {
                        LoggedUser.FRONT_MAPA[i][j] = "L";
                        /*port.setPin((short) 2, (short) 1);
                        port.setPin((short) 3, (short) 1);
                        port.setPin((short) 3, (short) 0);*/
                       //reloj(3,0,200);

                    }
                    else if (LoggedUser.BACK_MAP[i][j].isSpace()) {
                        LoggedUser.FRONT_MAPA[i][j] = " ";
                        /*port.setPin((short) 2, (short) 0);
                        port.setPin((short) 3, (short) 1);
                        port.setPin((short) 3, (short) 0);*/
                       //reloj(3,0,200);

                    }
                }
            }
            
        //}
    }
    

    
}
