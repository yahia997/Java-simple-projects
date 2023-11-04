/*
 * App to convert any Number System to another Number System
 * base rang {2, ....,  16}
 *  Made my yahia Mahmoud
*/
import java.util.Scanner;
class Main {
  public static void main(String[]args) {
    while(true)  {
      try {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        System.out.println("*** All letters have to be capital");
        System.out.println("*** The largest base is 16");
        System.out.println("*** Enter Integer only");
        String num = scan.nextLine();
        System.out.println("Enter the current number base : ");
        int base1 = scan.nextInt();
        System.out.println("Enter the new base : ");
        int base2 = scan.nextInt();
        
        // Convert from any base to decimal
        int decimal = 0;
        int power = 0;
        for(int i = num.length()-1; i >= 0; i--) {
          switch (num.charAt(i)) {
            case 'A':
            decimal += 10 * Math.pow(base1, power);
            break;
            case 'B':
            decimal += 11 * Math.pow(base1, power);
            break;
            case 'C':
            decimal += 12 * Math.pow(base1, power);
            break;
            case 'D':
            decimal += 13 * Math.pow(base1, power);
            break;
            case 'E':
            decimal += 14 * Math.pow(base1, power);
            break;
            case 'F':
            decimal += 15 * Math.pow(base1, power);
            break;
            default:
            decimal += Integer.parseInt(num.charAt(i) + "") * Math.pow(base1, power);
            break;
          }
          power++;
        }
    
        
        // Convert from decimal to any base
        String result = "";
        while(decimal != 0) {
          switch (decimal%base2) {
            case 10:
            result = result.concat("A");
            break;
            case 11:
            result = result.concat("B");
            break;
            case 12:
            result = result.concat("C");
            break;
            case 13:
            result = result.concat("D");
            break;
            case 14:
            result = result.concat("E");
            break;
            case 15:
            result = result.concat("F");
            break;
            default:
            result = result.concat(Integer.toString(decimal%base2));
            break;
          }
          decimal /= base2;
        }
        // reverse the result
        String rightR = "";
        for(int i = 0; i < result.length(); i++) {    
          rightR = result.charAt(i) + rightR;
        }
        
        System.out.println("=> " + rightR);
      }catch (Exception e){
        System.out.println("Wrong !");
      }
      System.out.println("--------------------------------------------");
    }
  }
}
