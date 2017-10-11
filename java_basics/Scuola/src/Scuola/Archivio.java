/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scuola;


public class Archivio {
    
    
    Dipendenti []d; //array Di oggetti d della classe Dipendenti
    private String name[]={"Mario","Riccardo","Sebastiano","Giovanni","Paolo"};
    String v;
    double stip;
    
    public Archivio(int n,int m){ //metodo dove gli devi passsare il numero "n" degli insegnanti e "m" amministrativi
        d=new Dipendenti[n+m];//chiamo il costruttore di Dipendenti e gli assegno la dimensione n+m
       
    for(int c=0;c<n+m;c++){ //da 0 a n-1, ossia fino agli insegnanti, li creo a random con le variabili necessarie
        if(c<n)
           d[c] =new Insegnanti(name[(int)(Math.random()*100)%3],(int)(Math.random()*100)%67,(int)(Math.random()*100)%40);
        if(c>=n) //da n a n-1, ossia fino agli amministrativi, li creo a random
            d[c]=new Amministrativi(name[(int)(Math.random()*100)%5],(int)(Math.random()*100)%67,(int)(Math.random()*100)%10);
    }
            
        
        }
    
    public String quest (int b, int n){ //d è l'eta, n è lo stipendio
        
        
    for(int c=0; c<d.length;c++){
        
        if((b<d[c].eta) &&(n>d[c].stipendio())){ //sse l'età è maggiore a un intero "b" e lo stipendio minore di "n)
            stip=d[c].stipendio(); //allora richiamo la funzione che da in output lo stipendio
            v=d[c].nome; //e il suo nome
            return v;
        }
        
            } 
    
    return "non trovato"; 
    
    }
    
    public static void main(String[]args){
    Archivio a=new Archivio(50,60); //creo un archivio di 50 insegnanti e 60 amministrativi
        for(int i=0;i<a.d.length;i++)// ciclo da 0 fino alla dimensione di d, ossia 110-1
        System.out.println(a.quest(20, 1000)+"e il suo stipendio è"+a.stip); //restituisco lo stipendio dei tizi che hanno più di 20 anni ma con uno stipendio minore di 1000
    }
}
