
import java.util.LinkedList;
import java.util.ListIterator;

public class TRAI_20_t11_pohja {

    /**
     * SiirrÃ¤ pienemmÃ¤t toiseen listaan.
     * Poistaa listasta kaikki sellaiset alkiot jotka edeltÃ¤vÃ¤t alkiota x.
     * (Ovat "pienempiÃ¤", eli ne alkiot a joille a.compareTo(x) < 0. Poistetut alkiot
     * siirretÃ¤Ã¤n uuteen listaan joka palautetaan.
     * Lista L sÃ¤ilyy muuten jÃ¤rjestyksessÃ¤.
     * @param L syÃ¶telista
     * @param x alkio jota pienemmÃ¤t siirretÃ¤Ã¤n
     * @return siirretyt alkiot listana
     */
    public <E extends Comparable<? super E>>  LinkedList<E> siirraPienemmat(LinkedList<E> L, E x) {

        LinkedList<E> U = new LinkedList<>();

        for (int j = 0; j < L.size() ;j++) {
			//Jos indexi on pienempi kuin 0
		    if (L.get(j).compareTo(x) < 0) {
		    	//Lisätään U:hun ja kasvatetaan j.
		    	U.add(L.get(j));
		    	L.remove(L.get(j));
		    	j--;
		    	
		    }

       
   
        }
        return U;
    }

}