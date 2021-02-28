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
       
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
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
            } catch (InterruptedException ex) {
                Logger.getLogger(Dado_Dos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
