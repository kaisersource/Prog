/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BACKSLASHZERO
 */
public class ThreadT extends Thread{

    Socket s;
    
    int n, k;

    ThreadT( Socket s, int n) {
        this.s = s;
        this.n = n;
        
    }

    
    @Override
    public void start() {
        try {
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            for (int i = 0; i < n; i++) {
                k = (int) (Math.random() * 11);
                out.println(k);
            }
            
            out.println("-1");
            out.close();
            s.close();
            
            
            

        } catch (IOException ex) {
        Logger.getLogger(ThreadT.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    }
    
        
        
    }
    

