// TRAI_20_t17.java SJ

/**
 * 17) Palindromi on merkkijono joka myös takaperin luettuna on sama. Kun
 * sana talletetaan pakkaan merkki kerrallaan, on helppoa tarkastaa onko
 * sana palindromi vai ei. Kirjoita algoritmi joka tallettaa merkkijonon
 * merkit pakkaan ja joka tarkastaa onko pakan sisältö palindromi vai ei.
 * Ota kurssin www-sivulta pääohjelma jossa on vinkkejä miten merkkijono
 * muutetaan pakaksi. Aikavaativuus?
 */
package t17;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TRAI_20_t17_pohja {


    // Pääohjelman käyttö:
    // java TRAI_20_t17 [merkkijono]
    public static void main(String[] args) {

        String mjono = null;

        if (args.length > 0)
            mjono = args[0];

        if (mjono == null) {
            System.out.print("Anna merkkijono : ");
            Scanner sc = new Scanner(System.in);
            mjono = sc.nextLine();
        }

        System.out.print("Merkkijono '" + mjono + "' ");
        if (onkoPalindromi(mjono))
            System.out.println("on palindromi");
        else
            System.out.println("ei ole palindromi");

    } // main()



    /**
     * Merkkijonosta merkkipakka.
     * @param S syötemerkkijono
     * @return merkit pakassa
     */
    public static Deque<Character> merkkijonostaPakka(String S) {
        Deque<Character> D = new ArrayDeque<>();

        for (int i = 0; i < S.length(); i++)
            D.addLast(S.charAt(i));

        return D;

    }


    /**
     * Onko merkkijono palindromi vai ei?
     * @param S syötemerkkijono
     * @return totuusarvo
     */
    public static boolean onkoPalindromi(String S) {
    	
    	Deque<Character> A = new ArrayDeque<>();
    	 for (int i = 0; i < S.length(); i++) {
    		 
             A.addLast(S.charAt(i));
    	 }	
    	 for (int i = 0; i < S.length(); i++) {
    		 
             if(A.pollFirst() == A.pollLast()) {
            	
            	 
             }
             else return false;
    	 }	
    	
    	
        
        return true;
    }



} // class

