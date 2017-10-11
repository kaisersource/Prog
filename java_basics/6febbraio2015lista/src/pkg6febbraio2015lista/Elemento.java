/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6febbraio2015lista;

/**
Si definisca la classe Lista che rappresenta una lista di interi concatenata tramite riferimenti.
Nella classe Lista si definisca:
• un metodo costruttore che, dato un parametro n costruisce una lista di n valori casuali
• un metodo che, dato un parametro n, verifica se nella lista è presente un elemento che divide n.
Si realizzi infine una applicazione che:
• crea una lista di 10 elementi
• stampa a video il risultato della ricerca nella lista di un elemento che divide 36.
 */
public class Elemento {
    int info;
    Elemento next;

    public Elemento(int info, Elemento next) {
        this.info = info;
        this.next = next;
    }
    
}
