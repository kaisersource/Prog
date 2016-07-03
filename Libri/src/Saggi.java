/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BACKSLASHZERO
 */
public class Saggi extends Libri {

    boolean scientifico;

    public Saggi(boolean scientifico, String titolo, String autore) {
        super(titolo, autore);
        this.scientifico = scientifico;
    }

    public double costo() {
        if (scientifico == true) {
            return 20 + 5;
        } else {
            return 20;
        }
    }

}
