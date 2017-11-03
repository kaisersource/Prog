/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicistiprimoesonero2015;

/**
 *
 * @author stefano
 */
public class Professionista extends Musicista {
    int anni;
    
    public Professionista(int anni, String nome, int eta) {
        super(nome, eta);
        this.anni = anni;
    }

    
    public double rimborsoSpese(){
        if (getEta()> 35)
        {
                return 10 + anni*10;
        }
        else
        {
            return anni*10;
        }
    }
    
}
