/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame_15_nov_poli;

/**
 *
 * @author kaisersource
 */
    abstract public class Orologi {
    String nome;
    boolean sub;

    public Orologi(String nome, boolean sub) {
        this.nome = nome;
        this.sub = sub;
    }
    abstract double costo();
}

