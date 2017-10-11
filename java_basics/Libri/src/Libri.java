/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BACKSLASHZERO
 */
public abstract class Libri {

    String titolo;
    String autore;

    public Libri(String titolo, String autore) {
        this.titolo = titolo;
        this.autore = autore;
    }

    public abstract double costo();
}
