// directory Size With Recursion
/*
 * - The directory may contains files or subDirectories
 * - Size of directory = size(f1) + size(f2) + .... + size(fm) + size(d1) + ... + size(dm)
 * - we will use File class to get size
 * 
 */


import java.io.File;
import java.util.Scanner;

public class directorySizeWithRecursion {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter a path to a Directory: ");
    String path = in.nextLine();
    File dir = new File(path);

    System.out.println("Total size in bytes = " + getDirectorySize(dir));
  }

  public static long getDirectorySize(File file) {

    // total size in bytes
    long size = 0;

    if(file.isDirectory()) { // if it is a directory
      File[] list = file.listFiles();

      for(int i = 0; list != null && i < list.length; i++) {

        size += getDirectorySize(list[i]); // recursive call

      }
    }else { // if it is file (base case)
      size += file.length();
    }

    return size; // return total size after all calculations
  }
}
