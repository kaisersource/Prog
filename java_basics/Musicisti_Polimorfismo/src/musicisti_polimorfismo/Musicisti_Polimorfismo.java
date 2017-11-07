/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicisti_polimorfismo;

/**
 *
 * @author kaisersource
 */
public class Musicisti_Polimorfismo{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Archivio a = new Archivio(20,30);
        System.out.println("Numero musicisti il cui rimborso supera 100 = "+a.numeroMusicisti(100));
    }
}
