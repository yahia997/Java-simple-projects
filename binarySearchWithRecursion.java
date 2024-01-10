import java.util.Arrays;

public class binarySearchWithRecursion {
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    binarySearch(array, 5);
  }

  public static void binarySearch(int [] array, int aim)  {
    int middleIndex = (int)array.length/2;

    if(middleIndex < 0 || middleIndex >= array.length) { // base case 1 (not found)

      System.out.println("Not found");

    }else if(aim == array[middleIndex]) { // base case 2 (found)

      System.out.println("we found the aim " + aim);

    } else if(aim > array[middleIndex]) { // look at the left side of the array

      binarySearch(Arrays.copyOfRange(array, middleIndex+1, array.length), aim);

    } else if(aim < array[middleIndex]){  // look at the right side of the array

      binarySearch(Arrays.copyOfRange(array, 0, middleIndex-1), aim);

    }
  }
}
