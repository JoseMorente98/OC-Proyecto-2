/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupo11.model;

/**
 *
 * @author Juan José Ramos
 */
public class Bomb {
    private int row;
    private int column;
    private int time;
    private int timeExplosion;

    public Bomb() {
    }

    public Bomb(int row, int column) {
        this.row = row;
        this.column = column;
        this.time = 3;
        this.timeExplosion = 0;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTimeExplosion() {
        return timeExplosion;
    }

    public void setTimeExplosion(int timeExplosion) {
        this.timeExplosion = timeExplosion;
    }
    
    
}
