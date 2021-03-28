
import java.util.*;

public class TRAI_20_X7_timp implements TRAI_20_X7 {

    /**
     * ITSEARVIOINTI TÄHÄN:
     *
     * aikavaativuuden parametrit: m = syötejoukkojen määrä, n = syötejoukkojen yhteinen alkiomäärä.
     *
     * Tehtävän ajatus oli melko helppo ymmärtää. Haasteena tässä tehtävssä oli miettiä kuinka settejä
     * vertaillaan keskenään ja kuinka ne sitten lisätään hashmappiin. Kokeilin kahta eri tapaa käydä läpi
     * settejä. Ongelmia ilmenee siinä vaiheessa kun setissä on 0 alkio. Tätä testiä ohjelma ei läpäise oikein.
     * Myöskin viimeistä testiä ohjelma ei läpäise oikein.. Yritin tätä ongelmaa ratkaista pitkään tuloksetta.
     *
     * Aikavaativuus tällä ratkaisulla on O(m*n^2)
     *
     *
     */

    /**
     * Palauttaa tiedon siitä mitkä joukot leikkaavat keskenään (siis millä on yhteisiä alkioita).
     * Tulos palautetaan kuvauksena siten, että jos syötteen joukolla Si on yhteisiä alkioita
     * jonkun muun syötteen joukon Sj kanssa, niin kuvauksen avaimeen Si liittyvässä arvossa (joukossa) on
     * viittaus joukkoon Sj (ja päinvastoin). Kuvaus sisältää avaimenaan kunkin joukon SS sisältämän
     * joukon Si ja kunkin avaimen arvona on joukko niistä joukoista Sj joilla on vähintään yhteinen alkio
     * joukon Si kanssa.
     *
     * @param SS syöte (joukkojen joukko)
     * @return kuvaus joukkojen leikkaavuuksista
     */
    @Override
    public <E> Map<Set<E>, Set<Set<E>>> leikkaavatJoukot(Set<Set<E>> SS) {
        Map<Set<E>, Set<Set<E>>> tulos = new HashMap<>();
        Iterator<Set<E>> itr = SS.iterator();


        while(itr.hasNext()) {
            Set<E> avain = new HashSet<>();
            avain = itr.next();
            Set<Set<E>> lisattavasetti = new HashSet<>();
/*
            for (Set<E> setti : SS ) {
                   if (Collections.disjoint(setti, avain) == false && setti.containsAll(avain) == false) {
                        lisattavasetti.add(setti);

                    }

            }*/
            for (Set<E> setti : SS ) {
                Set<E> settikopio =  new HashSet<>(setti);
                if (settikopio.removeAll(avain) == true && setti.containsAll(avain) == false) {
                    lisattavasetti.add(setti);

                }

            }
            tulos.put(avain,lisattavasetti);





        }

        return tulos;
    }

}
