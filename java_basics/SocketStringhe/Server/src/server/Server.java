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
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            int n;
            ServerSocket ss=new ServerSocket(3003); //creazione del socket, il parametro richiesto è la porta
            Socket s; //creazione del socket 
            while(true){
                n=(int)(Math.random()*10); //generazione del numero
                s=ss.accept(); //assegno il parametro restituito dal metodo accept
                Thread t=new ThreadServer(s,n); //threadserver vuore il risultato della accept e il numero n generato casualmente
                t.start(); //fa partire la thread
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex); //se fallisce qualche metodo viene restituito un errore
        }
            
    }
    
}
