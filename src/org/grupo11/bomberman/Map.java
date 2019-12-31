/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupo11.bomberman;

import org.grupo11.model.Element;

/**
 *
 * @author Juan José Ramos
 */
public class Map {
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
        Element objs=new Element(false, false, false, false, false, false, false);
        
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
            case 'B':
                objs.setBrick(true);
                break;
        }
        
        LoggedUser.BACK_MAP[fila][columna] = objs;
               
    }
    
    public void FrontMap(){
        LoggedUser.FRONT_MAPA = new String[12][12];
        
        for (int i = 0; i < LoggedUser.BACK_MAP.length; i++) {
            for (int j = 0; j < LoggedUser.BACK_MAP[i].length; j++) {
                
                if (LoggedUser.BACK_MAP[i][j].isPlayer()) {
                    LoggedUser.FRONT_MAPA[i][j] = "J";
                }
                else if (LoggedUser.BACK_MAP[i][j].isEnemy()) {
                    LoggedUser.FRONT_MAPA[i][j] = "E";
                }
                else if (LoggedUser.BACK_MAP[i][j].isBrick()&& LoggedUser.BACK_MAP[i][j].isBonus()) {
                    LoggedUser.FRONT_MAPA[i][j] = "B";
                }
                else if (LoggedUser.BACK_MAP[i][j].isBrick()) {
                    LoggedUser.FRONT_MAPA[i][j] = "X";
                }
                else if (LoggedUser.BACK_MAP[i][j].isBomb()) {
                    LoggedUser.FRONT_MAPA[i][j] = "O";
                }
                
                else if (LoggedUser.BACK_MAP[i][j].isExplocion() && LoggedUser.BACK_MAP[i][j].isPlayer()) {
                    LoggedUser.FRONT_MAPA[i][j] = "J";
                }
                
                else if (LoggedUser.BACK_MAP[i][j].isExplocion()) {
                    LoggedUser.FRONT_MAPA[i][j] = "Ñ";
                }
                else if (LoggedUser.BACK_MAP[i][j].isKey()) {
                    LoggedUser.FRONT_MAPA[i][j] = "L";
                }
            }
        }
        
    }
    
}
