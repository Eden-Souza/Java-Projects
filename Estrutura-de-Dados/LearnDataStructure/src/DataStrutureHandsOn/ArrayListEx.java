package DataStrutureHandsOn;

import java.security.IdentityScope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListEx {

    public static class ArrayListExercise {
        static void main( String[] args) {
            /* Create an ArrayList of Strings whit city names and print at a desc sort*/
            /* implemente ordenation algorithmen */

            List<String> cityNames = new ArrayList<>();
            cityNames.add("San Francisco");
            cityNames.add("British Columbia");
            cityNames.add("Sao Paulo");
            cityNames.add("Ituiutaba");

            Collections.sort(cityNames); //Crescente
            Collections.reverse(cityNames); // Decrescente

            System.out.println(cityNames);
        }
    }
}
