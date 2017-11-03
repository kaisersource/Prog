/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicistiprimoesonero2015;

/**
 *
 * @author kaisersource
 */
public abstract class Musicista {
    String nome;
    private int eta;
    
    public Musicista(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    
    public void compleanno() {
        eta++;
    }
    
    public int getEta(){
        return eta;
    }
    
    public abstract double rimborsoSpese();
}
