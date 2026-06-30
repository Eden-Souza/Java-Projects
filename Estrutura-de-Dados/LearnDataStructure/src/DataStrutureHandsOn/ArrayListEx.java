package DataStrutureHandsOn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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

    public static class ArrayListExercises2 {
        static void main( String[] args) {
            List<Integer> numbers = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    numbers.add(i);
                }
                IO.println(numbers);
            }
    }

    public static class ArrayListExercises3 {
        static void main( String[] args) {
            int counter = 0;
            List<Integer> numbers = new ArrayList<>();

            while (counter < 10) {
                numbers.add(counter);
                counter++;
            }
            IO.println(numbers);

        }
    }

    public static class ArrayListExercises4 {
        static void main( String[] args) {
            List<Integer> numbers = new LinkedList<>();

            for  (int i = 0; i < 10; i++) {
                numbers.add(i);
            }

            IO.println(numbers);

        }
    }

}

