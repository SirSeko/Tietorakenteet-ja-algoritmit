package x6;
import java.util.HashSet;
import java.util.Set;

public class TRAI_20_X6_timp implements TRAI_20_X6 {

    /**
     * ITSEARVIOINTI TÄHÄN:
     *  Suhteellisen helppo tehtävä. Haasteena oli miettiä kuinka settejä vertaillaan.
     *  Koodi ei ehkä kaikista näteimpää mutta se toimii. Kehityksenä voisi miettiä tarvitseeko
     *  samoja alkioita kasata yhteen settiin ja sitten poistaa lopputuloksesta vai löytyykö tähän
     *  parempi ratkaisu.
     *
     *  Aikavaativuus O(1) koska "This class offers constant time performance for the basic operations (add, remove, contains and size)"
     *
     *
     */
    /**
     * Vain yhdessä -yhdiste.
     * Luo ja palauttaa uuden joukon jossa on ne alkiot jotka ovat
     * tasan yhdessä kolmesta syötejoukosta.
     * Jos mikään alkio ei täytä ehtoa, palautetaan tyhjä joukko.
     * Ei muuta syötejoukkoja.
     *
     * @param S1 syötejoukko
     * @param S2 syötejoukko
     * @param S3 syötejoukko
     * @return tulosjoukko
     */
    @Override
    public <E> Set<E> vainYhdessa(Set<E> S1, Set<E> S2, Set<E> S3) {

        Set<E> tulos = new HashSet<>();
        Set<E> samat = new HashSet<>();
        Set<E> samat2 = new HashSet<>();
        Set<E> samat3 = new HashSet<>();
        Set<E> kaikkiSamat = new HashSet<>();


        //Vertaillaan settejä ja otetaan samat alkiot talteen
        //Lisätään s2 alkiot samat settiin
       samat.addAll(S2);
       //Säästetään ne alkiot jotka esiintyvät myös s3 setissä
        samat.retainAll(S3);
       //Lisätään s1 alkiot samat2 settiin
       samat2.addAll(S1);
       //Säästetään ne alkiot jotka esiintyvät myös s2 setissä
        samat2.retainAll(S2);
        //Lisätään s1 alkiot samat 3 settiin
        samat3.addAll(S1);
        //Säästetään ne alkiot jotka esiintyvät myös s3 setissä
        samat3.retainAll(S3);
        //Lisätään samat setit kaikkiSamat settiin
       kaikkiSamat.addAll(samat);
       kaikkiSamat.addAll(samat2);
       kaikkiSamat.addAll(samat3);
       //Lisätään muuttamattomat setit tulos settiin
        tulos.addAll(S1);
        tulos.addAll(S2);
        tulos.addAll(S3);
       //Poistetaan setistä alkiot jotka esiintyvät kaikkiSamat setissä.
       tulos.removeAll(kaikkiSamat);

        return tulos;
    }
}
