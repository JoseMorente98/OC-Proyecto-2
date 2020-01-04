/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan José Ramos
 */
public class ioPort {
    // declare native methods of 'jnpout32.dll'

    // output a value to a specified port address
    public native void Out32(short PortAddress, short data);

    // input a value from a specified port address
    public native short Inp32(short PortAddress);

    // load 'jnpout32.dll'
    static {

        System.loadLibrary("jnpout32");

    }
}
