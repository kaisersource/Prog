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
public class Digitali extends Orologi{
    double volt;

    public Digitali(String marca, boolean sub, double volt) {
        super(marca, sub);
        this.volt = volt;
    }
    
    double costo(){
    double costo=0;
        if(sub==true){
            costo=5*volt+10;
        }else{
            costo=5*volt;
        }
    return costo;
    }
}
