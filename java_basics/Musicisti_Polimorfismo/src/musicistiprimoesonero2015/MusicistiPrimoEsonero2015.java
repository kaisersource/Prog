/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicistiprimoesonero2015;

/**
 *
 * @author stefano
 */
public class MusicistiPrimoEsonero2015 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Archivio a = new Archivio(20,30);
        System.out.println("Numero musicisti il cui rimborso supera 100 = "+a.numeroMusicisti(100));
    }
}
