
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.BreakNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class ThreadMatrix implements Runnable {

    Thread hilo;
    boolean suspender;
    boolean pausar;
    private final pPort port;
    Map map = new Map();

    ThreadMatrix(String nombre) {
        hilo = new Thread(this, nombre);
        suspender = false;
        suspender = false;
        port = new pPort();
        port.setAllDataBits((short) 0);
    }

    public static ThreadMatrix crear(String nombre) {
        ThreadMatrix matriz = new ThreadMatrix(nombre);
        matriz.hilo.start();
        return matriz;
    }

    @Override
    public void run() throws StackOverflowError {
        //System.out.print(hilo.getName() + "Iniciado");
        try {

            map.FrontMap();

            for (int i = 0; i < 12; i++) {
                //System.out.println(i);
                for (int j = 0; j < 12; j++) {
                    if (LoggedUser.FRONT_MAPA[i][j] != null) {
                        if (LoggedUser.FRONT_MAPA[i][j].equals("X")) {
                        port.setPin((short) 2, (short) 1);
                        port.setPin((short) 3, (short) 1);
                        for (int k = 0; k < 1001; k++) {
                            if (k == 1000) {
                                port.setPin((short) 3, (short) 0);
                            }
                        }
                    } else if (LoggedUser.FRONT_MAPA[i][j].equals("J")) {
                        port.setPin((short) 2, (short) 1);
                        port.setPin((short) 3, (short) 1);
                        for (int k = 0; k < 1001; k++) {
                            if (k == 1000) {
                                port.setPin((short) 3, (short) 0);
                            }
                        }
                    } else if (LoggedUser.FRONT_MAPA[i][j].equals("E")) {
                        port.setPin((short) 2, (short) 1);
                        port.setPin((short) 3, (short) 1);
                        for (int k = 0; k < 1001; k++) {
                            if (k == 1000) {
                                port.setPin((short) 3, (short) 0);
                            }
                        }
                    }else if (LoggedUser.FRONT_MAPA[i][j].equals("L")) {
                        port.setPin((short) 2, (short) 1);
                        port.setPin((short) 3, (short) 1);
                        for (int k = 0; k < 1001; k++) {
                            if (k == 1000) {
                                port.setPin((short) 3, (short) 0);
                            }
                        }
                    } else if (LoggedUser.FRONT_MAPA[i][j].equals("B")) {
                        port.setPin((short) 2, (short) 1);
                        port.setPin((short) 3, (short) 1);
                        for (int k = 0; k < 1001; k++) {
                            if (k == 1000) {
                                port.setPin((short) 3, (short) 0);
                            }
                        }
                    }else if (LoggedUser.FRONT_MAPA[i][j].equals("O")) {
                        port.setPin((short) 2, (short) 1);
                        port.setPin((short) 3, (short) 1);
                        for (int k = 0; k < 1001; k++) {
                            if (k == 1000) {
                                port.setPin((short) 3, (short) 0);
                            }
                        }
                    }
                    else if (LoggedUser.FRONT_MAPA[i][j].equals(" ")) {
                        port.setPin((short) 2, (short) 0);
                        port.setPin((short) 3, (short) 1);
                        for (int k = 0; k < 1001; k++) {
                            if (k == 1000) {
                                port.setPin((short) 3, (short) 0);
                            }
                        }
                    }
                    } else {
                         port.setPin((short) 2, (short) 0);
                        port.setPin((short) 3, (short) 1);
                        for (int k = 0; k < 1001; k++) {
                            if (k == 1000) {
                                port.setPin((short) 3, (short) 0);
                            }
                        }
                    }
                    
                }

                Thread.sleep(2);
                synchronized (this) {
                    while (suspender) {
                        wait();
                    }
                    if (pausar) {
                        break;
                    } else {
                        //run();
                    }  
                }
            }
            run();
            
        } catch (InterruptedException e) {
            //System.out.println("Hilo interrumpido");
        }
        //System.out.println("Hilo finalizado");
    }

    synchronized void pausarHilo() {
        pausar = true;
        suspender = false;
        notify();
    }

    synchronized void reanudarHilo() {
        suspender = false;
        notify();
    }

    synchronized void suspenderHilo() {
        suspender = true;
    }

}
