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
public class Amministrativi extends Dipendenti {

    int level;

    public Amministrativi(String nome, int eta, int level) {
        super(nome, eta);
        this.level = level;

    }

    double stipendio() {

        return 800 + 50.50 * level;
    }
}
