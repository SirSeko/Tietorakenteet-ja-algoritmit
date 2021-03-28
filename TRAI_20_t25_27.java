// TRAI_20_t25_27.java SJ
package viikko6;

import org.w3c.dom.Node;

import java.util.*;

public class TRAI_20_t25_27_pohja {

    // kannattaa testata monipuolisesti erilaisilla syötteillä ja vaikka
    // tehdä eri versioita syötteen generoinnista

    public static void main(String[] args) {

        // taulukoiden koko
        int N1 = 15;
        if (args.length > 0)
            N1 = Integer.parseInt(args[0]);

        int N2 = N1 + 2;
        if (args.length > 0)
            N2 = Integer.parseInt(args[1]);

        // satunnaislukusiemen
        int siemen = N1 + N2;
        if (args.length > 2)
            siemen = Integer.parseInt(args[2]);

        // saako olla samoja alkioita
        int eri = 0;
        if (args.length > 3)
            eri = 1;

        Random r = new Random(siemen);

        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();

        for (int i = 0; i < N1; i++) {
            L1.add(r.nextInt(N1 / 2));
        }
        for (int i = 0; i < N1; i++) {
            L2.add(r.nextInt((N2 / 2) + eri * N1));
        }

        // tulostetaan taulukot jos alkioita ei ole paljoa
        if (N1 <= 20 && N2 <= 20) {
            System.out.println("L1: " + L1);
            System.out.println("L2: " + L2);
        }

        // kutsutaan tehtävää 25
        System.out.println();
        Map<Integer, Integer> esiintymat1 = esiintymat(L1);
        for (Map.Entry<Integer, Integer> e : esiintymat1.entrySet()) {
            System.out.println("Alkio " + e.getKey() + " esiintyi " + e.getValue() + " kertaa.");
        }
        System.out.println();

        // kutsutaan tehtävää 26
        LinkedList<Integer> xorTulos = listaXor(L1, L2);

        if (N1 <= 20 && N2 <= 20) {
            System.out.println("\nTehtävä 26, vaintoisessa = " + xorTulos);
        } else {
            System.out.println(xorTulos.size() + " alkiota");
        }

        // testataan tehtävää 27
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nAnna kaksi merkkijonoa välilyönnillä erotettuna (. . lopettaaksesi): ");
            String A = sc.next();
            String B = sc.next();

            System.out.println("Ovatko anagrammit: " + ovatkoAnagrammit(A, B));

            if (A.equals(".") || B.equals("."))
                break;
        }


    } // main()


    /**
     * 25. Kirjoita algoritmi joka saa parametrinaan kokoelman (Collection<E>) ja joka muodostaa
     * ja palauttaa kuvauksen (HashMap<E, Integer>) jossa on avaimina kaikki eri alkiot jotka
     * kokoelmasta löytyvät. Kunkin avaimen kuvana on ko. esiintymien lukumäärä. Vihje: kaikki
     * kokoelmat tukevat foreach-läpikäyntiä. Aikavaativuus?
     *
     * @param C   syötekokoelma
     * @param <E> alkiotyyppi
     * @return kuvaus jossa avaimina ovat C:n alkiot ja arvona ko. alkion esiintymismäärät
     */
    public static <E> HashMap<E, Integer> esiintymat(Collection<E> C) {

        HashMap<E, Integer> es = new HashMap<>();

        Integer j = 0;
        for (E a : C){


            if(!es.containsKey(a)){
                es.put(a,1);

            }
            else if(es.containsKey(a)){
                j++;
                es.put(a,j);

            }


        }
        return es;
    }

    /**
     * 26. Kirjoita algoritmi joka saa parametrinaan kaksi järjestämätöntä linkitettyä listaa (valintasi
     * mukaan joko java.util.LinkedList tai TraLinkedList) ja joka muodostaa ja palauttaa uuden
     * listan joka sisältää kaikki ne alkiot jotka ovat vain jommastakummassa listassa (siis niiden
     * joko-tai -leikkauksen (xor)). Jos jokin alkio esiintyy jommassakummassa listassa useasti,
     * mutta ei toisessa listassa, niin se tulee tuloslistaan vain kerran. Käytä joukkoa tai kuvausta
     * (Set/Map) apuna. Vihje: mieti tarkasti ensin miten käytät joukkoa tai kuvausta hyödyksi,
     * ja ryhdy tarkentamaan algoritmiasi vasta sitten.
     *
     * @param L1  syötelista
     * @param L2  syötelista
     * @param <E> parametrityyppi
     * @return alkiot jotka ovat vain toisessa listassa
     */
    public static <E> LinkedList<E> listaXor(LinkedList<E> L1, LinkedList<E> L2) {

        LinkedList<E> tulos = new LinkedList<>();
        HashSet<E> hset = new HashSet<>();


        int i = 0;
        int j = 0;

        Iterator itr = L1.iterator();
        Iterator itr2 = L2.iterator();
        // loop stores all the elements of list1 in hset
        while (itr.hasNext()) {

            if (!hset.contains(itr.next())){

                hset.add(L1.get(i));
                i++;
            }


        }
        while(itr2.hasNext()){

            if(!hset.contains(itr2.next())) {
                hset.add(L2.get(j));
                j++;
            }

        }
        tulos.addAll(hset);

        return tulos;
    }


    /**
     * 27. Kirjoita tehokas algoritmi joka tarkastaa ovatko kaksi merkkijonoa toistensa anagrammeja
     * (muokattavissa toiseksi vain kirjainten järjestystä vaihtamalla). Siis onko merkkijonoissa
     * samat määrät kutakin eri kirjainta. Algoritmi saa parametrinaan kaksi merkkijonoa ja
     * palauttaa totuusarvon. Vihje: laske kirjainten esiintymismäärät kuvaukseen. Koska nyt
     * harjoittelemme kuvauksen käyttöä, älä käytä taulukoiksi-lajittele-vertaa -ratkaisua vaikka
     * se helppo onkin. Mikä on algoritmisi aikavaativuus?
     *
     * @param A syötemerkkijono
     * @param B syötemerkkijono
     * @return true jos A ja B ovat toistensa anagrammeja, muuten false
     */
    public static boolean ovatkoAnagrammit(String A, String B) {
        HashMap<Character, Integer> hashMap1
                = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hashMap2
                = new HashMap<Character, Integer>();

        char lista1[] = A.toCharArray();
        char lista2[] = B.toCharArray();

        // Mapataan eka stringi
        for (int i = 0; i < lista1.length; i++) {

            if (hashMap1.get(lista1[i]) == null) {

                hashMap1.put(lista1[i], 1);
            }
            else {
                Integer c = (int)hashMap1.get(lista1[i]);
                hashMap1.put(lista1[i], ++c);
            }
        }

        // Mapataan seuraava stringi
        for (int j = 0; j < lista2.length; j++) {

            if (hashMap2.get(lista2[j]) == null)
                hashMap2.put(lista2[j], 1);
            else {

                Integer d = (int)hashMap2.get(lista2[j]);
                hashMap2.put(lista2[j], ++d);
            }
        }

        if (hashMap1.equals(hashMap2))
            return true;
        else
            return false;
    }

} // class

