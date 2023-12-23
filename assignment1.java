// BMI

import java.util.Scanner;

public class assignment1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // ask user to enter weight in pounds and convert it to kilogram
    System.err.println("Enter weight in pounds : ");
    double w = in.nextDouble() * 0.45359237; // in kilogram

    // ask user to enter height in inches and convert it to meter
    System.err.println("Enter height in inches : ");
    double h = in.nextDouble() * 0.0254; // in meter

    // calculate BMI
    double BMI = w/(h * h);

    // display result depending on BMI
    if(BMI < 18.5) {
      System.err.println("Underweight");
    }else if (BMI >= 18.5 && BMI < 25) {
      System.err.println("Normal");
    }else if (BMI >= 25 && BMI < 30) {
      System.err.println("Overweight");
    }else {
      System.err.println("Obese");
    }

  }
}