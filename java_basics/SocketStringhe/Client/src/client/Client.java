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
package client;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int port = 3003; //porta
            String ip = "localhost"; //ip di autoriferimento
            Socket s = new Socket(ip, port); //creo un oggetto socket con i relativi parametri
            int a;//elemento casuale
            PrintWriter out = new PrintWriter(s.getOutputStream(), true); //la printwriter consente stampa degli oggetti in stringhe
            int n = (int) (Math.random() * 30); //numero degli elementi casuali
            int k;
            for (int i = 0; i < n; i++) {
                k=(int)(Math.random()*10);
                out.println(k); 
            }
            out.println(0); 
            out.close();//chiusura dello stream
            s.close();//chiusura del socket

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex); //rilevamento e stampa degli errori
        }
    }

}
