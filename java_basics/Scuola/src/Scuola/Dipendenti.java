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
public abstract class Dipendenti {
    String nome;
    int eta;
    
    
    public Dipendenti(String nome,int eta){
        this.nome=nome;
        this.eta=eta;
    
    
    }
    

    abstract double stipendio();
    
    
}
