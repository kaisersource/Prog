/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg23062014;


 
public abstract class Atleti {
    String nome;
    int km;
    public Atleti(String nome, int km){
        
    this.nome=nome;
    this.km=km;
    }
    abstract double premio();
   
    
}
