/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame_15_nov_poli;

import java.util.Random;

/**
 *
 * @author kaisersource
 */
public class Negozio {
    Orologi V[];
    public Negozio(int n, int m){
        Random r= new Random();
        V=new Orologi[n+m];
        
        //n analogici
        for(int i=0; i<n; i++){
            V[i]=new Analogici("Marca "+i, r.nextBoolean(), r.nextInt(10));
        }
        //m digitali
        for(int i=n; i<n+m;i++){
            V[i]=new Digitali("Marca "+i, r.nextBoolean(), r.nextDouble());
        }
    }
    
    double media(String marca){
    String a=marca;
    double media=0;
    double somma=0;
    int c=0;
    
        for(int i=0; i<V.length;i++){
            if(V[i].nome.equals(a)){
                c++;
                somma= somma+V[i].costo();
            }
        }
    media=somma/c;
    return media;
    }
}
