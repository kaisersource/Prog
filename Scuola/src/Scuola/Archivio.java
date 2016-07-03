/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scuola;


public class Archivio {
    
    
    Dipendenti []d;
    private String name[]={"Mario","Riccardo","Sebastiano","Giovanni","Paolo"};
    String v;
    double stip;
    
    public Archivio(int n,int m){
        d=new Dipendenti[n+m];
       
    for(int c=0;c<n+m;c++){
        if(c<n)
            d[c] =new Insegnanti(name[(int)(Math.random()*100)%3],(int)(Math.random()*100)%67,(int)(Math.random()*100)%40);
        if(c>=n)
            d[c]=new Amministrativi(name[(int)(Math.random()*100)%5],(int)(Math.random()*100)%67,(int)(Math.random()*100)%10);
    }
            
        
        }
    
    public String quest (int b, int n){ //d è l'eta, n è lo stipendio
        
        
    for(int c=0; c<d.length;c++){
        
        if((b<d[c].eta) &&(n>d[c].stipendio())){ 
            stip=d[c].stipendio();
            v=d[c].nome;
            return v;
        }
        
            } 
    
    return "non trovato";
    
    }
    
    public static void main(String[]args){
    Archivio a=new Archivio(50,60);
        for(int i=0;i<a.d.length;i++)
        System.out.println(a.quest(20, 1000)+"e il suo stipendio è"+a.stip);
    }
}
