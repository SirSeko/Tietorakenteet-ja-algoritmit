

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * ITSEARVIOINTI TÄHÄN:
 * Tehtävä vaikutti haasteellisemmalta kuin lopuksi olikaan. Vaikeinta tässä tehtävssä oli ymmärtää mitä mikäkin konstruktori tekee. Tarpeeksi kauan kun debuggasi, sekin selvisi.
 * Käytin tehtävvän taulukkoa E[]
 * Onnistuin mielestäni tehtävässä hyvin. Mallia otin ArrayList2 tiedostosta.
 *
 * Tähän tehtävään en vielä lisännyt tehtäviä 32 tai 33.
 *
 * @param <E>
 */
public class TRAI_20_X8_timp<E> implements TRAI_20_X8<E> {
                     // ^^^^^ oma tunnus tähän

    int n = 0;  // alkioiden määrä renkaassa
    private E[] data;
    int p = 0;
    //private int modCount = 0;

    /**
     * Annetaan initialCapacity
     * @param initialCapacity
     */
    @SuppressWarnings({"unchecked"})
    public TRAI_20_X8_timp(int initialCapacity){
        data = (E[]) (new Object[initialCapacity]);
        n = 0;
    }

    public TRAI_20_X8_timp(){
        this(20);
    }

    /**
     * Alkioiden määrä renkaassa.
     *
     * @return Alkioiden määrän.
     */
    @Override
    public int size() {
        return n;
    }

    /**
     * Lisää renkaaseen alkion.
     *
     * @param x Lisättävä alkio
     * @return palauttaa aina tosi (aina mahtuu)
     */
    @Override
    public boolean add(E x) {

        if (n == data.length) {
            doubleCapacity();
        }
        for (int i = n; i > p; i--)
            data[i] = data[i-1];
        data[p] = x;
        n++;
        //modCount++;

        return true;
    }
    @SuppressWarnings({"unchecked"})
    private void doubleCapacity() {
        E[] data2 = (E[]) (new Object[2*data.length]);
        for (int i = 0; i < n; i++)
            data2[i] = data[i];
        data = data2;
    }

    public int first(){
        return p = 0;
    }

    public int getNext(int p) {
        if (p >= n || p < 0)
            throw new NoSuchElementException("Next: invalid position" + p);

        return p+1;
    }



    /**
     * Palauttaa seuraavan alkion renkaasta.
     * Alussa palauttaa jonkin alkion.
     * Toistuvasti kutsuttaessa palauttaa kaikkia alkioita vuorotellen.
     *
     * @return Yhden renkaan alkion.
     * @throws NoSuchElementException jollei renkaassa ole alkoita
     */
    @Override
    public E next() {
        if (n == 0){
            throw new NoSuchElementException("Rengas on tyhjä, next() ei voi kutsua!");

        }
        else if(n != 0){
            p =  getNext(p);
            if (data[p] != null){
                return data[p];
            }
            else {
                first();
                return data[p];
            }
        }

        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new iter();
    }

    private class iter implements Iterator<E> {
        int ind;
        //int initialModCount;

        public iter(){
            ind = 0;
            //initialModCount = modCount;

        }
        public int first2(){
            return ind = 0;
        }


        @Override
        public boolean hasNext() {
            return TRAI_20_X8_timp.this.hasNext();
        }

        @Override
        public E next() {

            if (data[ind] != null) {
                return data[ind++];

            } else {
                first2();
                return data[ind];
            }
        }


    }
}
