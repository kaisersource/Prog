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
public class Elemento {
    String parola;
    Elemento next;

    public Elemento(String parola, Elemento next) {
        this.parola = parola;
        this.next = next;
    }
}
