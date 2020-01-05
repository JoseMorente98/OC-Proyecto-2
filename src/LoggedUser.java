/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author Juan José Ramos
 */
public class LoggedUser {
    public static String Nsesion;
    public static String MUNDO;
  
    public static String[][] FRONT_MAPA;
    public static Element[][] BACK_MAP;
    
    public static ArrayList<User> solicitud = new ArrayList<>();
    public static ArrayList<User> registro = new ArrayList<>();
    
    public static ArrayList<Results> puntos = new ArrayList<Results>();
    
    public static ThreadGame tgame = new ThreadGame();
    //public static ThreadMatrix tmatrix = new ThreadMatrix("Hilo");
   
    
    public static User userL = null;
    
    
    public static String [][] Pausa =
    {
        {"X"," "," "," "," "," "," "," "," ","X"," "," "},
        {"X"," "," "," "," "," "," "," "," ","X"," "," "},
        {"X"," "," "," "," "," "," "," "," ","X"," "," "},
        {"X"," "," "," "," "," "," "," "," ","X"," "," "},
        {"X"," "," "," "," "," "," "," "," ","X"," "," "},
        {"X"," "," "," "," "," "," "," "," ","X"," "," "},
        {"X"," "," "," "," "," "," "," "," ","X"," "," "},
        {"X"," "," "," "," "," "," "," "," ","X"," "," "},
        {"X"," "," "," "," "," "," "," "," ","X"," "," "},
        {"X"," "," "," "," "," "," "," "," ","X"," "," "},
        {"X"," "," "," "," "," "," "," "," ","X"," "," "},
        {"X","X","X"," "," "," "," ","X","X","X","X","X"}
    };
    
    public void getData(String usr, String pass){
        this.userL = new User(usr, pass);
    }
    
    public User getDataUser(){
        return this.userL;
    }
    
    
}
