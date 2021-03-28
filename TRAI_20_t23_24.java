// TRAI_20_t23_24.java SJ
package viikko6;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class TRAI_20_t23_24_pohja {

    public static void main(String[] args) {

        int N = 7;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        Set<Set<Integer>> SS = new HashSet<>();

        Random r = new Random(N + 1);
        System.out.println("Syötejoukot:");
        for (int i = 0; i < N; i++) {
            Set<Integer> S = new HashSet<>();
            for (int j = 0; j < N; j++) {
                S.add(r.nextInt(N * 2));
            }
            SS.add(S);
            System.out.println("S" + i + ": " + S);
        }

        Set<Integer> tulos = yhdiste(SS);
        System.out.println("\nKaikkien yhdiste: " + tulos);
        System.out.println();

        tulos = vainYhdessa(SS);
        System.out.println("Vain yhdessä: " + tulos);
        System.out.println();

    } // main()


    /**
     * 23. Kirjoita algoritmi joka saa parametrinaan joukkojen joukon (Set<Set<E>>) ja joka pa-
     * lauttaa joukkona (Set<E>) kaikki ne alkiot jossakin (tai joissakin) syötejoukoissa. Siis
     * yhdisteen. Vihje: iteraattori ja joukko-operaatiot. Mikä on algoritmisi aikavaativuus?
     *
     * @param SS  joukkojen joukko
     * @param <E> joukkojen alkioiden tyyppi
     * @return kaikki jossain joukossa esiintyneet alkiot
     */
    public static <E> Set<E> yhdiste(Set<Set<E>> SS) {
        Set<E> tulos = new HashSet<>();

        Iterator<Set<E>> itr = SS.iterator();

        while(itr.hasNext()){
           tulos.addAll(itr.next()); //Aikavaativuus O(n)

        }
        return tulos;
    }

    /**
     * 24. Kirjoita algoritmi joka saa parametrinaan joukkojen joukon (Set<Set<E>>) ja joka pa-
     * lauttaa joukkona (Set<E>) kaikki ne alkiot jotka ovat tasan yhdessä syötejoukoista. Ne
     * alkiot jotka ovat useammassa kuin yhdessä syötejoukoista eivät tule tulokseen. Älä muuta
     * syötejoukkoja. Vihje: iteraattori ja joukko-operaatiot. Mikä on algoritmisi aikavaativuus?
     *
     * @param SS  joukkojen joukko
     * @param <E> joukkojen alkioiden tyyppi
     * @return kaikki ne alkiot jotka esiintyvät vain yhdessä joukossa
     */
    public static <E> Set<E> vainYhdessa(Set<Set<E>> SS) {
        Set<E> tulos = new HashSet<>();
        Set<E> vertailu = new HashSet<>();
        Iterator<Set<E>> itr = SS.iterator();

        while(itr.hasNext()){
            vertailu = itr.next();
            if(itr.hasNext()){
                itr.next();
                tulos.addAll(itr.next()); //Aikavaativuus O(n)

            }
            tulos.removeAll(vertailu);

        }



        return tulos;
    } // vainYhdessa()


} // class
