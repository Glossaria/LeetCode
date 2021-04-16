package Utils;

import java.util.Random;

/**
 * Created on 1/26/21.
 */
public class SortUtils {

    public static int[] generateRandomArray(int size) {
        Random r = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(1000);
        }
        return arr;
    }

    public static int[] generateRandomArray(int size, int boundary) {
        Random r = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(boundary);
        }
        return arr;
    }

   public static void swap(int[] arr, int i, int target) {
        int temp = arr[i];
        arr[i] = arr[target];
        arr[target] = temp;
    }

    public static void printArray(int[] arr){
        for(int e: arr){
            System.out.print( e + ", ");
        }
    }
}
