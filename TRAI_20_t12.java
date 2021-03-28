// TRAI_20_t12.java SJ
// Pääohjelma viikon 3 tehtävään 12

/**
 *12. Kirjoita algoritmi joka poistaa mistä tahansa kokoelmasta A (java.util.Collection -rajapinnan
toteutus) ne alkiot joita ei löydy toisesta kokoelmasta B. Säilytetään siis ne kokoelman A
alkiot joille .equals() metodi antaa toden jollekin kokoelman B alkioita vastaan. Vihje: kaikki
kokoelmat voidaan käydä läpi foreach -toistolla, mutta silloin läpikäytävää kokoelmaa ei voi
muuttaa. Sensijaan iteraattorilla on remove() -operaatio ja kokoelmalla on operaatio remo-
ve(Object). Älä käytä valmista retainAll()-operaatiota. Mikä on algoritmisi aikavaativuus?
Miten aikavaativuus riippuu käytettävästä kokoelmasta?

        //Aikavaativuus lineaarinen o(n) 
    	//Arraylistillä aikavaativuus olisi neliöllinen o(n^2)
 */
package T12;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class TRAI_20_t12_pohja {


    // Pääohjelman käyttö:
    // java TRAI_20_t12 [N] [S]
    // missä N on alkioiden määrä, 
    // ja S on satunnaislukusiemen
    public static void main(String[] args) {

        // taulukoiden koko
        int N = 11;
        if (args.length > 0)
            N = Integer.valueOf(args[0]);

        // satunnaislukusiemen
        int siemen = 42;
        if (args.length > 1)
            siemen = Integer.valueOf(args[1]);

        java.util.Random r = new java.util.Random(siemen);
        // muodostetaan LinkedList:it
        LinkedList<Integer> L1 = new LinkedList<Integer>();
        LinkedList<Integer> L2 = new LinkedList<Integer>();
        for (int i = 0 ; i < N; i++) {
            L1.add(r.nextInt(N));
            L2.add(r.nextInt(N + 5));
        }

        if (N <= 20) {
            System.out.println("L1:" + L1);
            System.out.println("L2:" + L2);
        }


        // tehtävän 12 testaus
        System.out.println("\nLeikkaus");
        int pois = sailytaKaikki(L1, L2);

        if (N <= 20) {
            System.out.println("L1:" + L1);
            System.out.println("L2:" + L2);
        }
        System.out.println("Poistettu " + pois + " kpl");



    } // main()

    	//Aikavaativuus lineaarinen o(n) 
    	//Arraylistillä aikavaativuus olisi neliöllinen o(n^2)
    /**
     * 12. säilytä kaikki B:n alkiot A:sta, poista muut
     * @param A muutettava kokoelma
     * @param B säilytettävät alkiot
     * @param <E> parametrityyppi
     * @return poistettujen määrä
     */
    public static <E> int sailytaKaikki(Collection<E> A, Collection<E> B) {
        int pois = 0;
        
       Iterator<E> iter = A.iterator();
       
       
       while (iter.hasNext()) {
    	   if(B.contains(iter.next())) {
               iter.remove();
               pois++;
           }
       }
       
        // TODO

        return pois;
    }





} // class

