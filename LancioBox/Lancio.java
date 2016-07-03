/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiegazione;

/**
 *
 * @author BACKSLASHZERO
 */
public class Lancio {

    public static void main(String[] args) {
        int a;
        //Box.y=3; Box è una collezione di attributi e di metodi, ma non è stata istanziata.  Box è un puntatore che non punta a nessuna cella di RAM.   
        Box b;// Viene riservata parte della RAM per creare l'oggetto b della classe box. Box b ritorna come valore un puntatore all'indirizzo della RAM
        //dunque una variabile esadecimale.

        b = new Box(3, 5, 8); //3,5,8 definiscono lo stato iniziale dell'oggetto, e passo questi valori al metodo costruttore della classe Box
        //non è errore scrivere Box b=new Box(3,5,8) anzi risparmi righe di codice
        // Curiosità : posso creare un'infinità di oggetti con un'infinità di stati iniziali, es. Box b2=new Box(3,4,5); Box b3=new Box(5,6,7);  
        //Ci posso lavorare passando l'oggetto ai metodi della classe lancio, ottenendo dunque risultati diversi. Es. b1.meth(); b2.meth(); 

        a = b.meth() * 3; // restituisce un intero. La dichiarazione di questo metodo è nella classe Box. Restituisce ax e lo mette in a
        System.out.println("Valore finale ax*3 = " + a);

    }

}
