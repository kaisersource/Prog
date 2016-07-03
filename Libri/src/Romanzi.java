/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BACKSLASHZERO
 */
public class Romanzi extends Libri {

    int npagine;

    public Romanzi(int npagine, String titolo, String autore) {
        super(titolo, autore);
        this.npagine = npagine;
    }

    public double costo() {
        return 10 + 1.5 * npagine;
    }

}
