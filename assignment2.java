// Population

public class assignment2 {
  public static void main(String[] args) {
    int population = 312032486;
    int secInYear = 365 * 24 * 60 * 60; // number of seconds in a year

    for(int i = 1; i <= 5; i++) {

      // add the number of new births and immigrants
      population += (secInYear / 7) + (secInYear / 45);

      // subtract the number of new deaths
      population -= (secInYear / 13);

      System.err.println("Year " + i + " population: " + population);
    }
  }
}
