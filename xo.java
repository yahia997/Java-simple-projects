/**
 * simple xo with print
*/

import java.util.Scanner;
public class xo {
  public static void main(String [] args) {
    Scanner scan = new Scanner(System.in);

    char[][] arr = {{'_', '_', '_'},{'_', '_', '_'},{'_', '_', '_'}};

    // spcifiy type of player 1
    System.out.print("Enter player 1 [X, O] : ");
    char player1 = scan.nextLine().charAt(0);

    char currentTurn = player1;

    while(true) {
      try {
        System.out.println("Turn of " + currentTurn);
        System.out.print("Enter the row :");
        int row = scan.nextInt();
        System.out.print("Enter the column :");
        int column = scan.nextInt();
        
        // Check if place is not taken before
        if(arr[row][column] == '_') {
          arr[row][column] = currentTurn;
        }else {
          System.out.println("Choose another place");
          continue;
        }
        
        // switch the player after every play
        if(currentTurn == 'X') {
          currentTurn = 'O';
        }else {
          currentTurn = 'X';
        }
        
        render(arr);

        // Check of game is end and end the game
        if(handleWin(arr)) {
          System.out.println("Game finished ---------------------------------------------------------------------------------------------------------------------");
          break;
        }
      }catch (Exception e) {
        System.out.println("Please enter a valid integer form these[0, 1, 2]");
        continue;
      }
    }
  }

  // To render the array in terminal
  public static void render(char[][] arr) {
    System.out.println("_______");
    for(char[] row : arr) {
      System.out.print("|");
      for(char cell : row) {
        System.out.print(cell);
        System.out.print("|");
      }
      System.out.print("\n");
    }
  }

  // handle win
  public static boolean handleWin(char[][] arr) {
    if(
    (arr[0][0] == 'X' && arr[0][1] == 'X' && arr[0][2] == 'X') || 
    (arr[1][0] == 'X' && arr[1][1] == 'X' && arr[1][2] == 'X') || 
    (arr[2][0] == 'X' && arr[2][1] == 'X' && arr[2][2] == 'X') ||
    (arr[0][0] == 'X' && arr[1][0] == 'X' && arr[2][0] == 'X') ||
    (arr[0][1] == 'X' && arr[1][1] == 'X' && arr[2][1] == 'X') ||
    (arr[0][2] == 'X' && arr[1][2] == 'X' && arr[2][2] == 'X') ||
    (arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X') ||
    (arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X') 
    ) {
      System.out.println("X Wins !!!");
      return true;
    }else if(
    (arr[0][0] == 'O' && arr[0][1] == 'O' && arr[0][2] == 'O') || 
    (arr[1][0] == 'O' && arr[1][1] == 'O' && arr[1][2] == 'O') || 
    (arr[2][0] == 'O' && arr[2][1] == 'O' && arr[2][2] == 'O') ||
    (arr[0][0] == 'O' && arr[1][0] == 'O' && arr[2][0] == 'O') ||
    (arr[0][1] == 'O' && arr[1][1] == 'O' && arr[2][1] == 'O') ||
    (arr[0][2] == 'O' && arr[1][2] == 'O' && arr[2][2] == 'O') ||
    (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O') ||
    (arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O') 
    ) {
      System.out.println("O Wins !!!");
      return true;      
    }else if(
    arr[0][0] != '_' && 
    arr[0][1] != '_' && 
    arr[0][2] != '_' && 
    arr[1][0] != '_' && 
    arr[1][1] != '_' && 
    arr[1][2] != '_' && 
    arr[2][0] != '_' && 
    arr[2][1] != '_' && 
    arr[2][2] != '_' 
    ) {
      System.out.println("No one has win the game !!!");
      return true;
    }
    return false;
  }
}