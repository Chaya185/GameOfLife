package TheGameOfLife;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter the size of your grid: ");

        // Read a line of text from the console
        int size = scanner.nextInt();

        //Create a GameOfLife object with users size grid
        implementGrid game = new implementGrid(size);
        implementVisual visual = new implementVisual(size);
        game.initialize();

        // Example: Glider pattern
        game.board[1][2] = true;
        game.board[2][3] = true;
        game.board[3][1] = true;
        game.board[3][2] = true;
        game.board[3][3] = true;

        // Prompt the user for input
        System.out.print("Enter the number of updates you'd like to see: ");

        // Read a line of text from the console
        int numDisplay = scanner.nextInt();

        //loop through the simulation the amount of times the user requested
        for (int i = 0; i < numDisplay; i++){
            game.update();
            visual.display(game.getBoard());
        }
    }
}
