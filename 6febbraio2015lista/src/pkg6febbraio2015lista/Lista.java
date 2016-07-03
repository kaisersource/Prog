/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6febbraio2015lista;

/**
 *
 un metodo che, dato un parametro n, verifica se nella lista è presente un elemento che divide n.
 */
public class Lista {

    Elemento testa = null;

    public void inserisci(int n) {
        for (int i = 0; i < n; i++) {
            testa = new Elemento(1+(int) (Math.random() * 50), testa);
        }
    }
    
    public boolean divis(int n){
        Elemento e=testa;
        while(e!=null){
            if((n%e.info)==0)
                return true;
            e=e.next;
        }
        
    return false;
    }

    public static void main(String[] args) {
        Lista l=new Lista();
        l.inserisci(10);
        System.out.println(l.divis(36));
    }
    
}
