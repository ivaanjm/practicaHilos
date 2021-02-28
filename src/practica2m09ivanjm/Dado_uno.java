/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2m09ivanjm;

import java.util.logging.Level;
import java.util.logging.Logger;

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
        for (int i = 0; i < 300; i++) {     
                while (pS.arrayList.size() + 1 < 250) {
                    try {
                        Thread.sleep(100);
                        int numero = (int) (Math.random() * 6 + 1);
                        pS.arrayList.add(numero);
                        pS.dadoUno(numero);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Dado_uno.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Dado_uno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
