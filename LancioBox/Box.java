/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiegazione;

/**
 *
 * @author BACKSLASHZERO
 */
public class Box {

    int vala, b, c; //dichiarazione delle Variabili d'istanza 

    public Box(int vala, int valb, int valc) { //Metodo costruttore, se non ce lo metti lo crea di default il programma, ma senza parametri formali iniziali
        //con l'operatore "new" del main genero lo STATO INIZIALE DELL'OGGETTO,che poi passo al costruttore
        //l'oggetto nel nostro caso essendo unico sarà costituito da soli 3 variabili d'istanza
        //il costruttore fa la seguente operazione implicita: vala=3, valb=5,valc=8;
        //l'operatore "this" risolve problemi di ambiguità. è un operatore che diversifica le variabili d'istanza
        //rispetto ai parametri del costruttore  
        this.vala = vala;//this.vala=variabile d'istanza,  vala=parametro formale locale del metodo costruttore. Lo uso perché c'è ambiguità;
        b = valb; //b=5;
        c = valc; //c=8
    }

    int x = 3;//VARIABILE DI CLASSE poiché predefinita, è visibile a tutti gli oggetti che istanzi usando l'istruzione nel main Box b;
    int y = 4;//Box b1; Box b2; Box b3; sono oggetti che vedranno queste variabili indipendentemente dalle variabili d'istanza che vengono passate col "new"
    int z = 5;//Queste variabili possono essere tranquillamente fuori dal metodo costruttore, ma per questione di stile le dichiarazioni si mettono fuori 
    //dal costruttore, mentre le definizioni all'interno 

    public int meth() { //dichiarazione del metodo meth specificando come tipo di valore di ritorno "int"
        int ax, by, cz;
        ax = vala * x;
        by = b * y;
        cz = c * z;
        System.out.println("ax = " + ax);
        System.out.println("by = " + by);
        System.out.println("cz = " + cz);
        return ax;
    }
}
