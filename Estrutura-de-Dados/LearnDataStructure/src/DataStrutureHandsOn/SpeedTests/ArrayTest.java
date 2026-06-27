package DataStrutureHandsOn.VelocityTests;

public class ArrayTest {
    static final int arrayLength = 10000000;

    public static int[] arrayBuilder(int arraySize) {
        int[] arrayTest = new int[arraySize];

        for (int position = 0; position < arrayTest.length; position++) {
            arrayTest[position] = position;
        }

        return arrayTest;
    }

    public static void linearSearchMethod(int[] array, int valueSearch) {
        for (int i : array) {
            if (i == valueSearch) {
                break;
            }
        }

    }

    public static void linearSearchApplication() {
        int[] arrayBuild = arrayBuilder(arrayLength);

        long startTimeBestWay = System.nanoTime();
        linearSearchMethod(arrayBuild, 0);
        long endTimeBestWay = System.nanoTime();

        System.out.println("Time to find BEST WAY " + (endTimeBestWay - startTimeBestWay) + " ns");

        long startTimeWorseWay = System.nanoTime();
        linearSearchMethod(arrayBuild, arrayLength - 1);
        long endTimeWorseWay = System.nanoTime();

        System.out.println("Time to find Worse WAY " + (endTimeWorseWay - startTimeWorseWay) + " ns");

        long startTimeNotFind = System.nanoTime();
        linearSearchMethod(arrayBuild, arrayLength + 1);
        long endTimeNotFind = System.nanoTime();

        System.out.println("Time to Not Find " + (endTimeNotFind - startTimeNotFind) + " ns");
    }

    public static void binarySearchMethod(int[] array , int valueSearch) {


        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] == valueSearch) {
                break;
            }
            if (array[middle] > valueSearch) {
                end = middle - 1;

            } else {
                start = middle + 1;

            }

        }
    }

    public static void binarySearchApplication() {
        int[] arrayBuild = arrayBuilder(arrayLength);


        long startTimeWorseWay = System.nanoTime();
        binarySearchMethod(arrayBuild,arrayLength - 1);
        long endTimeWorseWay = System.nanoTime();

        System.out.println("Time to find Worse WAY " + (endTimeWorseWay - startTimeWorseWay) + " ns");

        long startTimeBestWay = System.nanoTime();
        binarySearchMethod(arrayBuild,arrayLength/2);
        long endTimeBestWay = System.nanoTime();

        System.out.println("Time to find BEST WAY " + (endTimeBestWay - startTimeBestWay) + " ns");

        long startTimeNotFind = System.nanoTime();
        binarySearchMethod(arrayBuild,arrayLength + 1);
        long endTimeNotFind = System.nanoTime();

        System.out.println("Time to Not Find " + (endTimeNotFind - startTimeNotFind) + " ns");



    }

    void main() {
        System.out.println("ArrayTest Linear Search");
        linearSearchApplication();
        System.out.println("\n" + "Binary Search");
        binarySearchApplication();


    }
}



