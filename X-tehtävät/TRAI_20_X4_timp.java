

import java.util.LinkedList;

import java.util.ListIterator;

public class TRAI_20_X4_timp implements TRAI_20_X4 {
    //                  ^^^^^ oma tunnus tähän
    /**
     * Tämä tehtävä oli haastava, en saanut toimivaa ratkaisua tehtyä vaikka n. 10 tuntia tähän käytinkin. En näe syytä miksi näin haastavia tehtäviä annetaan.
     * Tästä syystä myös linkedlistin toimivuus jäi hämäräksi. Muutama vinkki olisi voinut auttaa..
     * Aikavaativuus o(n)
     * 
     *
     *
     */

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
    @Override
    public <E extends Comparable<? super E>> LinkedList<E>
                    jarjestettyjenVainToisessaYhdiste(LinkedList<E> A, LinkedList<E> B) {
        LinkedList<E> tulos = new LinkedList<E>();
        LinkedList<E> testi = new LinkedList<E>();
        
        ListIterator<E> A1 = A.listIterator();
        ListIterator<E> B1 = B.listIterator();
        ListIterator<E> C1 = tulos.listIterator();

      while (A1.hasNext() && B1.hasNext()) {
        	E Aalkio = A1.next();
        	E Balkio = B1.next();
        	if(Aalkio.compareTo(Balkio) != 0) {
        		
        		if(C1.hasPrevious() == false && Aalkio.compareTo(Balkio) < 0) {
         			C1.add(Aalkio);
         			C1.add(Balkio);
         			
        		}
        		else if (C1.hasPrevious() == false && Aalkio.compareTo(Balkio) > 0){
        			C1.add(Balkio);
        			C1.add(Aalkio);
        			
        		}
        		
        		else if (C1.hasPrevious() == true && C1.previous().compareTo(Aalkio) !=0 && C1.previous().compareTo(Balkio) !=0 && Aalkio.compareTo(Balkio) < 0) {
         			C1.add(Aalkio);
        			C1.add(Balkio);
            	}
         		else if (C1.hasPrevious() == true && C1.previous().compareTo(Aalkio) !=0 && C1.previous().compareTo(Balkio) !=0 && Aalkio.compareTo(Balkio) > 0) {
         			C1.add(Balkio);
         			C1.add(Aalkio);
         			
         		}
         		else if (C1.hasPrevious() == true && C1.previous().compareTo(Balkio) ==0) {
        			C1.add(Balkio);
            	}
         		else if (C1.hasPrevious() == true && C1.previous().compareTo(Aalkio) ==0) {
        			C1.add(Balkio);
         		}
         		
         		else if (C1.hasPrevious() == true && A1.previous().compareTo(Aalkio) ==0 && A1.previous().compareTo(Balkio) !=0) {
         			C1.add(Aalkio);
         		}
         		else if (C1.hasPrevious() == true && B1.previous().compareTo(Aalkio) !=0 && B1.previous().compareTo(Balkio) ==0) {
         			C1.add(Balkio);
         		}
        		
        	}
        	else if(C1.hasPrevious() == true && Aalkio.compareTo(Balkio) == 0 && Aalkio.compareTo(C1.previous()) == 0) {
        		C1.previous();
        		C1.remove();
        	}
        
        }
      return tulos;
       
    }
    
  	  
}
