/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PiantePolim;

import java.util.logging.Logger;

/**
 *
 * @author BACKSLASHZERO
 */
public class Fiori extends Piante {
    String colore;

    public Fiori(String colore, String nome, int altezza) {
        super(nome, altezza);
        this.colore = colore;
    }

    @Override
    public int costo() {
        if(colore.equals("rosso")) 
            return 5-altezza;
        else 
            return 5-altezza+3;
    }

   
    
}
