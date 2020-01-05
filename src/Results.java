/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Juan José Ramos
 */
public class Results {
    private String user;
    private int points;
    private int time;

    public Results() {
    }

    public Results(String user, int points, int time) {
        this.user = user;
        //Si tiene 3 vidas le doy 25 puntos, si tiene 2 vidas 10 pts y con 1 vida 5 pts.
        if (points == 3) {
            this.points = 25;
        }else if (points == 2) {
            this.points = 10;
        }else if (points == 1){
            this.points = 5;
        } else {
            this.points = 0;
        }    
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    
}
