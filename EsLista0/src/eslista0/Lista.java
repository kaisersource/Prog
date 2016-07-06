

package eslista0;

import java.util.Random;

/**
 *
 * @author user
 */
public class Lista {

    Elemento testa=null;
    public Lista(int n){
        for(int c=0;c<n;c++)
            testa=new Elemento((int)(Math.random()*30),testa);
    }
    
    public void visualizza(){
        Elemento e=testa;//creo una copia di testa cosi' lavoro su 'e', quando  scorro la lista  non distruggo 'testa', ma 'e'
    
        while(e!=null){
            System.out.print(e.info+" ");
            e=e.next;
        }
        System.out.println("");
    
    }
    
     public void visualizzan(int n){
    Elemento e=testa;
    
    while(e!=null){
        if(n<e.info){
            System.out.print(e.info+" ");
        }
            e=e.next;
    }
    System.out.println("");
    }
}
