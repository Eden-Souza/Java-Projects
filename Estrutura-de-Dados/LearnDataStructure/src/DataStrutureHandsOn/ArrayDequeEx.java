package DataStrutureHandsOn;

import java.util.ArrayDeque;

public class ArrayDequeEx {

    public static void FifoEx() {
        //Challenge Building a Queue
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 1; i <= 10; i++) {
            IO.println(i);
            if (i % 2 == 0) {
                continue;
            }
            numbers.addLast(i);
            IO.println("get into Last Position" + numbers);
            if (i % 3 == 0) {
                continue;
            }
            numbers.removeFirst();
            IO.println("Get Out First Position" + numbers);

        }
    }

    public static void LifoEx() {
        // Challenge building a Stack
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i =1; i<=10; i++) {
            IO.println(i);
            if (i % 2 == 0) {
                continue;
            }
            numbers.addFirst(i);
            IO.println("get into First Position" + numbers);
            if  (i % 3 == 0) {
                continue;
            }
            numbers.removeFirst();
            IO.println("Get Out Last Position" + numbers);

        }

    }

    public static void ChallengerEx() throws InterruptedException {
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        //Piority List Even numbers is High Priority and odd is Low Priority
        for (int i = 1; i <= 10; i++) {
            if  (i % 2 == 0) {
                numbers.addFirst(i);
                IO.println("get into First Position Hight" + numbers + "\n") ;
            } else{
                numbers.addLast(i);
                IO.println("get into Last Position Low" + numbers + "\n");
            }
            Thread.sleep(3000);

            if (i % 3 == 0 || i % 2 != 0) {
                continue;
            }
            numbers.removeFirst();
            IO.println("Get Out First Position" + numbers + "\n");
        }
    }

    static void main() throws InterruptedException {
        IO.println("Building a queue \n");
        FifoEx();
        IO.println("Building a Stack \n");
        LifoEx();
        IO.println("Building a Priority System \n");
        ChallengerEx();
       }
    }

