/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2m09ivanjm;

/**
 *
 * @author IvánJM
 */
public class Dado_uno implements Runnable {

    PruebaSinc pS;

    public Dado_uno(PruebaSinc pS) {
        this.pS = pS;
        new Thread(this, "Hilo dado 1").start();

    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int numero = (int) (Math.random() * 6 + 1);
                
                Thread.sleep(100);
                pS.arrayList.add(numero);
                pS.dadoUno(numero);
                
            }
        } catch (InterruptedException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

}
