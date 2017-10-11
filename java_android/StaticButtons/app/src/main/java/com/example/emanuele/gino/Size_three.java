package com.example.emanuele.gino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.emanuele.gino.R.id.prosegui;

public class Size_three extends AppCompatActivity {

    public EditText e00, e01, e10, e11, e02, e20, e12, e21, e22;
    private TextView r_zero, r_one, r_two, c_zero, c_one, c_two, edges, mostedgedval, graphconn, graphreg;
    private int dim, A[][];
    private Button verifica;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.size3);

        e00 = (EditText) findViewById(R.id.e00);
        e01 = (EditText) findViewById(R.id.e01);
        e02 = (EditText) findViewById(R.id.e02);
        e10 = (EditText) findViewById(R.id.e10);
        e11 = (EditText) findViewById(R.id.e11);
        e12 = (EditText) findViewById(R.id.e12);
        e20 = (EditText) findViewById(R.id.e20);
        e21 = (EditText) findViewById(R.id.e21);
        e22 = (EditText) findViewById(R.id.e22);

        r_zero = (TextView) findViewById(R.id.r_zero);
        r_one = (TextView) findViewById(R.id.r_one);
        r_two = (TextView) findViewById(R.id.r_two);
        c_zero = (TextView) findViewById(R.id.c_zero);
        c_one = (TextView) findViewById(R.id.c_one);
        c_two = (TextView) findViewById(R.id.c_two);
        edges = (TextView) findViewById(R.id.edges);
        mostedgedval = (TextView) findViewById(R.id.mostedgedval);
        graphconn = (TextView) findViewById(R.id.graphconn);
        graphreg = (TextView) findViewById(R.id.graphreg);
        verifica = (Button) findViewById(R.id.verifica);
        A = new int[3][3];




//memorizzazione degli elementi all'interno di un arraylist
        verifica.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
            try {
                A[0][0] = Integer.parseInt(e00.getText().toString());
                A[0][1] = Integer.parseInt(e01.getText().toString());
                A[0][2] = Integer.parseInt(e02.getText().toString());
                A[1][0] = Integer.parseInt(e10.getText().toString());
                A[1][1] = Integer.parseInt(e11.getText().toString());
                A[1][2] = Integer.parseInt(e12.getText().toString());
                A[2][0] = Integer.parseInt(e20.getText().toString());
                A[2][1] = Integer.parseInt(e21.getText().toString());
                A[2][2] = Integer.parseInt(e22.getText().toString());

            } catch (Exception e) {
                Message.alert_msg(Size_three.this, "Attenzione", "Numero non consentito");
            }
            //Verifica se gli archi sono ammissibili

            //Stampa gli archi associati alla matrice di adiacenza
            edges.setText("Archi: ");
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if (A[i][j] == 1)
                        edges.append("(" + i + "," + j + ")");
                }
            }

            //stampa il vertice con più archi
            //elemento con piu archi.
            int[] Carry = new int[3];//vettore d'appoggio per contare le ocorrenze
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if (A[i][j] == 1)//se l'arco esiste
                        Carry[i]++;//incremento.
                }
            }
            int max = Carry[0];//salvo l'elemento di partenza da confrontare
            int maxIndex = 0;//indice dell'elemento con piu archi
            for (int i = 1; i < A.length; i++) {
                if (max < Carry[i]) {//verifico l'elemento che ha avuto il maggior numero di archi(lo scopro in base all'indice i)
                    max = Carry[i];//nuovo massimo
                    maxIndex = i;//nuovo indice del massimo
                }
            }

            mostedgedval.setText("Vertice col grado massimo:" + maxIndex);
            //indice massimo di carry nonche' punto fisso per l'indice i-esimo o j-esimo della matrice A


            //conto gli zero per ogni riga. Se una riga ha tutti elementi nulli, significa che il grafo non è connesso.
            int c_notzero = 0, contatore_righe_nulle = 0, numcomp = 0, maxonesperrow = 0;
            //matrice che memorizza le componenti connesse
            for (int i = 0; i < A.length - 1; i++) { //poiché se sego l'obliqua e tengo conto della triangolare superiore
                //le righe sono n-1
                c_notzero = 0;
                for (int j = i + 1; j < A.length; j++) { //trick, guardando solo la triangolare superiore
                    if (A[i][j] == 1) {
                        c_notzero++;
                        //se una riga di dimensione n-1 ha tutte le colonne fatte 1
                    }
                    if (c_notzero == A.length - 1)
                        maxonesperrow = c_notzero; //se tutte le colonne di una riga hanno tutti uno
                    //e solo la prima riga può averli, allora il grafo è connesso
                }
                if (c_notzero == 0)
                    contatore_righe_nulle++; //significa che ci sono almeno due componenti connesse
            }
            numcomp = A.length - contatore_righe_nulle;
            //se il numero di righe nulle o righe piene coincidono con la dimensione, oppure se il numero delle componenti
            //connesse è una, allora il grafo è connesso. Altrimenti valuta le componenti connesse
            if (numcomp == 0 || numcomp == 1 || maxonesperrow == A.length - 1)
                graphconn.setText("il grafo è connesso");
            else
                graphconn.setText("Componenti connesse è " + numcomp);



                //funzione per verificare la regolarità del grafo
                    int C[] = new int[A.length];
                    for (int i = 0; i < A.length; i++) {
                        for (int j =0; j < A.length; j++) {
                            if (A[i][j] == 1)//se esiste l'arco
                                C[i]++;//incremento il grado
                        }
                    }
                    boolean a=true; //flag per indicare se il grafo è o meno regolare
                    for (int i = 0; i < A.length - 1; i++) {
                        if (C[i] != C[i + 1]) {
                            //Se sono uguali non entra nella condizione e ritorna true (regolare). Altrimenti false (non regolare).
                            a=false;

                        }
                        break;
                    }
                        if(a==true)
                            graphreg.setText("il grafo è regolare");
                        else graphreg.setText("il non è regolare");

                    }


        });

    }


}



