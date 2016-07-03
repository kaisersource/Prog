/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;

import java.net.*;
import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/*Si definisca una applicazione client server basata su socket. Il server deve poter rispondere
contemporaneamente a più client.
Il server genera casualmente un intero N. Il server invia poi al client N valori numerici
interi compresi fra 0 e 10 generati casualmente. La fine della sequenza viene segnalata
inviando il valore numerico -1.
Il client scrive a video il valore più .grande ricevuto ed il numero di volte che tale valore
massimo è stato ricevuto.
Se necessario, si gestiscano le problematiche di sincronizzazione.


    /**
 * @param args the command line arguments
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(3003);
            int n = (int) (Math.random() * 10);
            while (true) {
                Socket s = server.accept();
                ThreadT t = new ThreadT(s, n);
                t.start();
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
