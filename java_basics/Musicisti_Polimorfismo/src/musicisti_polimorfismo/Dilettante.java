/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicisti_polimorfismo;

/**
 *
 * @author kaisersource
 */
public class Dilettante extends Musicista{
    boolean legge;
    
    public Dilettante(boolean legge, String nome, int eta) {
        super(nome, eta);
        this.legge = legge;
    }

    
        public double rimborsoSpese(){
        if (legge)
        {
                return 10 + getEta()*2;
        }
        else
        {
            return getEta()*2;
        }
    }
    
}
