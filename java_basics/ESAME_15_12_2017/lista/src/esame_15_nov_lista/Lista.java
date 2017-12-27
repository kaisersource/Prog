/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame_15_nov_lista;

/**
 *
 * @author kaisersource
 */
public class Lista {
    Elemento testa=null;
    Elemento coda=null;
    /*
    public Lista(int n){
        for(int i=0; i<n;i++){
            testa=new Elemento("Elemento"+i, testa);
        }
    }*/
    
    public Lista(int n){
   for(int i=1; i<n+1; i++){
        if (testa ==null){
         testa=new Elemento("Elemento"+i,null);
         coda = testa;
        }
        else{
            coda.next=new Elemento("Elemento"+i,null);
            coda = coda.next;
        }      
    }
    }

    
    String ennesimo(int n){
        String parola=null;
        int pos=0;
        
       if(n <=0){
        return null;
       }
       else{
           for(Elemento e=testa; e!=null; e=e.next){
               ++pos;
               if(pos==n){
                   return parola=e.parola;
               }
           }return null;
       
       }
    }
    
    private String ennesimoR(Elemento testa, int n, int pos){
        String parola=null;
        if(testa==null || n<=0){
            return parola;
        } else {
            ++pos;
            if(pos==n){
                return testa.parola;
            }
            else{
                return ennesimoR(testa.next, n, pos);
            }
        }
    }
    String ennesimoR(int n){
        return ennesimoR(testa,n,0);
    }
    
    public void stampa(){
        for(Elemento e=testa; e!=null; e=e.next){
            System.out.println(e.parola);
        }
    }

}
