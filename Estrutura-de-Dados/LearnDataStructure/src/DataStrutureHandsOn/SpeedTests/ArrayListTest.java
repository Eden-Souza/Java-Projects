package DataStrutureHandsOn.SpeedTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {

    private static final int arrayLength = 100000;

    public static List<Integer> listBuilder(int Length) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Length; i++) {
            list.add(i);
        }
        return list;
    }

    public static void linearSearch(List<Integer> listArray) {

        long startTimeArrayBestCase = System.nanoTime();
        listArray.contains(listArray.getFirst()); // Contains retorna o valor
        long endTimeArrayBestCase = System.nanoTime();

        System.out.println(" \nBest Case " + (endTimeArrayBestCase - startTimeArrayBestCase) + " nanoseconds \n");


        long startTimeArrayWorseCase = System.nanoTime();
        listArray.contains(listArray.getLast()); // Contains retorna boolean
        long endTimeArrayWorseCase = System.nanoTime();
        System.out.println("Worst Case " + (endTimeArrayWorseCase - startTimeArrayWorseCase) + " nanoseconds \n");
    }

    public static void binarySearch(List<Integer> listArray) {

        long startTimeArrayBestCase = System.nanoTime();
        Collections.binarySearch(listArray,listArray.get(listArray.size()/2)); // retorna index
        long endTimeArrayBestCase = System.nanoTime();

        System.out.println(" \nBest Case " + (endTimeArrayBestCase - startTimeArrayBestCase) + " nanoseconds \n");


        long startTimeArrayWorseCase = System.nanoTime();
        Collections.binarySearch(listArray,listArray.getLast());
        long endTimeArrayWorseCase = System.nanoTime();

        System.out.println("Worst Case " + (endTimeArrayWorseCase - startTimeArrayWorseCase) + " nanoseconds \n");
    }

    void main() {
        List<Integer> listArray = listBuilder(arrayLength);

        System.out.println("Linear Search Test");
        linearSearch(listArray);

        IO.println("Binary Search Test");
        binarySearch(listArray);

    }
}