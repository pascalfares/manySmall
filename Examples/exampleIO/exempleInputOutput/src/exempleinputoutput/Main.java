/*
 * Ecrire un programme qui lit des caractères au clavier et les
 * insère dans une chaîne passée en paramètres avant que
 * d’afficher à nouveau l’ensemble
 */
package exempleinputoutput;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author pfares
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    byte c;
    ByteArrayOutputStream intermediaire = new ByteArrayOutputStream();
    String chaine;

    public static void main(String args[]) throws IOException {
        new Main().run(args);
    }

    void run(String args[]) throws IOException {
        int i = 0;
        chaine = args[0];
        while ((c = (byte) System.in.read()) >= 0) {
            intermediaire.write(c);
            if (i < chaine.length()) {
                intermediaire.write(chaine.charAt(i++));
            }
        }
        intermediaire.writeTo(System.out);
    }
}
