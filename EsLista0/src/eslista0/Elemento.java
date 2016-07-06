/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eslista0;

/**
 *
 * @author BACKSLASHZERO
 */
public class Elemento {
    int info; //valore
    Elemento next;//puntatore all'elemento successivo
    public Elemento(int info, Elemento next){//Creazione del costruttore
            this.info=info;
            this.next=next;
    }
    
}
