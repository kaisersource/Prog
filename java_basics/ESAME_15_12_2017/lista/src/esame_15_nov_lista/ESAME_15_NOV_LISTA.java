/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame_15_nov_lista;

/**
 *
 * @author kaisersource
 */
public class ESAME_15_NOV_LISTA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista l=new Lista(10);
        System.out.println(l.ennesimo(5));
        System.out.println(l.ennesimoR(15));
        l.stampa();
    }
    
}
