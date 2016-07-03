/*
Si definisca una gerarchia di classi per rappresentare le piante di un negozio di
giardinaggio.
Le piante sono due tipi: ortaggi e fiori.






 */
package PiantePolim;

import java.util.Random;

/**
 *
 * @author BACKSLASHZERO
 */
public abstract  class Piante{
    String nome;
    int altezza;

    public Piante(String nome, int altezza) {
        this.nome = nome;
        this.altezza = altezza;
    }
    
    

  
    
    public abstract int costo();
}
