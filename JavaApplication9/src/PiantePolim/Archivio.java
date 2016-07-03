/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PiantePolim;

import java.util.Random;

/**
 *
 * Si definisca infine un metodo della classe Archivio che, dato un parametro x,
 * restituisce il minimo dei costi delle piante più alte di x .
 */
public class Archivio {

    String nome[] = new String[]{"Margherita", "Ciclamino", "Papaveri"};
    String colore[] = new String[]{"Rosso", "Verde", "Giallo"};
    Random r=new Random();
    Piante p[];
    int k;

    public Archivio(int n, int m) { //n ortaggi m fiori
       
        p = new Piante[n + m];
        for (int i = 0; i < n; i++) {
            k = (int) (Math.random() * 100) % 3;

            p[i] = new Ortaggi(r.nextBoolean(), nome[k] , (int) (Math.random() * 100) % 3);
        }
        for (int i = n; i < n + m; i++) {
            k = (int) (Math.random() * 100) % 3;

            p[i] = new Fiori(colore[k], nome[k], (int) (Math.random() * 100) % 3);
        }
         
       
    }

    public int min(int x) {
        int minimo;
        minimo=p[0].costo();
        for(int i=1;i<p.length;i++){
            if((p[i].altezza)>x && (minimo>p[i].costo())){
                
                    minimo=p[i].costo();   
        }
    }
        return minimo;
    }
    public static void main(String[] args) {

       Archivio a=new Archivio(5,7);
       System.out.println(a.min(2));
    }

}
