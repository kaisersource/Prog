/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg23062014;

/**
 *
 * @author BACKSLASHZERO
 */
public class Amatoriali extends Atleti{
    int gare;
    public Amatoriali(String nome, int km, int gare){
        super(nome,km);
        this.gare=gare;
    
    }
    
    
        double premio(){
            return km*5+10*gare;
    
    
    }
    
}
