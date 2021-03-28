
import java.util.ArrayList;

public class TRAI_20_X2_timp implements TRAI_20_X2 {
    //                  ^^^^^ OMA TUNNUS TÄHÄN
    // Nimeä tiedosto TRAI_20_X2_tunnus.java

    /** ITSEARVIOINTI TÄHÄN
    * Tässä tehtävässä haastavinta oli keksiä tapa jolla lista saadaan suuruusjärjestykseen ilman että käyttää sort komentoa. Ratkaisun keksimiseen
    * kului paljon aikaa. Olen kuitenkin tyytyväinen vaikka kovin tehokas se ei olekaan.
    * 
    * 
    * Aikavaativuus tässä tehtävässä on O(n^4) sillä for looppeja on yhteensä 4. Lukujen lisääminen listaan ja hakeminen get komennolla on O(1).
     **/

    /**
     * Kasvavien listojen yhdiste.
     * Palauttaa sellaiset alkiot jotka löytyvät jommastakummasta tai molemmista syötelistoista.
     * Kukin alkio tulee tuloslistaan vain kerran.
     * Tuloslista tulee myös kasvavaan järjestykseen.
     * @param A ensimmäinen syötelista, alkiot kasvavassa järjestyksessä
     * @param B toinen syötelista, alkiot kasvavassa järjestyksessä
     * @return yhdistelista
     */

    @Override
    public ArrayList<Integer> kasvavienYhdiste(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> tulos = new ArrayList<Integer>();
        ArrayList<Integer> vertailulista = new ArrayList<Integer>(); //Luodaan vertailulista jolla poistetaan tuplat
        
        vertailulista.addAll(A);
        vertailulista.addAll(B);
        for (Integer luku : vertailulista) {
            //jos luku ei löydy listasta lisätään se
            if (!tulos.contains(luku)) {
                tulos.add(luku);
              
               
            }
        }
        //Käydään läpi tuloslistaa kahdella loopilla, vertaillaan onko edellinen luku suurempi kuin seuraava
        for (int i = 0; i < tulos.size()-1; i++) {
            for(int j=i+1; j <tulos.size();j++)
            {
            	//Mikäli tulos on i indexissä suurempi kuin j indexissa niin:
                if(tulos.get(i) > tulos.get(j))
                {
                	//Tallenetaan väliaikaisesti j indexin tulos
                    int temp = tulos.get(j);
                    //haetaan j indexin kohta ja asetetaan siihen i indexin tulos
                    tulos.set(j, tulos.get(i));
                    //Vastavuoroisesti haetaan i indexi ja asetetaan siihen tallennettu j tulos
                    tulos.set(i, temp);
                    
                    
                }
                
            }
         }

        return tulos;
    }

}
