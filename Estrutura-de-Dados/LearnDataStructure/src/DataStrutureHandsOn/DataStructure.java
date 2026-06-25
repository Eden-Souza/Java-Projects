package DataStrutureHandsOn;

import java.util.Arrays;
import java.util.Scanner;

public class DataStructure {

    public static class ArrayExercise1{
        static void main(String[] args) {
            /*
             Creat an arrya of 10 integer numbers and print only the even one
            */

            int[] arrayNumbers = new int[10];
            arrayNumbers[0] = 1;
            arrayNumbers[1] = 2;
            arrayNumbers[2] = 3;
            arrayNumbers[3] = 4;
            arrayNumbers[4] = 5;
            arrayNumbers[5] = 6;
            arrayNumbers[6] = 7;
            arrayNumbers[7] = 8;
            arrayNumbers[8] = 9;
            arrayNumbers[9] = 10;

            for (int numbers : arrayNumbers) {
                if (numbers % 2 == 0) {
                    System.out.println(numbers);
                }
            }
        }}
    public static class ArrayExercise2 {
        static void main(String[] args) {
            System.out.println("*************************** EX2");
            /* Do a program that can calculate the average of value that are into an array of grades*/
            Integer[] grades = {10, 5, 8, 3, 9, 8};

            Integer acumulator = 0;
            for (int position = 0; position < grades.length; position++) {

                acumulator += grades[position];
            }

            System.out.println("The average grade is " + acumulator / grades.length);
        }
        }

    public static class ArrayExercise3 {
        void main() {
            /* Developer an array of names and verify there is an specific name into that
            Crie um array de nomes e verifique se um nome específico existe nele.*/

            String[] names = new String[]{"Joao", "Marcos", "Mariana", "Paulo"};
            Boolean finder = false;
            Scanner systemIn = new Scanner(System.in);
            IO.println("What the name are you searching? ");
            String nameSearching = systemIn.nextLine();
            for  (String name : names) {
                if (name.equalsIgnoreCase(nameSearching)) {
                    finder = true;

                    break;
                }
            }
            if (finder) {
                System.out.println(nameSearching + " find in " + Arrays.toString(names));
            }
        }
    }

}




