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
    int m,n,count=0;
    
    public ThreadServer(Socket s,int n){
    this.s=s;
    this.n=n;
    }
    public void run(){
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str;
            while((str=br.readLine())!=null){
            if(str.equals("0")){
                break;
            }
            else{
                
                m=Integer.parseInt(str);
                System.out.println("i valori di m sono: "+m);
                    if(m==n)
                        count++;
                    
                    }
            }
            System.out.println(n);
            System.out.println("il numero di volte che è comparso un numero uguale a M è"+count);
            br.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
