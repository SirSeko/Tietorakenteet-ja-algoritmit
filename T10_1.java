// TRAI_20_t10_pohja SJ

import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Random;

/**
 * 10. Kirjoita algoritmi joka saa parametrinaan kaksi järjestämätöntä listaa A ja B (ArrayList)
 * ja joka poistaa listasta A kaikki ne alkiot jotka eivät esiinny listassa B. Älä käytä valmista
 * retainAll() -operaatioita. Aikavaativuus? Miten aikavaativuutta voisi parantaa?
 **/

public class TRAI_20_t10_pohja {


    // Pääohjelman käyttö:
    // java TRAI_20_10 [N] [N2] [S]
    // missä N on alkioiden määrä, N2 on alkoiden määrä toisessa taulukossa
    // ja S on satunnaislukusiemen
    public static void main(String[] args) {

        // taulukoiden koko
        int n1 = 10;
        if (args.length > 0)
            n1 = Integer.parseInt(args[0]);

        int n2 = n1 + 2;
        if (args.length > 1)
            n2 = Integer.parseInt(args[1]);

        int pituus = 1; // merkkijonojen pituus
        if (n1 > 30)
            pituus = 2;

        // satunnaislukusiemen
        int siemen = 42;
        if (args.length > 2)
            siemen = Integer.parseInt(args[2]);


        // testataan vaihteeksi merkkijonoilla

        ArrayList<String> L1 = new ArrayList<>(n1);
        ArrayList<String> L2 = new ArrayList<>(n2);

        // täytetään alkioilla
        Random r = new Random(siemen);
        for (int i = 0; i < n1; i++) {
            L1.add(randomString(r, pituus));
        }

        for (int i = 0; i < n2; i++) {
            L2.add(randomString(r, pituus));
        }

        // tulostetaan taulukot jos alkioita ei ole paljoa
        if (n1 <= 20 && n2 <= 20) {
            System.out.println("L1: " + L1);
            System.out.println("L2: " + L2);
        }


        // testataan tehtävää 10

        sailytaKaikki10(L1, L2);

        System.out.print("Tehtävä 10, L1^L2: ");
        if (n1 <= 20 && n2 <= 20) {
            System.out.println(L1);
        } else {
            System.out.println(L1.size() + " alkiota");
        }

    } // main()


    /**
     * Palauttaa satunnaisen len mittaisen merkkijonon.
     *
     * @param r   satunnaislukugeneraattori
     * @param len merkkijonon pituus
     * @return uusi merkkijono
     */
    public static String randomString(Random r, int len) {
        char[] C = new char[len];
        for (int i = 0; i < len; i++)
            C[i] = (char) (r.nextInt(26) + 'a');
        return new String(C);
    }


    /**
     * Poistaa listasta L1 sellaiset alkiot jotka eivät esiinny listassa L2.
     *
     * @param L1 lista josta poistetaan
     * @param L2 alkiot jotka poistetaan
     */
    public static void sailytaKaikki10(ArrayList L1, ArrayList L2) {

        // TODO

    }


} // class

