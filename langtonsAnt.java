import java.util.Arrays;
import java.util.Scanner;

public class LangtonsAnt {
    public static void main(String[] args) {
        int size, row, col, direction, steps;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Langton's Ant!");
        System.out.println("a simulation");
        System.out.println("Please enter a number for the size of the board: ");
        size = scanner.nextInt();
        System.out.println("Choose the ant's starting row (0 is the top row): ");
        row = scanner.nextInt();
        System.out.println("Choose the ant's starting column (0 is the leftmost column): ");
        col = scanner.nextInt();
        System.out.println("Choose the ant's starting direction: (0: up, 1: right, 2:down, 3:left): ");
        direction = scanner.nextInt();
        System.out.println("Enter the number of iterations that simulation run (greater than 0): ");
        steps = scanner.nextInt();

        if (row > size || col > size || direction < 0 || direction > 3 || steps < 0) {
            System.out.println("Incorrect input. Please restart and try again.");
            return; 
        }           
        Ant ant = new Ant(size, row, col, direction, steps); 
        ant.runLangtonsAnt();
    }
}

class Ant {
    int size, row, col, direction, steps;
    char board[][];
    int counter = 0;

    Ant(int sz, int rs, int cs, int ds, int st) {
        size = sz;
        row = rs;
        col = cs;
        direction = ds;
        steps = st;
        board = new char[size][size];
    }

    void createBoard() {
        for (int i = 0; i < board.length; i++){
            Arrays.fill(board[i], '_');
        }
            board[row][col] = '8';
    }

    void wrapBoard() {
        if (row >= size) {
            row = row % size;
        } else if (col >= size) {
            col = col % size;
        } else if (row < 0) {
            row = row + size;
        } else if (col < 0) {
            col = col + size;
        }
    }

    void moveUp() {
        counter += 1;
        if (board[row][col] != '#') {
            board[row][col] = '#';
            direction += 1;
            col += 1;
            this.wrapBoard();
        } else { 
            board[row][col] = '_';
            direction -= 1;
            col -= 1;
            this.wrapBoard();
        }
    }
    void moveDown() {
        counter += 1;
        if (board[row][col] != '#') {
            board[row][col] = '#';
            direction += 1;
            col -= 1;
            this.wrapBoard();
        } else { 
            board[row][col] = '_';
            direction -= 1;
            col += 1;
            this.wrapBoard();
        }
    }
    void moveLeft() {
        counter += 1;
        if (board[row][col] != '#') {
            board[row][col] = '#';
            direction += 1;
            row -= 1;
            this.wrapBoard();
        } else { 
            board[row][col] = '_';
            direction -= 1;
            row += 1;
            this.wrapBoard();
        }
    }

    void moveRight() {
        counter += 1;
        if (board[row][col] != '#') {
            board[row][col] = '#';
            direction += 1;
            row += 1;
            this.wrapBoard();
        } else { 
            board[row][col] = '_';
            direction -= 1;
            row -= 1;
            this.wrapBoard();
        }
    }

    void printBoard() {
        for (int i = 0; i < size; i++) {
            String row = Arrays.toString(board[i]).replace("[", "").replace("]", "").replace(", ", " ");
            System.out.println(row);
        }
    }

    void runLangtonsAnt() {
        this.createBoard();
        while (counter < steps) {
            if (steps == 0) {
                this.printBoard();
                return;
            } else if (direction % 2 == 0 && direction % 4 == 0) {
                this.moveUp(); 
            } else if (direction % 2 == 0 && direction % 4 == 2) {
                this.moveDown();
            } else if (direction % 4 == 3) {
                this.moveLeft();
            } else if (direction % 4 == 1) {
                this.moveRight();
            }
        } 
        board[row][col] = '8';
        this.printBoard();
    }
}

