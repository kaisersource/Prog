package bostikserver;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BACKSLASHZERO
 */
public class Server {

    ServerSocket server = null;
    Socket socketclient = null;

    int porta = 3030;
    DataOutputStream out;
    DataInputStream in;
    String risposta;

    public void comunica() {
        try {
            do {
                System.out.println("[3] - Aspetto un messaggio dal client...");
                String letto = in.readLine();
                System.out.println("[4] - ...messaggio ricevuto...; " + letto);
                risposta = letto.toUpperCase();
                System.out.println("[5] - Rispondo con; " + risposta);
                out.writeBytes(risposta + "\n");
            } while (!risposta.toLowerCase().equals("esci"));
            System.out.println("[6] - Chiudo la connessione");
            socketclient.close();

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Socket start() {
        try {
            System.out.println("[0] - Inizializzo il server...");
            //inizializzo il servizio
            server = new ServerSocket(porta);
            //mi metto in ascolto sulla porta
            System.out.println("[1] - In attesa di connessioni...");
            socketclient = server.accept();

            System.out.println("[2] - ...Connessione stabilita");
            //evito connessioni multiple
            server.close();

            in = new DataInputStream(socketclient.getInputStream());
            out = new DataOutputStream(socketclient.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return socketclient;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server s = new Server();
        s.start();
        s.comunica();
    }

}
