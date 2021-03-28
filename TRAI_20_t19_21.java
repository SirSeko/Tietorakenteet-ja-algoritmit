// TRAI_20_t19_21.java.java SJ

/**
 * 27. Kirjoita algoritmi joka laskee annetun binääripuun korkeuden, ts. pisimmän polun juuresta
 * lehtisolmuun. Aikavaativuus? Vihje: rekursio.
 * 28. Kirjoita algoritmi joka etsii binääripuun matalimman (vähiten syvän) lehtisolmun. Vihje:
 * tasoittainen läpikäynti. Aikavaativuus?
 * 29. Kirjoita algoritmi joka tarkistaa onko annettu binääripuu sisäjärjestyksessä. Jos binääripuus-
 * sa on alkioita jotka eivät ole keskenään oikeassa järjestyksessä, algoritmi palauttaa epätoden,
 * muuten toden. Parametrina binääripuu, palautusarvona totuusarvo. Mikä on algoritmisi
 * aikavaativuus?
 **/

import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class TRAI_20_t19_21_pohja {

    public static void main(String[] args) {

        BTree<Integer> puu = null;

        int N = 15;
        if (args.length > 0)
            N = Integer.valueOf(args[0]);


        // testataan ensin vakiopuulla

        puu = exampleBTree();
        System.out.println("Sisäjärjestyksessä:");
        inorderPrint(puu);

        System.out.println("Korkeus = " + korkeus(puu));

        System.out.println("Matalin yksilapsinen solmu = " + matalinYksilapsinen(puu).getElement());

        BTree<Integer> puu2 = exampleBTree();

        System.out.println("Samat rakenteet : " + vertaaRakenne(puu, puu2));

        System.out.println("Lisätään: 7");
        inorderInsert(puu, 7);
        System.out.println("Samat rakenteet : " + vertaaRakenne(puu, puu2));

        System.out.println();


        // tehdään vielä uusi generoitu

        puu = new BTree<Integer>();


        System.out.println("\nPuuhun:");
        Random r = new Random(42);
        Integer x = null;
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N * 2);
            System.out.print(x + " ");
            inorderInsert(puu, x);
        }
        System.out.println();

        System.out.println("Sisäjärjestyksessä:");
        inorderPrint(puu);

        System.out.println("Korkeus = " + korkeus(puu));

        System.out.println("Matalin yksilapsinensolmu = " + matalinYksilapsinen(puu).getElement());

    } // main()

    /**
     * 19. Puun korkeus. Käynnistysmetodi
     *
     * @param t tarkasteltava binääripuu.
     * @return puun korkeus tai -1 jos puu on tyhjä
     **/
    public static <E> int korkeus(BTree<E> t) {
        // TODO
        return 0;
    }

    /**
     * 20. Kirjoita algoritmi joka etsii binääripuun matalimman (vähiten syvän) sellaisen solmun jolla
     * on tasan yksi lapsi. Vihje: tasoittainen läpikäynti. Aikavaativuus?
     *
     * @param T   binääripuu
     * @param <E> alkiotyyppi (ei käytössä)
     * @return matalin yksilapsinen solmu tai null jollei sellaista ole
     **/
    public static <E> BTreeNode<E> matalinYksilapsinen(BTree<E> T) {

        // TODO
        return null;

    } // matalinYksilapsinen()


    /**
     * 21. Kirjoita algoritmi, joka vertaa kahta binääripuuta ja palauttaa toden jos puut ovat raken-
     * teeltaan samat, muuten epätoden. Puut ovat samat, jos juuren molemmat alipuut ovat
     * keskenään rakenteeltaan samanlaiset. Puun sisältämiä elementtejä ei siis vertailla, vain puun
     * rakennetta (”oksaston muotoa”). Aikavaativuus? Tilavaativuus? Vihje: rekursio rinta rinnan.
     *
     * @param T1  syötepuu1
     * @param T2  syötepuu2
     * @param <E> alkiotyyppi (ei käytetä)
     * @return ovatko rakenteeltaan samat vai ei
     */
    public static <E> boolean vertaaRakenne(BTree<E> T1, BTree<E> T2) {
        // TODO
        return false;
    } // vertaaRakenne()


    // esimerkkejä ja pohjia


    public static BTree<Integer> exampleBTree() {

        BTree<Integer> T = new BTree<Integer>();

        // juuri
        T.setRoot(new BTreeNode<Integer>(9));

        BTreeNode<Integer> n = T.getRoot();

        // juuren lapset
        n.setLeftChild(new BTreeNode<Integer>(5));
        n.setRightChild(new BTreeNode<Integer>(15));

        // vasen haara
        BTreeNode<Integer> l = n.getLeftChild();

        l.setLeftChild(new BTreeNode<Integer>(3));
        l.setRightChild(new BTreeNode<Integer>(8));

        l.getLeftChild().setRightChild(new BTreeNode<Integer>(4));

        // oikea haara
        l = n.getRightChild();

        l.setLeftChild(new BTreeNode<Integer>(12));
        l.setRightChild(new BTreeNode<Integer>(18));

        l.getLeftChild().setLeftChild(new BTreeNode<Integer>(11));
        l.getLeftChild().setRightChild(new BTreeNode<Integer>(13));


        System.out.println("                 ");
        System.out.println("       9        ");
        System.out.println("    __/  \\__     ");
        System.out.println("   5        15   ");
        System.out.println("  / \\      /  \\  ");
        System.out.println(" 3   8   12    18");
        System.out.println("  \\      /\\      ");
        System.out.println("   4    11 13    ");
        System.out.println("                 ");

        return T;

    } // exampleBTree()


    /**
     * 22. Lisäys sisäjärjestettyyn binääripuuhun.
     *
     * @param T binääripuu
     * @param x lisättävä alkio
     * @return tehtiinkö lisäys vai ei
     */
    public static <E extends Comparable<? super E>> boolean inorderInsert(BTree<E> T, E x) {

        BTreeNode<E> n = T.getRoot();
        if (n == null) {
            T.setRoot(new BTreeNode<E>(x));
            return true;
        }

        while (true) {

            if (x.compareTo(n.getElement()) == 0)
                // x jo puussa, ei lisata
                return false;

            else if (x.compareTo(n.getElement()) < 0) {
                // x edeltaa n:n alkiota
                if (n.getLeftChild() == null) {
                    // lisayskohta loydetty
                    n.setLeftChild(new BTreeNode<E>(x));
                    return true;
                } else
                    n = n.getLeftChild();
            } else {
                // x suurempi kuin n
                if (n.getRightChild() == null) {
                    // lisayskohta loydetty
                    n.setRightChild(new BTreeNode<E>(x));
                    return true;
                } else
                    n = n.getRightChild();
            }
        } // while

    } // inorderInsert()


    // Tulostus sisäjärjestyksessä rekursiivisesti
    public static void inorderPrint(BTree T) {
        inorderPrintBranch(T.getRoot());
        System.out.println();
    } // inorderPrint()


    public static void inorderPrintBranch(BTreeNode n) {
        if (n == null)
            return;

        inorderPrintBranch(n.getLeftChild());
        System.out.print(n.getElement() + " ");
        inorderPrintBranch(n.getRightChild());

    } // inorderPrintBranch()


} // class TRAI_20_t19_21.java
