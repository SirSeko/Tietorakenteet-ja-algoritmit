// TraI_18_t11_12.java SJ
// Pääohjelma viikon 2 tehtäviin 11-12

/**
  * 11. Kirjoita tehokas algoritmi joka poistaa kasvavassa järjestyksessä
  * olevasta taulukkopohjaisesta listasta (ArrayList) duplikaatit. Siis kaikki
  * sellaiset alkiot jotka jo esiintyivät samassa listalla aiemmin. Esimerkiksi
  * listasta (A C C E F F) jää jäljelle (A C E F). Älä käytä joukkotyyppejä
  * apuna. Vihje: ei kannata tehdä remove-operaatioita keskelle. Aikavaativuus?
  *
  * 12. Kirjoita tehokas algoritmi joka poistaa kasvavassa järjestyksessä
  * olevasta linkitetystä listasta (LinkedList) duplikaatit. Siis kaikki
  * sellaiset alkiot jotka jo esiintyivät samassa listalla aiemmin.  Älä käytä
  * joukkotyyppejä apuna. Vihje: linkitetyllä listalla iteraattorin
  * remove-operaatio on vakioaikainen, mutta indeksien käyttö ei.
  * Aikavaativuus?
  **/


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;



public class TRAI_20_t13_14_pohja {


    // Pääohjelman käyttö:
    // java TRAI_20_t13_14 [N] [S]
    // missä N on alkioiden määrä
    // ja S on satunnaislukusiemen
    public static void main(String[] args) {

        // taulukoiden koko
        int N = 10;
        if (args.length > 0)
            N = Integer.valueOf(args[0]);

        // satunnaislukusiemen
        int siemen = 42;
        if (args.length > 2)
            siemen = Integer.valueOf(args[2]);

        // tehtävien 11 ja 12 testaus, järjestetty lista

        Integer[] T = new Integer[N];
        // täytetään alkioilla ja lajitellaan
        java.util.Random r = new java.util.Random(siemen);
        for (int i = 0; i < N; i++) {
            T[i] = r.nextInt(N/2);
        }
        java.util.Arrays.sort(T);

        // tulostetaan taulukko jos alkioita ei ole paljoa
        if (N <= 20) {
            System.out.print("T: ");
            for (int i = 0; i < N; i++)
                System.out.print(" " + T[i]);
            System.out.println();
        }

        // muodostetaan taulukosta LinkedList ja ArrayList
        LinkedList<Integer> LL = new LinkedList<Integer>();
        ArrayList<Integer> AL = new ArrayList<Integer>(N);
        for (Integer x : T) {
            LL.add(x);
            AL.add(x);
        }


        // kutsutaan tehtävää 13
        duplikaatitPois(AL);
        System.out.print("Tehtävä 13:");
        if (N <= 20) {
            for (Integer x : AL)
                System.out.print(" " + x);
            System.out.println();
        } else
            System.out.println(AL.size());

        // kutsutaan tehtävää 14
        duplikaatitPois(LL);
        System.out.print("Tehtävä 14:");
        if (N <= 20) {
            for (Integer x : LL)
                System.out.print(" " + x);
            System.out.println();
        } else
            System.out.println(LL.size());


    } // main()


    /**
     * Tehtävä 13.
     * Duplikaattien poisto järjestetystä ArrayList listasta.
     * Lista ei sisällä null:ja.
     * @param L käsiteltävä lista
     * @param <E> alkioiden tyyppi
     */
    public static <E extends Comparable<? super E>> 
    	void duplikaatitPois(ArrayList<E> L) {
    	//Aikavaativuus lineaarinen o(n)
    	Set<E> set = new HashSet<>(L); 
    	L.clear();
    	L.addAll(set);
    	/*
    	int j = 0;
    	int i = 1;
    	
    	while ( j < L.size()) {
			//Jos indexi on pienempi kuin 0
		    if (L.get(j).compareTo(L.get(i)) == 0) {
		    	//Lisätään U:hun ja kasvatetaan j.
		    	L.remove(L.get(i));
		    	j++;
		    	i++;
		    }
    	  
		     else {
		        i++;
		        j++;
		    }
    	}
    	 */
    } // duplikaatitPois()


    
    /**
     * Tehtävä 14.
     * Duplikaattien poisto järjestetystä LinkedList listasta.
     * Lista ei sisällä null:ja.
     * @param L käsiteltävä lista
     * @param <E> alkioiden tyyppi
     */
    public static <E extends Comparable<? super E>>
    	void duplikaatitPois(LinkedList<E> L) {
    	//Aikavaativuus o(n^2)
    	/*
    	for (Iterator<E> i = L.iterator(); i.hasNext();) {
    		
    		 
    		   
    		}*/
    	for (int i = 0; i < L.size(); i++)
        {
            for (int j = i + 1; j < L.size(); j++)
            {
            	if(L.get(i).compareTo(L.get(j)) == 0) {
            		L.remove(i);
            		
            	}
               
             
            }
        }
        // TODO
    	
    } // duplikaatitPois()
    
    

} // class

