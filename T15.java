package testietet;
import fi.uef.cs.tra.*;

public class TRAI_20_t15_pohja {
   

    /**
     * Järjestettyjen listojen joko-tai-yhdiste.
     * Muodostaa uusen järjestetyn listan niistä syötelistojen alkioista jotka esiintyvät vain
     * toisessa syötelistoista.
     * Ei muuta syötelistoja.
     *
     * @param A syötelista, kasvavassa järjestyksessä
     * @param B syötelista, kasvavassa järjestyksessä
     * @param <E> alkiotyyppi, toteuttaa Comparable-rajapinnan
     * @return uusi lista jossa kasvavassa järjestyksessä ne alkiot jotka ovat vain yhdessä syötelistassa
     */
	
    public <E extends Comparable<? super E>> TraLinkedList<E>
                    jarjestettyjenVainToisessaYhdiste(TraLinkedList<E> A, TraLinkedList<E> B) {
        TraLinkedList<E> tulos = new TraLinkedList<E>();

        ListNode<E> pa = A.first();
        ListNode<E> pb = B.first();
        
        // toisto kunnes molemmat ovat loppuneet
        // toki voit tehdä myös toiston joka loppuu kun toinen loppuu ja täydentää perään
        while (pa != A.EOL || pb != B.EOL) {
        	
        	if(pa.next() != pb.next() && pb.next() != pb.previous()) {
        		tulos.insert(jotain, pa.next());
        		//add
        	}
        	else if(pa.next() == pa.previous()) {
        		// add
        	}
        	else if(pb.next() == pb.previous()) {
        		//add
        	}
        	
        	
        }

        return tulos;
    }
  
}
