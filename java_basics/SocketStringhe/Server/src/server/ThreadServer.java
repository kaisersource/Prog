/*
Si definisca una applicazione client server basata su socket. Il server deve poter rispondere
contemporaneamente a più client.
Il server genera casualmente un intero M.
Il client genera casualmente un intero N. Il client invia poi al server N valori numerici interi positivi
generati casualmente. La fine della sequenza viene segnalata inviando il valore numerico 0.
Ogni volta che riceve un numero uguale ad M, il server scrive a video il numero complessivo di
valori uguali ad M ricevuti finora da tutti i client.
Se necessario, si gestiscano le problematiche di sincronizzazione.
 */
package server;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadServer extends Thread{
    Socket s; 
    int m,n,count=0; //queste sono variabili di classe
    
    public ThreadServer(Socket s,int n){ //parametri del costruttore
    this.s=s; //this riguarda le variabili di classe
    this.n=n; //questa è una variabile locale associata al metodo costruttore, dunque non di classe.
    }
    public void run(){ //ciò che viene eseguito quando eseguo la start
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream())); //classe per leggere ciò che mi viene passato dal socket
            String str;
            while((str=br.readLine())!=null){ //finché c'è qualcosa da leggere
            if(str.equals("0")){ //se legge il valore castato in stringa "0" interrompe la thread
                break;
            }
            else{
                
                m=Integer.parseInt(str); //str viene inserita nella classe wrapper Integer per poter essere castato a intero
                System.out.println("i valori di m sono: "+m);
                    if(m==n) //ogniqualvolta il numero m è uguale ad uno dei numeri passati via socket
                        count++; //incrementa il contatore
                    
                    }
            }
            System.out.println(n);
            System.out.println("il numero di volte che è comparso un numero uguale a M è"+count);
            br.close(); //chiusura del buffer
            s.close(); //chiusura del socket
        } catch (IOException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex); //restituisce 
        }
    }
}
