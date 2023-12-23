// ATM machine

import java.util.Scanner;

public class assignment4 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    double balance = 5000;

    boolean exit = false;

    // the program will not end untill user enters 4
    while (!exit) {
      // show options to the user
      System.err.println("1) Withdraw the money");
      System.err.println("2) Deposite the money");
      System.err.println("3) Check the balance");
      System.err.println("4) Exit");
      
      int operation = in.nextInt();

      switch (operation) {
        case 1: // Withdraw
          System.err.println("Enter the amount you want to withdraw : ");
          double amount = in.nextDouble();

          // check if balance is sufficient
          if(balance >= amount) {
            balance -= amount;
          }else {
            System.err.println("you have not enogth money");
          }

          break;
        case 2: // Deposite
          System.err.println("Enter the amount you want to deposite : ");
          double amount2 = in.nextDouble();
          balance += amount2;
          break;
        case 3: // Check the balance
          System.err.println("Your balance now is = " + balance);
          break;
        case 4: // exit
          exit = true;
          break;
      
        default: // user enters another number
          System.err.println("Please enter a right number");
          break;
      }
    }
  }
}
