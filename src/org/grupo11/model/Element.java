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
public class Element {
    private boolean player;
    private boolean enemy;
    private boolean bomb;
    private boolean explocion;
    private boolean brick;
    private boolean bonus;
    private boolean key;
    
    private int TBomba;

    public Element() {
    }

    public Element(boolean player, boolean enemy, boolean bomb, boolean explocion, boolean brick, boolean bonus, boolean key) {
        this.player = player;
        this.enemy = enemy;
        this.bomb = bomb;
        this.explocion = explocion;
        this.brick = brick;
        this.bonus = bonus;
        this.key = key;
    }
    public boolean isEmpty(){
        if (player == true && enemy == true && bomb == true && explocion == true
                && brick == true && bonus == true && key == true) {
            return true;
        }
        return false;
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public boolean isEnemy() {
        return enemy;
    }

    public void setEnemy(boolean enemy) {
        this.enemy = enemy;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isExplocion() {
        return explocion;
    }

    public void setExplocion(boolean explocion) {
        this.explocion = explocion;
    }

    public boolean isBrick() {
        return brick;
    }

    public void setBrick(boolean brick) {
        this.brick = brick;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public int getTBomba() {
        return TBomba;
    }

    public void setTBomba(int TBomba) {
        this.TBomba = TBomba;
    }
    
    
}
