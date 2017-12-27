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
public class Analogici extends Orologi {
    int rubini;

    public Analogici( String nome, boolean sub,int rubini) {
        super(nome, sub);
        this.rubini = rubini;
    }
    
    double costo(){
    double costo=0;
        if(sub==true){
            costo=10*rubini+20;
        }else{
            costo=10*rubini;
        }
    return costo;
    } 
}
