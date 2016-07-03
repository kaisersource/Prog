
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BACKSLASHZERO
 */
public class Archivio {

    Libri l[];
    String Author[] = new String[]{"Matteo", "Giovanni", "Marco", "Luca"};
    String title[] = new String[]{"narnia", "anelli", "Battaglia"};
    Random r = new Random();

    public Archivio(int n, int m) {
        l = new Libri[n + m];
        for (int i = 0; i < n; i++) {
            l[i] = new Romanzi(r.nextInt(400), title[r.nextInt(3)], Author[r.nextInt(3)]);
        }
        for (int i = n; i < n + m; i++) {
            l[i] = new Saggi(r.nextBoolean(), title[r.nextInt(3)], Author[r.nextInt(3)]);
        }
    }

    public boolean verifica(String Aut, int x) {
        for (int i = 0; i < l.length; i++) {
            if ((l[i].autore.equals(Aut)) && (l[i].costo() < x)) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Archivio a = new Archivio(1, 2);
        System.out.println(a.verifica("Giovanni", 200));
    }
}
