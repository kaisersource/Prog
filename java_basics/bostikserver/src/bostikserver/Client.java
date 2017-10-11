/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bostikserver;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    Socket miosocket = null;

    int porta = 3030;
    DataOutputStream out;
    DataInputStream in;
    BufferedReader tastiera;
    String messaggio;

    public void comunica() {
        try {
            do {
                tastiera = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("[2] - Messaggio da inviare al server");
                messaggio = tastiera.readLine();
                System.out.print("[3] - Invio : " + messaggio);
                out.writeBytes(messaggio + "\n");
                System.out.print("[4] - In attesa della ricevuta... : ");
                String ricevuta = in.readLine();

                System.out.print("[5] - ...Messaggio ricevuto : " + ricevuta);
            } while (!messaggio.toLowerCase().equals("esci"));
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Socket connetti() {
        try {
            System.out.println("[0] - Provo a connettermi al server...");
            miosocket = new Socket(InetAddress.getLocalHost(), porta);
            System.out.println("[1] - ...Connesso");
            in = new DataInputStream(miosocket.getInputStream());
            out = new DataOutputStream(miosocket.getOutputStream());

        } catch (IOException ex) {
            System.err.println("Host sconosciuto");
        }

        return miosocket;

    }

    public static void main(String[] args) {
        Client c = new Client();
        c.connetti();
        c.comunica();
    }
}
