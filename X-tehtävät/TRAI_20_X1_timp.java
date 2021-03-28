import java.util.HashSet;
import java.util.Set;

public class TRAI_20_X1_timp implements TRAI_20_X1 {
    //                  ^^^^^ OMA TUNNUS TÄHÄN
    // Nimeä tiedosto TRAI_20_X1_tunnus.java

    /**
     * Itsearviointi:
     * Haasteena tässä tehtävässä oli muistella menneitä. Ohjelmointi 3 kurssin kävin yli vuosi sitten. 
     * Vastaukseen käytinkin HashSettiä joka tuli ensimmäisenä mieleeni. Se on tehokas tapa vertailla lukuja keskenään.
     * Mikäli lista sisältää tuplan palauttaa se true,
     * muussa tapauksessa false.
     * Aikavaativuutta en osaa vielä kertoa sillä se on vielä hieman epäselvä konsepti. 
     * Pyrin tekemään koodista mahdollisimman kompaktin ja tehokkaan, parannusehdotuksia en tässä vaiheessa keksi.
     * 
     * Onko tuplaa.
     * Jos siis taulukon kaikki alkiot ovat eri lukuja, metodi
     * palauttaa false. Jos taas jokin (tai jotkin) luku esiintyy
     * kahdesti tai useammin, metodi palauttaa true.
     * Voit olettaa taulukossa olevan vain kelvollisia kokonaislukuja
     * (ei siis null:eja).
     *
     * @param A Syötetaulukko.
     * @return false jos kaikki alkiot ovat eri lukuja, muuten true.
     */
    @Override
    public boolean onkoTuplaa(Integer[] A) {
         //Luodaan uusi HashSet
        Set<Integer> setti = new HashSet<Integer>();
        // Tarkistetaan listan luvut ja verrataan niitä keskenään. Palautetaan true mikäli luku on tupla.
        for (Integer luku: A) if (!setti.add(luku)) return true;
        // Muuten palautetaan false
        return false;

    }
}
