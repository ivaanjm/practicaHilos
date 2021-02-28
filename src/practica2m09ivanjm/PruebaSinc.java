/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2m09ivanjm;

import java.util.ArrayList;

/**
 *
 * @author IvánJM
 */
public class PruebaSinc {

    private boolean dado = false;
    ArrayList<Integer> arrayList = new ArrayList(20);


    public synchronized void dadoUno(int numeroDado) {
        System.out.println("Numero dado 1: " + numeroDado);
        dado = true;
        notify();

    }

    public synchronized void dadoDos(int numeroDado) {

        while (dado == false) {
            try {

                wait();

            } catch (InterruptedException e) {
                System.out.println("Error " + e.getMessage());
            }

        }
        dado = false;
        System.out.println("Numero dado 2: " + numeroDado);
        System.out.println(arrayList.toString());
        System.out.println("--------------------------------");
    }



}
