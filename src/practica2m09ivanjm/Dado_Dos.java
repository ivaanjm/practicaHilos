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
public class Dado_Dos implements Runnable {

    PruebaSinc pS;

    public Dado_Dos(PruebaSinc pS) {
        this.pS = pS;
        new Thread(this, "Hilo dado 2").start();

    }

    @Override
    public void run() {

        for (int i = 0; i < 300; i++) {
            try {
                  Thread.sleep(1);
                while (pS.arrayList.size() + 1 < 250) {
                    Thread.sleep(100);
                    int numero = (int) (Math.random() * 6 + 1);
                    if ((numero % 2 != 0) && (pS.arrayList.get(pS.arrayList.size() - 1) % 2 != 0)) {
                        int aux = pS.arrayList.get(pS.arrayList.size() - 1) + numero;
                        pS.arrayList.remove(pS.arrayList.size() - 1);
                        pS.arrayList.add(aux);
                        pS.dadoDos(numero);

                    } else {
                        pS.arrayList.add(numero);
                        pS.dadoDos(numero);
                    }

                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Dado_Dos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            this.finalize();
            System.out.println("Los hilos morira porque está llena la array " + pS.arrayList.size());

        } catch (Throwable ex) {
            Logger.getLogger(Dado_uno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
