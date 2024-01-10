import java.util.Scanner;
import java.util.Arrays;

public class selectionSortwithRecursion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {7, 6, 5, -10, -1, 3, 0, 4, 3, 2, 1};

        selectionSort(arr);
        
    }

    public static void selectionSort(int[] array) {
        selectionSort(array, 0, array.length-1);
    }

    public static void selectionSort(int[] array, int start, int end) {
        if(start == end) // base case
            System.out.println(Arrays.toString(array));
        else{
            // find smallest number

            int smallest = array[start];
            int index = start;
            for(int i = start; i <= end; i++) {
                if(array[i] < smallest){
                    smallest = array[i];
                    index = i;
                }
            }

            // swap
            array[index] = array[start];
            array[start] = smallest;

            selectionSort(array, start+1, end);
        }
    }
}
