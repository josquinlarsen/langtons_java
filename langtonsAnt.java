import java.util.Arrays;
import java.util.Scanner;

public class LangtonsAnt {
    public static void main(String[] args){
        int size, rowStart, colStart, direction, steps;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Langton's Ant!");
        System.out.println("a simulation");
        System.out.println();
        System.out.println("Please enter number less between 5 and 100 for the size of the square board: ");
        size = scanner.nextInt();
        System.out.println("Choose the ant's starting row (0 is the top row): ");
        rowStart = scanner.nextInt();
        System.out.println("Choose the ant's starting column (0 is the leftmost columnt): ");
        colStart = scanner.nextInt();
        System.out.println("Choose the ant's starting direction: (0: up, 1: right, 2:down, 3:left): ");
        direction = scanner.nextInt();
        System.out.println("Enter the number of iterations that simulation run (greater than 0): ");
        steps = scanner.nextint();

        if (size < 5| size > 100 | rowStart < 0 | rowStart > size | colStart < 0 | colStart > size | direction < 0 | direction > 4 ) {
            System.out.println("Incorrect input. Please restart and try again.");
            return; 
        }           
    }
}

class Ant {
    int size, rowStart, colStart, direction, steps;
    char board[][];
    int counter = 1;

    Ant(int sz, int rs, int cs, int ds, int st);{
        size = sz;
        rowStart = rs;
        colStart = cs;
        direction = ds;
        steps = st;
        newBoard = char[size][size];
    }
    void createBoard() {
        for (int i = 0; i < newBoard.length; i ++ ){
            Arrays.fill(newBoard[i], '_');
        }
        newBoard[rowStart][colStart] = "8";
    }
}

