
import java.util.Arrays;
import java.util.Scanner;

public class test {
  public static void main(String[]args) {
    double[][] arr = {{1,1,1},{1, 2, 1},{2, 1, 2}};

    int i = 0;
    while(i < arr.length) {
      double leader = arr[i][i];

      for(int j = i+1; j < arr.length; j++) {
        double co = -((double)arr[j][i]/leader);

        for(int x = 0; x < arr[j].length; x++) {
          arr[j][x] += co * arr[i][x];
        }

      }

      i++;
    }

    System.out.println(Arrays.deepToString(arr));
  }
}
