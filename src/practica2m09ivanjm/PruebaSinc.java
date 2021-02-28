/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2m09ivanjm;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IvánJM
 */
public class PruebaSinc {

    private boolean dadounoencendido = true;

    ArrayList<Integer> arrayList = new ArrayList(250);
    public synchronized void dadoUno(int numeroDado) {
       
        while (!dadounoencendido) {
            try {
               wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(PruebaSinc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
        System.out.println("Numero dado 1: " + numeroDado);
        dadounoencendido = false;
        notifyAll();
    }

    public synchronized void dadoDos(int numeroDado) {

        while (dadounoencendido) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error " + e.getMessage());
            }
        }
        System.out.println("Numero dado 2: " + numeroDado);
        System.out.println(arrayList.toString());
        System.out.println("--------------------------------");
        dadounoencendido = true;
        notifyAll();

    }

}
