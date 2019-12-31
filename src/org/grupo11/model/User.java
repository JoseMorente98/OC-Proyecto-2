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
public class User {
    private String username;
    private String password;
    private boolean aprovacion;
    
    public User(){
    }
    
    public User(String usr, String pass){
        this.username = usr;
        this.password = pass;
        this.aprovacion = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAprovacion() {
        return aprovacion;
    }

    public void setAprovacion(boolean aprovacion) {
        this.aprovacion = aprovacion;
    }
    
}
