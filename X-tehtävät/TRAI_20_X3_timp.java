
import java.util.ArrayList;

public class TRAI_20_X3_timp implements TRAI_20_X3 {
    /**
     * Tämä tehtävä tuntui jo helpommalta kuin aiemmat. Arraylistin käyttö on ennestään tuttua. Haasteena tässä tehtävässä oli
     * miettiä kuinka A-listasta poistetaan pienemmät alkiot ilman remove komentoa. Mielestäni ratkaisu toimii hyvin ja on lineaarinen
     * aikavaativuudeltaan sillä A lista käydään vain kerran läpi. Muut komennot ovat o(1) luokkaa
     * Aikavaativuus: o(n) 
     *
     *
     */


    /**
     * Siirrä pienemmät toiseen listaan.
     * Poistaa listasta kaikki sellaiset alkiot jotka edeltävät alkiota x.
     * (Ovat "pienempiä", eli ne alkiot a joille a.compareTo(x) < 0. Poistetut alkiot
     * siirretään uuteen listaan joka palautetaan.
     * Lista A säilyy muuten järjestyksessä.
     * @param A syötelista
     * @param x alkio jota pienemmät siirretään
     * @return siirretyt alkiot listana
     */
    @Override
    public <E extends Comparable<? super E>>  ArrayList<E> siirraPienemmat(ArrayList<E> A, E x) {

        ArrayList<E> U = new ArrayList<>();
 
        int a = 0;
        int j = 0;
        //Käydään läpi niin kauan kun j < A
		while (j < A.size()) {
			//Jos indexi on pienempi kuin 0
		    if (A.get(j).compareTo(x) < 0) {
		    	//Lisätään U:hun ja kasvatetaan j.
		    	U.add(A.get(j));
		    	j++;
		    //Tai muuten jos a < j
		    } else if (a < j) {
		    	//Lisätään A:han a indexiin j indexin alkio
		    	  A.set(a++, A.get(j++));
		    //Muuten kasvatellaan laskureita
		    } else {
		        a++;
		        j++;
		    }
		}
		//Haetaan listan koko ja trimmataan ylimääräiset luvut listasta.
		int vanhaKoko = A.size();
		int uusiKoko = vanhaKoko - j + a;
		A.subList(uusiKoko, vanhaKoko).clear();

        return U;
    }

}
