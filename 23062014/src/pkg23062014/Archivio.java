/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg23062014;

/**
 *
 * @author BACKSLASHZERO
 */
public class Archivio {

    Atleti a[];
    String nome;
    String name[] = new String[]{"Pippo", "Mario", "Pluto", "Paolo", "Giovanni"};
    int k;

    public Archivio(int n, int m) {
        a = new Atleti[n + m];
        for (int i = 0; i < n; i++) {
            k = (int) (Math.random() * 100) % 5;

            a[k] = new Agonisti(name[k], (int) (Math.random() * 100) % 5, (int) (Math.random() * 100) % 5);
        }
        for (int i = n; i < n + m; i++) {
            k = (int) (Math.random() * 100) % 5;

            a[k] = new Amatoriali(name[k], (int) (Math.random() * 100) % 5, (int) (Math.random() * 100) % 5);
        }
         
       
    }
    public String premionome(int n){
        
        for(int i=0;i<a.length;i++){
            if(a[i].premio()>n)
                return a[i].nome;
        }
        return "assente";
            
          
        
        }
    
    //Si definisca infine un metodo della classe Archivio che, dato un parametro n, restituisce il nome di
    //un atleta il cui premio è maggiore di n o la stinga “assente” se tale atleta non esiste.
    

    public static void main(String[] args) {
        Archivio a=new Archivio(20,30);
        System.out.println(a.premionome(30));
    }

}
