// Palindrome number

import java.util.Scanner;

public class assignment3 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int num = 1235321;
    System.err.println(ispalindrome(num));
    System.err.println(specialSolution(num));
  }

  // method to determine if the number is palindrome
  public static boolean ispalindrome(int num) {

    // first get length of the number
    int i = 10;
    int length = 1;

    while (num / i > 0) {
      length += 1;
      i *= 10;
    }

    int LHS = (int)Math.pow(10, length-1);
    int RHS = 1;

    // To decrease number of loop to half
    for(int j = 0; j < length/2.0; j++) {
      
      // If the number on the right not equal number on the left
      if((num / LHS)%10 != (num / RHS)%10) {
        // number is not palindrome
        return false;
      }

      LHS /= 10;
      RHS *= 10;
    }

    // number is palindrome
    return true;
  }

  // Another way to do this by method we don not take until this moment
  public static boolean specialSolution(int num) {

    // convert number to string
    String str = Integer.toString(num);

    for(int i = 0; i < str.length()/2.0; i++) {

      // If the number on the right not equal number on the left
      if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
        return false;
      }
    }

    return true;
  }
}
