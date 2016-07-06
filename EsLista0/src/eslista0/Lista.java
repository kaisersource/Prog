

package eslista0;

import java.util.Random;

/**
 *
 * @author user
 */
public class Lista {

    Elemento testa=null; //creo un oggetto di tipo Elemento
    public Lista(int n){ //gli passo la dimensione della lista
        for(int c=0;c<n;c++)
            testa=new Elemento((int)(Math.random()*30),testa);//inserimento in testa di elementi con campo valore casuale
    }
    
    public void visualizza(){
        Elemento e=testa;//creo una copia di testa cosi' lavoro su 'e', quando  scorro la lista  non distruggo 'testa', ma 'e'
    
        while(e!=null){//finche' la lista non e' vuota
            System.out.print(e.info+" ");//printa
            e=e.next;//scorri
        }
        System.out.println("");
    
    }
    
     public void visualizzan(int n){//passatogli n
    Elemento e=testa;
    
    while(e!=null){
        if(n<e.info){//se l'elemento e' maggiore di n
            System.out.print(e.info+" ");//printa
        }
            e=e.next;
    }
    System.out.println("");
    }
}
