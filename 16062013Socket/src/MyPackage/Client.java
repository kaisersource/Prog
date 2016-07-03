/*
 Si definisca una applicazione client server basata su socket. Il server deve poter rispondere
 contemporaneamente a più client.
 Il server genera casualmente un intero N. Il server invia poi al client N valori numerici
 interi compresi fra 0 e 10 generati casualmente. La fine della sequenza viene segnalata
 inviando il valore numerico -1.
 Il client scrive a video il valore più .grande ricevuto ed il numero di volte che tale valore
 massimo è stato ricevuto.
 Se necessario, si gestiscano le problematiche di sincronizzazione.
 */
package MyPackage;

import java.net.*;
import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BACKSLASHZERO
 */
public class Client {

    public static void main(String[] args) {
        String str;
        int a, max, c = 0;
        try {
            Socket s = new Socket("localhost", 3003);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            str = br.readLine();
            max = Integer.parseInt(str);

            while ((str = br.readLine()) != null) {
                System.out.println(str);
                if (str.equals("-1")) {
                    break;
                } else {
                    a = Integer.parseInt(str);
                    if (a >= max) {
                        max = a;
                        c++;
                    }
                    

                }
            }
            System.out.println("Il massimo valore è " + max + " ed è stato ripetuto per " + c + " volte");
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
        
    

