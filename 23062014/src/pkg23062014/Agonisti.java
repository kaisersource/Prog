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
public class Agonisti extends Atleti {
    int vittorie;
    
    public Agonisti(String nome,int km,int vittorie){
        super(nome,km);
        this.vittorie=vittorie;
    }
       
    double premio(){
     
     if(vittorie>=5)
        return km*10+100; 
     else return km*10;
    }
    
}
