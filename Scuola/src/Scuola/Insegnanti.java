/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scuola;

/**
 *
 * @author BACKSLASHZERO
 */
public class Insegnanti extends Dipendenti {

    int timeteaching;

    public Insegnanti(String nome, int eta, int timeteaching) {
        super(nome, eta);
        this.timeteaching = timeteaching;
    }

    double stipendio() {

        return 500 + 100 * timeteaching;
    }
}
