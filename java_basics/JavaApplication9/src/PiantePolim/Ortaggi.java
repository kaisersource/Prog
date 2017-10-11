/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PiantePolim;

/**
 *
 * @author BACKSLASHZERO
 */
public class Ortaggi extends Piante {
    boolean annuale;

    public Ortaggi(boolean annuale, String nome, int altezza) {
        super(nome, altezza);
        this.annuale = annuale;
    }
    
    
    
    @Override
    public int costo() {
        if(annuale==true)
            return 3-altezza+5;
        else
            return 3-altezza;
        
    }
    
    
}
