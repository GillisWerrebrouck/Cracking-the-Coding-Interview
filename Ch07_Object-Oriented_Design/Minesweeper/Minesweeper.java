/**
 * Object-oriented design for Minesweeper.
 * 
 * @author Gillis Werrebrouck
 */

public class Minesweeper {
    public static void main(final String args[]) {
        
    }
}

class Cell {
    private int row;
    private int col;
    private boolean isMine;
    private int number;
    private boolean isFlagged = false;
    private boolean isExposed = false;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    public boolean isExposed() {
        return isExposed;
    }

    public void setExposed(boolean isExposed) {
        this.isExposed = isExposed;
    }
}

enum Difficulty {
    EASY,
    MEDIUM,
    HARD,
}

class Board {
    private int rows;
    private int cols;
    private int amountOfMines;
    private Cell[][] cells;
    private Cell[] mines;

    public Board(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                this.rows = 8;
                this.cols = 8;
                this.amountOfMines = 10;
                break;
        
            case MEDIUM:
                this.rows = 12;
                this.cols = 12;
                this.amountOfMines = 18;
                break;
        
            case HARD:
                this.rows = 16;
                this.cols = 16;
                this.amountOfMines = 25;
                break;
        
            default:
                break;
        }

        this.cells = new Cell[this.rows][this.cols];
        // TODO: initialize board cells
    }

    public void selectCell(Cell cell) {
        // TODO: add implementation
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell[] getMines() {
        return mines;
    }
}

enum GameState {
    WON,
    LOST,
    PENDING,
}

class Game {
    private Board board;
    private GameState state = GameState.PENDING;

    public Game(Difficulty difficulty) {
        this.board = new Board(difficulty);
    }

    public Board getBoard() {
        return board;
    }

    public GameState getState() {
        return state;
    }

    public boolean gameLoop() {
        // TODO: add implementation
        return true;
    }
}
